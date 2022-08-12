package com.jarvis.albumlist

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import com.jarvis.albumlist.dao.AppDatabase
import java.io.IOException

class App : Application() {

    companion object {
        lateinit var instance: App
        lateinit var database: AppDatabase
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        instance = this
        database = Room.databaseBuilder(
            base,
            AppDatabase::class.java, "album-list"
        ).build()
    }

    fun getStringFromAsset(fileName: String) : String? {
        try {
            val inputStream = applicationContext.assets.open(fileName)
            val size: Int = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            return String(buffer)
        } catch (e: IOException) { e.printStackTrace() }

        return null
    }
}