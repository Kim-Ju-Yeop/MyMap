package kr.hs.dgsw.juyeop.domain.repository

import io.reactivex.Single
import kr.hs.dgsw.juyeop.domain.entity.Auth
import kr.hs.dgsw.juyeop.domain.request.LoginRequest

interface AuthRepository {

    fun postLogin(loginRequest: LoginRequest): Single<Auth>
}