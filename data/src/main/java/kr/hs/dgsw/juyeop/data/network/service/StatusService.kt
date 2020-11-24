package kr.hs.dgsw.juyeop.data.network.service

import io.reactivex.Completable
import kr.hs.dgsw.juyeop.domain.request.StatusRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface StatusService {

    @POST("infection")
    fun postInfection(@Body statusRequest: StatusRequest): Completable
}