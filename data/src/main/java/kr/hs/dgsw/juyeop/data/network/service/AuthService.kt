package kr.hs.dgsw.juyeop.data.network.service

import io.reactivex.Single
import kr.hs.dgsw.juyeop.data.entity.AuthData
import kr.hs.dgsw.juyeop.domain.request.LoginRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {

    @POST("login")
    fun postLogin(@Body loginRequest: LoginRequest): Single<Response<AuthData>>
}