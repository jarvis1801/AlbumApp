package com.jarvis.albumlist.util

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object GsonUtil {

    inline fun <reified T> String.stringToObject() = Gson().fromJson<T>(this)

    inline fun <reified T> Gson.fromJson(json: String): T = fromJson(json, object : TypeToken<T>() {}.type)
}