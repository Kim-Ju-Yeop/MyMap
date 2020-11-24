package kr.hs.dgsw.juyeop.data.network.service

import io.reactivex.Single
import kr.hs.dgsw.juyeop.data.entity.AlertData
import retrofit2.Response
import retrofit2.http.GET

interface AlertService {

    @GET("alerts")
    fun getAlert(): Single<Response<List<AlertData>>>
}