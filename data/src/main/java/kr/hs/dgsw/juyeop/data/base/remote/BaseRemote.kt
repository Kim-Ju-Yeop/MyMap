package kr.hs.dgsw.juyeop.data.base.remote

import io.reactivex.functions.Function
import org.json.JSONObject
import retrofit2.Response

abstract class BaseRemote<SV> {

    abstract val service: SV

    protected fun <T> getResponse(): Function<Response<T>, T> {
        return Function { response: Response<T> ->
            checkError(response)
            response.body()
        }
    }

    protected fun getResponseMessage(): Function<retrofit2.Response<Any>, String> {
        return Function { response: retrofit2.Response<Any> ->
            checkError(response)
            response.message()
        }
    }

    private fun checkError(response: retrofit2.Response<*>) {
        if (!response.isSuccessful) {
            val errorBody = JSONObject(response.errorBody()!!.string())
            throw Throwable(errorBody.getString("message"))
        }
    }
}