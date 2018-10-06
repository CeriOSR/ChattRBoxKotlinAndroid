package com.ceriosrey.chattrbox

import android.content.ContextWrapper
import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.DisplayMetrics
import android.util.Log
import android.view.*
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_essentials.*
import kotlinx.android.synthetic.main.essentials_cells_layout.view.*
import com.squareup.picasso.Picasso
import io.realm.Realm
import io.realm.RealmQuery
import io.realm.RealmResults
import java.io.File
import java.util.*

class EssentialsActivity : AppCompatActivity(), TextToSpeech.OnInitListener, EssentialsAdapter.onCellItemClickListener, EssentialsAdapter.onDeleteButtonClickListener {

    private var category: String? = null
    private var result: RealmResults<ChattRItem>? = null
    private var itemList: MutableList<ChattRBoxItems> = ArrayList()
    private var tts: TextToSpeech? = null
    private var readButton: Button? = null
    private var editMode: Boolean = false
    private var displayMetrics: DisplayMetrics? = null
    private var internalStorageProvider: InternalStorageProvider? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_essentials)
        val diagonalInches = phoneOrTablet()
        if (diagonalInches >= 6.5) {
            recyclerView_Essentials.layoutManager = GridLayoutManager(this, 6)
        } else {
            recyclerView_Essentials.layoutManager = GridLayoutManager(this, 3)
        }


        readButton = findViewById(R.id.readButton)
        readButton?.setOnClickListener { textToSpeech() }
        Realm.init(this)
        category = "Essentials"
        readButton?.isEnabled = false
        tts = TextToSpeech(this, this)
        title = category
        editMode = false
        internalStorageProvider = InternalStorageProvider(this)

        AsyncTask.execute {
            category?.let {
                loadFromRealm(it)
            }
        }
        this.runOnUiThread {
            itemList.let {
                recyclerView_Essentials.adapter = EssentialsAdapter(it, this, this, editMode)
            }
        }
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            tts?.let {
                val result = it.setLanguage(Locale.CANADA)
                if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                    Log.e("TTS", "The Langague specified is not supported!")
                } else {
                    readButton?.isEnabled = true
                }
            }
        } else {
            Log.e("TTS", "Initialization Failed!")
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.essentials_activity_menu, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val intent: Intent?
        when (item?.itemId) {
            R.id.essentials_menu_item -> {
                itemList = ArrayList()
                category = "Essentials"
                AsyncTask.execute {
                    category?.let {
                        loadFromRealm(it)
                    }
                }
                this.runOnUiThread {
                    title = category
                    itemList.let {
                        recyclerView_Essentials.adapter = EssentialsAdapter(it, this, this, editMode)
                    }
                }
            }
            R.id.activities_menu_item -> {
                itemList = ArrayList()
                category = "Activities"
                AsyncTask.execute {
                    category?.let {
                        loadFromRealm(it)
                    }
                }
                this.runOnUiThread {
                    title = category
                    itemList.let {
                        recyclerView_Essentials.adapter = EssentialsAdapter(it, this, this, editMode)
                    }
                }
            }
            R.id.places_menu_item -> {
                itemList = ArrayList()
                category = "Places"
                AsyncTask.execute {
                    category?.let {
                        loadFromRealm(it)
                    }
                }
                this.runOnUiThread {
                    title = category
                    itemList.let {
                        recyclerView_Essentials.adapter = EssentialsAdapter(it, this, this, editMode)
                    }
                }
            }
            R.id.people_menu_item -> {
                intent = Intent(this, PeopleActivity::class.java)
                startActivity(intent)
            }
            R.id.addItem_menu_item -> {
                intent = Intent(this, AddItemActivity::class.java)
                startActivity(intent)
            }
            R.id.deleteItem_essential -> {
                editMode = editMode == false
                var text: String?
                if (editMode) {
                    text = "On"
                } else {
                    text = "Off"
                }
                Toast.makeText(this@EssentialsActivity, "Edit Mode: $text.", Toast.LENGTH_LONG).show()
                runOnUiThread {
                    itemList.let {
                        recyclerView_Essentials.adapter = EssentialsAdapter(it, this, this, editMode)
                    }

                }


            }
            else -> return false
        }
        return super.onOptionsItemSelected(item)
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

    override fun onBackPressed() {

    }

    override fun onCellClick(chattRItem: ChattRBoxItems) {

        val currentText: String = editText_essentials.text.toString() + " " + chattRItem.itemName
        editText_essentials.setText(currentText)
    }

    override fun onDeleteClick(chattRItem: ChattRBoxItems, position: Int) {
        Log.e("Button Pressed", "DELETE BUTTON PRESSED!")
        itemList.removeAt(position)
        runOnUiThread {
            Toast.makeText(this@EssentialsActivity, "Item removed.", Toast.LENGTH_LONG).show()
            recyclerView_Essentials.adapter.notifyItemChanged(position)
            recyclerView_Essentials.adapter.notifyItemRangeChanged(position, itemList.size)
        }
        AsyncTask.execute {
            deleteFromRealm(chattRItem)
            val context = ContextWrapper(this)
            val path = context.filesDir
            val file = File(path.absolutePath, chattRItem.itemImageFileName)
            internalStorageProvider?.deleteTempFile(file)

        }
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

    private fun deleteFromRealm(chattRItem: ChattRBoxItems) {
        val realm = Realm.getDefaultInstance()
        try {
            realm.beginTransaction()
            val query = realm.where(ChattRItem::class.java).equalTo("itemId", chattRItem.itemId)
            val result = query.findAll()
            result?.let {
                it.deleteAllFromRealm()
            }
            realm.commitTransaction()
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

    private fun textToSpeech() {
        val text = editText_essentials.text.toString()
        tts?.let {
            it.speak(text, TextToSpeech.QUEUE_FLUSH, null, "")
            editText_essentials.setText("")
        }
    }
}

class EssentialsAdapter(val itemList: MutableList<ChattRBoxItems>, val listener: onCellItemClickListener, val listenerDelete: onDeleteButtonClickListener, val editMode: Boolean) : RecyclerView.Adapter<EssentialsAdapter.CustomViewHolder>() {
    var chattRItem: ChattRBoxItems? = null
    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {

        chattRItem = itemList.get(position)
        chattRItem?.let {
            if (!editMode) {
                holder.bind(it, position)
                holder.chattRItem = it
            } else {
                holder.bindEditMode(it, position)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        // how do we create a cell view
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.essentials_cells_layout, parent, false)
        return CustomViewHolder(cellForRow)
    }

    interface onCellItemClickListener {
        fun onCellClick(chattRItem: ChattRBoxItems)
    }

    interface onDeleteButtonClickListener {
        fun onDeleteClick(chattRItem: ChattRBoxItems, position: Int)
    }

    inner class CustomViewHolder(view: View, var chattRItem: ChattRBoxItems? = null) : RecyclerView.ViewHolder(view) {
        fun bind(chattRitem: ChattRBoxItems, position: Int) {
            itemView.textView_essentials_name.text = chattRitem.itemName
            itemView.buttonDelete_essential.visibility = View.INVISIBLE

            //loading image here
            val context = itemView.context
            val path: String = context.filesDir.absolutePath
            val file = File(path, chattRitem.itemImageFileName)
            Picasso.get().load(file).into(itemView.imageView_essentials_image)

            itemView.setOnClickListener {
                chattRItem?.let {
                    listener.onCellClick(it)
                }
            }
        }

        fun bindEditMode(chattRItem: ChattRBoxItems, position: Int) {
            itemView.textView_essentials_name.text = chattRItem.itemName
            itemView.buttonDelete_essential.visibility = View.VISIBLE

            val context = itemView.context
            val path: String = context.filesDir.absolutePath
            val file = File(path, chattRItem.itemImageFileName)
            Picasso.get().load(file).into(itemView.imageView_essentials_image)

            itemView.buttonDelete_essential.setOnClickListener {
                listenerDelete.onDeleteClick(chattRItem, position)
            }
        }
    }
}



