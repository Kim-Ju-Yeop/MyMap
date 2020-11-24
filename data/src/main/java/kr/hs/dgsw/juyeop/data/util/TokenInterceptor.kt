package kr.hs.dgsw.juyeop.data.util

import android.content.Context
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class TokenInterceptor @Inject constructor(
    private val context: Context
): Interceptor {

    private lateinit var token: String

    override fun intercept(chain: Interceptor.Chain): Response {
        setToken()

        val request = chain.request().newBuilder().header("Authorization", "Bearer " + token).build()
        return chain.proceed(request)
    }

    private fun setToken() {
        token = SharedPreferencesManager.getToken(context)!!
    }
}