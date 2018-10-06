package com.ceriosrey.chattrbox

//import com.sun.tools.corba.se.idl.Util.getAbsolutePath
import android.content.Context
import android.content.ContextWrapper
import android.graphics.Bitmap
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

class InternalStorageProvider(private val context: Context) {

    fun deleteTempFile(file: File?) {
        val file = File(file?.absolutePath)
        if (file.exists()) {
            file.delete()
        }
    }

    fun saveToInternalStorage(bitmapImage: Bitmap, imageName: String): String {
        val cw = ContextWrapper(context)
        val directory = cw.filesDir.absolutePath
        val mypath = File(directory, imageName)
        var fos: FileOutputStream? = null
        try {
            fos = FileOutputStream(mypath)
            bitmapImage.compress(Bitmap.CompressFormat.JPEG, 50, fos)
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            try {
                fos!!.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        return directory
    }
}

