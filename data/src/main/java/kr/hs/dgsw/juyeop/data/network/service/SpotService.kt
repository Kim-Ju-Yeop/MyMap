package kr.hs.dgsw.juyeop.data.network.service

import io.reactivex.Completable
import io.reactivex.Single
import kr.hs.dgsw.juyeop.data.entity.SpotData
import kr.hs.dgsw.juyeop.domain.request.SpotRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface SpotService {

    @GET("logs")
    fun getSpot(@Query("data") date: String): Single<Response<List<SpotData>>>

    @POST("logs")
    fun postSpot(@Body spotRequest: SpotRequest): Completable
}