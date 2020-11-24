package kr.hs.dgsw.juyeop.data.network.remote

import io.reactivex.Single
import kr.hs.dgsw.juyeop.data.base.remote.BaseRemote
import kr.hs.dgsw.juyeop.data.base.remote.RetrofitRemote
import kr.hs.dgsw.juyeop.data.entity.AuthData
import kr.hs.dgsw.juyeop.data.network.service.AuthService
import kr.hs.dgsw.juyeop.domain.request.LoginRequest

class AuthRemote : RetrofitRemote<AuthService>() {

    override val service: AuthService
        get() = createService(AuthService::class.java)

    fun postLogin(loginRequest: LoginRequest): Single<AuthData> {
        return service.postLogin(loginRequest).map(getResponse())
    }
}