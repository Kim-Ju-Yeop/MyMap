package kr.hs.dgsw.juyeop.data.network.service

import io.reactivex.Single
import kr.hs.dgsw.juyeop.data.entity.MemberData
import retrofit2.Response
import retrofit2.http.GET

interface MemberService {

    @GET("information")
    fun getInformation(): Single<Response<MemberData>>
}