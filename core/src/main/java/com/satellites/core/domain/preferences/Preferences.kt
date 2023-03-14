package com.satellites.core.domain.preferences

interface PreferenceHelper {
    fun saveString(key: String, value: String)
    fun getString(key: String): String
    fun getString(key: String, defaultValue: String?): String

    fun saveInteger(key: String, value: Int)
    fun getInteger(key: String): Int
    fun getInteger(key: String, defaultValue: Int): Int

    fun saveLong(key: String, value: Long)
    fun getLong(key: String): Long
    fun getLong(key: String, defaultValue: Long): Long

    fun saveBoolean(key: String, value: Boolean)
    fun getBoolean(key: String): Boolean
    fun getBoolean(key: String, defaultValue: Boolean): Boolean

    fun clear(key: String): Boolean
    fun clearAll(): Boolean

    fun isContain(key: String): Boolean
}