package kr.hs.dgsw.juyeop.domain.usecase

import io.reactivex.Single
import kr.hs.dgsw.juyeop.domain.base.ParamUseCase
import kr.hs.dgsw.juyeop.domain.entity.Auth
import kr.hs.dgsw.juyeop.domain.repository.AuthRepository
import kr.hs.dgsw.juyeop.domain.request.LoginRequest
import javax.inject.Inject

class PostLoginUseCase @Inject constructor(
    private val authRepository: AuthRepository
): ParamUseCase<PostLoginUseCase.Params, Single<Auth>>() {

    override fun buildUseCaseObservable(params: Params): Single<Auth> {
        return authRepository.postLogin(params.loginRequest)
    }

    data class Params(
        val loginRequest: LoginRequest
    )
}