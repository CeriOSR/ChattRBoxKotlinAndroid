package com.ceriosrey.chattrbox

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.media.MediaPlayer
import android.media.MediaRecorder
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.provider.MediaStore
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat.checkSelfPermission
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.*
import io.realm.Realm
import io.realm.RealmQuery
import io.realm.RealmResults
import java.io.File
import java.io.IOException
import java.util.*

class AddItemActivity : AppCompatActivity(), MediaPlayer.OnCompletionListener {

    private val internalStorageProvider = InternalStorageProvider(this)
    private var recorder: MediaRecorder? = null
    private var player: MediaPlayer? = null
    private var tempFile: File? = null
    private var handler: Handler? = null
    private var imageViewAddItem: ImageView? = null
    private val recordRequestCode = 101
    private val storageReadCode = 103
    private var buttonRecord: Button? = null
    private var chooseImageButton: Button? = null
    private var buttonPlaySample: Button? = null
    private var editTextName: EditText? = null
    private var imageName: String? = null
    private var audioName: String? = null
    private var saved: Boolean = false
    private var itemId: String? = null
    private var result: RealmResults<ChattRItem>? = null
    private var spinnerCategory: Spinner? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_item)
        title = "Add Item"

        editTextName = findViewById(R.id.editText_name)
        buttonPlaySample = findViewById(R.id.button_play_sample)
        buttonRecord = findViewById(R.id.button_record)
        imageViewAddItem = findViewById(R.id.imageView_add_item)
        chooseImageButton = findViewById(R.id.buttonChooseImage)
        spinnerCategory = findViewById(R.id.spinnerCategory)

        //hide audio buttons
        buttonPlaySample?.isEnabled = false
        buttonRecord?.isEnabled = false

        saved = false
        itemId = UUID.randomUUID().toString()

        val categoryArray = arrayOf("Essentials", "Activities", "Places", "People")
        spinnerCategory?.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, categoryArray)
        spinnerCategory?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                spinnerCategory?.textAlignment = position
                if (spinnerCategory?.selectedItem == "People") {
                    setupRecordPermission()
                    buttonRecord?.isEnabled = true
                    buttonPlaySample?.isEnabled = false
                } else {
                    buttonPlaySample?.isEnabled = false
                    buttonRecord?.isEnabled = false
                }
            }
        }

        chooseImageButton?.setOnClickListener {
            chooseImageClicked()
        }

        buttonPlaySample?.setOnClickListener {
            play()
            buttonRecord?.isEnabled = false
        }

        buttonRecord?.setOnClickListener {
            record()
            it.isEnabled = false
            buttonPlaySample?.isEnabled = false
            handler = Handler()
            handler?.postDelayed(
                    { stopRecord() },
                    4000
            )
        }
    }

    private fun setupRecordPermission() {
        val permissionRecord = checkSelfPermission(this, Manifest.permission.RECORD_AUDIO)

        if (permissionRecord != PackageManager.PERMISSION_GRANTED) {

            Log.i("Permission to Add Item", "DENIED")
            buttonPlaySample?.isEnabled = false
            buttonRecord?.isEnabled = false
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.RECORD_AUDIO)) {
                val builder = AlertDialog.Builder(this)
                builder.setMessage("Permission needed for Mic to be able to record user.").setTitle("Permission Required")
                builder.setPositiveButton("Ok") { _, _ ->
                    recordPermissionRequest()
                }
                val dialog = builder.create()
                dialog.show()
            } else {
                recordPermissionRequest()
            }
        }
    }

    private fun recordPermissionRequest() {
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.RECORD_AUDIO), recordRequestCode)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when (requestCode) {
            recordRequestCode -> {
                if (grantResults.isEmpty() || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    buttonRecord?.isEnabled = false
                    buttonPlaySample?.isEnabled = false
                } else {
                    buttonRecord?.isEnabled = true
                    buttonPlaySample?.isEnabled = false
                }
            }

            storageReadCode -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    getPhoto()
                }
            }
        }
    }

    // MARK: Image Fetching

    private fun getPhoto() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, storageReadCode)
    }

    private fun chooseImageClicked() {
        if (checkSelfPermission(android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE), storageReadCode)
        } else {
            getPhoto()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        var selectedImage: Uri? = null
        if (data != null) selectedImage = data.data else {
            this@AddItemActivity.runOnUiThread {
                val intent = Intent(this, AddItemActivity::class.java)
                startActivity(intent)
            }
        }

        if (requestCode == storageReadCode && resultCode == Activity.RESULT_OK && data != null) {
            try {
                val bitmap: Bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, selectedImage)
                this@AddItemActivity.runOnUiThread(java.lang.Runnable {
                    this.imageViewAddItem?.setImageBitmap(bitmap)
                })
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    // MARK: Options
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.add_item_menu, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (saved == false) {
            if (tempFile != null) internalStorageProvider.deleteTempFile(tempFile)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (saved == false) {
            if (tempFile != null) internalStorageProvider.deleteTempFile(tempFile)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when (item?.itemId) {
            R.id.save_menu_item -> {
                val realm = Realm.getDefaultInstance()
                val category = spinnerCategory?.selectedItem.toString()
                getItemCount(category, realm)
                saved = true
                savingImageToInternalStorage()
                try {
                    realm.beginTransaction()
                    val chattRItem = realm.createObject(ChattRItem::class.java, itemId)
                    chattRItem.itemName = editTextName?.text.toString()
                    chattRItem.itemCategory = category
                    chattRItem.itemImageFileName = imageName.toString()
                    if (spinnerCategory?.selectedItem.toString() == "People") {
                        if (audioName != null) {
                            chattRItem.itemAudioFileName = audioName.toString()
                        } else {
                            chattRItem.itemAudioFileName = "None"
                        }
                    } else {
                        chattRItem.itemAudioFileName = "None"
                    }
                    realm.copyToRealmOrUpdate(chattRItem)
                    realm.commitTransaction()
                } finally {
                    realm.close()
                }
                val intent = Intent(this, EssentialsActivity::class.java)
                startActivity(intent)
            }
            R.id.essentialsMenuItem -> {
                internalStorageProvider.deleteTempFile(tempFile)
                val intent = Intent(this, EssentialsActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getItemCount(category: String, realm: Realm) {
//        val realm = Realm.getDefaultInstance()
        try {
            val query: RealmQuery<ChattRItem>? = realm.where(ChattRItem::class.java).equalTo("itemCategory", category)
            result = query?.findAll()
            result?.let {
                if (it.size > 60) {
                    Toast.makeText(this@AddItemActivity, "You have too many items in this category. Only 60 allowed per category.", Toast.LENGTH_LONG).show()
                    return
                } else {

                }
            }
        } catch (e: IOException) {
            Log.e("Realm Error", e.toString())
        }
    }

    // MARK: Audio Recording

    private fun record() {

        recorder = MediaRecorder()
        recorder?.setAudioSource(MediaRecorder.AudioSource.MIC)
        recorder?.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP)
        recorder?.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB)
        val path: File = filesDir
        try {
            audioName = itemId + "_${editTextName?.text.toString()}" + "_audio.3gp"
            tempFile = File("$path" + File.separator + "$audioName")
        } catch (e: IOException) {
            Log.d("recording error", "recording error:", e)
        } catch (e: FileAlreadyExistsException) {
            Log.d("File already Exist", e.toString())
        }
        recorder?.setOutputFile(tempFile?.absolutePath)
        try {
            recorder?.prepare()
        } catch (e: IOException) {
            Log.d("recording error", "recording error:", e)
        }
        recorder?.start()
    }

    private fun stopRecord() {
        recorder?.stop()
        recorder?.release()
        recorder = null
        buttonPlaySample?.isEnabled = true
        buttonRecord?.isEnabled = true
    }

    private fun play() {
        player = MediaPlayer()
        player?.setOnCompletionListener(this)
        try {
            player?.setDataSource(tempFile?.absolutePath)
        } catch (e: IOException) {
            Log.d("stop recording error", "Stop Recording Error:", e)
        }
        try {
            player?.prepare()
        } catch (e: IOException) {
            Log.d("recording error", "recording error:", e)
        }
        player?.start()
        player = null
        buttonRecord?.isEnabled = false
    }

    override fun onCompletion(mp: MediaPlayer?) {
        handler = Handler()
        handler?.postDelayed({ buttonRecord?.isEnabled = true }, 1000)
    }

    private fun savingImageToInternalStorage() {
        imageViewAddItem?.isDrawingCacheEnabled
        imageViewAddItem?.buildDrawingCache()
        val bitMap: Bitmap? = imageViewAddItem?.drawingCache
        imageName = itemId + "_" + editTextName?.text
        bitMap?.let {
            if (imageName != null) internalStorageProvider.saveToInternalStorage(it, imageName!!)
        }
    }
}
