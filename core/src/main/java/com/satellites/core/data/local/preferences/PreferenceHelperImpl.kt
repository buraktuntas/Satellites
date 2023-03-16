package com.satellites.core.data.local.preferences

import android.content.SharedPreferences
import com.satellites.core.domain.preferences.PreferenceHelper

class PreferenceHelperImpl(
    private val encryptedSharedPreferences: SharedPreferences
) : PreferenceHelper {

    override fun saveString(key: String, value: String) {
        encryptedSharedPreferences.edit().putString(key, value).apply()
    }

    override fun getString(key: String): String {
        return getString(key, null)
    }

    override fun getString(key: String, defaultValue: String?): String {
        return encryptedSharedPreferences.getString(key, defaultValue) ?: ""
    }

    override fun saveInteger(key: String, value: Int) {
        encryptedSharedPreferences.edit().putInt(key, value).apply()
    }

    override fun getInteger(key: String): Int {
        return getInteger(key, -1)
    }

    override fun getInteger(key: String, defaultValue: Int): Int {
        return encryptedSharedPreferences.getInt(key, defaultValue)
    }

    override fun saveLong(key: String, value: Long) {
        encryptedSharedPreferences.edit().putLong(key, value).apply()
    }

    override fun getLong(key: String): Long {
        return encryptedSharedPreferences.getLong(key, -1)
    }

    override fun getLong(key: String, defaultValue: Long): Long {
        return encryptedSharedPreferences.getLong(key, defaultValue)
    }

    override fun saveBoolean(key: String, value: Boolean) {
        encryptedSharedPreferences.edit().putBoolean(key, value).apply()
    }

    override fun getBoolean(key: String): Boolean {
        return encryptedSharedPreferences.getBoolean(key, false)
    }

    override fun getBoolean(key: String, defaultValue: Boolean): Boolean {
        return encryptedSharedPreferences.getBoolean(key, defaultValue)
    }

    override fun clear(key: String): Boolean {
        return encryptedSharedPreferences.edit().remove(key).commit()
    }

    override fun clearAll(): Boolean {
        return encryptedSharedPreferences.edit().clear().commit()
    }

    override fun isContain(key: String): Boolean {
        return encryptedSharedPreferences.contains(key)
    }
}