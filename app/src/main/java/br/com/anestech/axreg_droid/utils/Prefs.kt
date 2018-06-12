package br.com.anestech.axreg_droid.utils

import android.content.SharedPreferences
import br.com.anestech.axcalc.AppCache

/**
 * Created by vinicius on 11/06/18.
 */
object Prefs {
    val PREF_ID = "axreg"
    private fun prefs(): SharedPreferences{
        val context = AppCache.getInstance().applicationContext
        return context.getSharedPreferences(PREF_ID, 0)

    }
    fun setInt(flag: String, value: Int) = prefs().edit().putInt(flag, value).apply()
    fun getInt(flag: String) = prefs().getInt(flag, 0)
    fun setString(flag: String, value: String) = prefs().edit().putString(flag, value).apply()
    fun getString(flag: String) = prefs().getString(flag, "")
}