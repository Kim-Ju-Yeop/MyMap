package kr.hs.dgsw.juyeop.data.util

import android.content.Context
import android.content.SharedPreferences

object SharedPreferencesManager {
    private const val TOKEN = "token"

    fun getToken(context: Context): String? {
        return getDefaultSharedPreferences(context).getString(TOKEN, null)
    }
    fun setToken(context: Context, token: String) {
        getDefaultSharedPreferences(context).edit().putString(TOKEN, token).apply()
    }

    private fun getDefaultSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(getDefaultSharedPreferencesName(context), getDefaultSharedPreferencesMode())
    }
    private fun getDefaultSharedPreferencesName(context: Context): String {
        return context.packageName.toString() + "_preferences"
    }
    private fun getDefaultSharedPreferencesMode(): Int {
        return Context.MODE_PRIVATE
    }
}