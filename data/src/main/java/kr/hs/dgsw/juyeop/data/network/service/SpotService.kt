package kr.hs.dgsw.juyeop.data.network.service

import io.reactivex.Completable
import io.reactivex.Single
import kr.hs.dgsw.juyeop.data.entity.SpotData
import kr.hs.dgsw.juyeop.domain.request.SpotRequest
import retrofit2.Response
import retrofit2.http.*

interface SpotService {

    @GET("logs")
    fun getMySpot(@Query("date") date: String): Single<Response<List<SpotData>>>

    @GET("spot/{spot_id}")
    fun getSpot(@Path("spot_id") spot_id: Int): Single<Response<SpotData>>

    @POST("logs")
    fun postSpot(@Body spotRequest: SpotRequest): Completable
}