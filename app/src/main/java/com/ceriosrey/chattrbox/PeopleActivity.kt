package com.ceriosrey.chattrbox

import android.content.ContextWrapper
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.AsyncTask
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.DisplayMetrics
import android.util.Log
import android.view.*
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_people.*
import kotlinx.android.synthetic.main.people_cell_layout.view.*
import com.squareup.picasso.Picasso
import io.realm.Realm
import io.realm.RealmQuery
import io.realm.RealmResults
import java.io.File
import java.io.IOException
import java.util.*

class PeopleActivity : AppCompatActivity(), TextToSpeech.OnInitListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, PeopleAdapter.OnCellClickListener, PeopleAdapter.OnDeleteButtonClickListener {


    private var player: MediaPlayer? = null
    private var itemList: MutableList<ChattRBoxItems> = ArrayList()
    private var result: RealmResults<ChattRItem>? = null
    private val category = "People"
    private var editMode: Boolean = false
    private var internalStorageProvider: InternalStorageProvider? = null
    private var tts: TextToSpeech? = null
    private var displayMetrics: DisplayMetrics? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_people)
        title = category
        editMode = false
        tts = TextToSpeech(this, this)
        internalStorageProvider = InternalStorageProvider(this)
        Realm.init(this)

        val diagonalInches = phoneOrTablet()
        if (diagonalInches >= 6.5) {
            recyclerView_people.layoutManager = GridLayoutManager(this, 6)
        } else {
            recyclerView_people.layoutManager = GridLayoutManager(this, 3)

        }

        AsyncTask.execute {
            category.let {
                loadFromRealm(it)
            }
        }
        this.runOnUiThread {
            itemList.let {
                recyclerView_people.adapter = PeopleAdapter(it, this, false, this)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.people_activity_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val intent: Intent?

        when (item?.itemId) {
            R.id.essentials_peopleMenu -> {
                intent = Intent(this, EssentialsActivity::class.java)
                startActivity(intent)
            }
            R.id.addItem_peopleMenu -> {
                intent = Intent(this, AddItemActivity::class.java)
                startActivity(intent)
            }
            R.id.deleteItem_peopleMenu -> {
                editMode = editMode == false
                var text = "On"
                if (editMode) {
                    text = "On"
                } else {
                    text = "Off"
                }
                Toast.makeText(this@PeopleActivity, "Edit Mode: $text.", Toast.LENGTH_LONG).show()
                this.runOnUiThread {
                    recyclerView_people.adapter = PeopleAdapter(itemList, this, editMode, this)
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            tts?.let {
                val result = it.setLanguage(Locale.CANADA)
                if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                    Log.e("TTS", "The Language specified is not supported!")
                } else {

                }
            }
        } else {
            Log.e("TTS Init Failed", "TTS initialization failed!")
        }
    }

    override fun onCompletion(mp: MediaPlayer?) {
        player = null
    }

    override fun onError(mp: MediaPlayer?, what: Int, extra: Int): Boolean {
        return true
    }

    override fun onCellClick(chattRItem: ChattRBoxItems, position: Int) {
        if (chattRItem.itemAudioFileName == "None") {
            textToSpeech(chattRItem)
        } else {
            playAudio(chattRItem.itemAudioFileName)
        }
    }

    override fun onDeleteButtonClick(chattRItem: ChattRBoxItems, position: Int) {
        itemList.removeAt(position)
        runOnUiThread {
            recyclerView_people.adapter.notifyItemChanged(position)
            recyclerView_people.adapter.notifyItemRangeChanged(position, itemList.size)
            Toast.makeText(this, "Item removed.", Toast.LENGTH_LONG).show()
        }
        AsyncTask.execute {
            deleteFromRealm(chattRItem)
            if (chattRItem.itemAudioFileName != "None") {
                val file = File(filesDir.absolutePath + File.separator + chattRItem.itemAudioFileName)
                internalStorageProvider?.deleteTempFile(file)
            }
            val context = ContextWrapper(this)
            val path: String = context.filesDir.absolutePath
            val imageFile = File(path, chattRItem.itemImageFileName)
            internalStorageProvider?.deleteTempFile(imageFile)
        }
    }

    override fun onDestroy() {
        if (tts != null) {
            tts?.stop()
            tts?.shutdown()
        }
        super.onDestroy()
        internalStorageProvider = null
        editMode = false
    }

    private fun phoneOrTablet(): Double {
        displayMetrics = DisplayMetrics()
        this.windowManager.defaultDisplay.getMetrics(displayMetrics)
        var yInches: Double? = null
        var xInches: Double? = null
        displayMetrics?.ydpi?.let {
            yInches = displayMetrics?.heightPixels?.toDouble()?.div(it)
        }
        displayMetrics?.xdpi?.let {
            xInches = displayMetrics?.widthPixels?.toDouble()?.div(it)
        }
        var diagonalInches: Double = 0.0
        xInches?.let {
            var x = it
            yInches?.let {
                diagonalInches = Math.sqrt(it * it + x * x)
            }
        }
        return diagonalInches
    }

    private fun textToSpeech(chattRItem: ChattRBoxItems) {
        val text = chattRItem.itemName
        tts?.let {
            it.speak(text, TextToSpeech.QUEUE_FLUSH, null, "")
        }
    }

    private fun playAudio(audioFileName: String) {
        val path: File = this.filesDir
        val file = File(path.toString(), audioFileName)
        Log.e("file", file.absolutePath)
        val fileUri = Uri.fromFile(file)
        try {
            player = MediaPlayer.create(this, fileUri)
            player?.start()
            player = null
        } catch (e: IOException) {
            Log.e("Error in player", e.toString())
            return
        }
    }

    private fun deleteFromRealm(chattRItem: ChattRBoxItems) {
        val realm = Realm.getDefaultInstance()
        try {
            realm.beginTransaction()
            val query: RealmQuery<ChattRItem>? = realm.where(ChattRItem::class.java).equalTo("itemId", chattRItem.itemId)
            val result = query?.findAll()
            result?.let {
                it.deleteAllFromRealm()
                realm.commitTransaction()
            }
        } finally {
            realm.close()
        }
    }

    private fun loadFromRealm(category: String) {
        val realm = Realm.getDefaultInstance()
        try {
            val query: RealmQuery<ChattRItem>? = realm.where(ChattRItem::class.java).equalTo("itemCategory", category)
            result = query?.findAll()
            result?.let {
                for (i in it) {
                    val itemId = i.itemId
                    val itemName = i.itemName
                    val itemCategory = i.itemCategory
                    val itemImageFileName = i.itemImageFileName
                    val itemAudioFileName = i.itemAudioFileName

                    val chattRItem = ChattRBoxItems(itemId, itemName, itemCategory, itemImageFileName, itemAudioFileName)
                    itemList.add(chattRItem)
                }
            }
        } finally {
            realm.close()
        }
    }
}

class PeopleAdapter(private val itemList: MutableList<ChattRBoxItems>, private val listenerPlayAudio: OnCellClickListener, private val editMode: Boolean = false, private val listenerDelete: OnDeleteButtonClickListener) : RecyclerView.Adapter<PeopleAdapter.PeopleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.people_cell_layout, parent, false)
        return PeopleViewHolder(cellForRow)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: PeopleViewHolder, position: Int) {
        val chattRItem: ChattRBoxItems = itemList.get(position)
        if (!editMode) {
            holder.bind(chattRItem, position)
        } else {
            holder.bindEditOption(chattRItem, position)
        }
    }

    interface OnCellClickListener {
        fun onCellClick(chattRItem: ChattRBoxItems, position: Int)
    }

    interface OnDeleteButtonClickListener {
        fun onDeleteButtonClick(chattRItem: ChattRBoxItems, position: Int)
    }

    inner class PeopleViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(chattRItem: ChattRBoxItems, position: Int) {
            itemView.button_delete.visibility = View.INVISIBLE
            itemView.textView_people.text = chattRItem.itemName

            //set pass data to onClick interface
            view.setOnClickListener {
                listenerPlayAudio.onCellClick(chattRItem, position)
            }

            //loading image here
            val context = itemView.context
            val path: String = context.filesDir.absolutePath
            val file = File(path, chattRItem.itemImageFileName)
            Picasso.get().load(file).into(itemView.imageView_people)
        }

        fun bindEditOption(chattRItem: ChattRBoxItems, position: Int) {
            itemView.button_delete.visibility = View.VISIBLE
//            itemView.button_delete.setOnClickListener {
//                deleteFromRealm(chattRItem)
//            }
            itemView.textView_people.text = chattRItem.itemName

            //set pass data to onButtonClick interface
            itemView.button_delete.setOnClickListener {
                listenerDelete.onDeleteButtonClick(chattRItem, position)
            }

            //loading image here
            val context = itemView.context
            val path: String = context.filesDir.absolutePath
            val file = File(path, chattRItem.itemImageFileName)
            Picasso.get().load(file).into(itemView.imageView_people)
        }
    }
}




