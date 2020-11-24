package kr.hs.dgsw.juyeop.data.base.remote

import com.google.gson.GsonBuilder
import kr.hs.dgsw.juyeop.data.util.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.Executors

abstract class RetrofitRemote<SV> : BaseRemote<SV>() {

    protected fun <T> createService(service: Class<T>): T {
        return RETROFIT.create(service)
    }

    private val RETROFIT: Retrofit = Retrofit.Builder()
        .client(client)
        .baseUrl(Constants.DEFAULT_HOST)
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create()))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .callbackExecutor(Executors.newSingleThreadExecutor())
        .build()

    private val client: OkHttpClient
        get() {
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            val okhttpBuilder = OkHttpClient().newBuilder().addInterceptor(interceptor)
            return okhttpBuilder.build()
        }
}