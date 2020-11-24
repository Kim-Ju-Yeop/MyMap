package kr.hs.dgsw.juyeop.mymap.viewmodel.activity

import android.content.Context
import io.reactivex.observers.DisposableSingleObserver
import kr.hs.dgsw.juyeop.data.util.SharedPreferencesManager
import kr.hs.dgsw.juyeop.domain.entity.Auth
import kr.hs.dgsw.juyeop.domain.request.LoginRequest
import kr.hs.dgsw.juyeop.domain.usecase.PostLoginUseCase
import kr.hs.dgsw.juyeop.mymap.base.viewmodel.BaseViewModel

class SignInViewModel(
    private val context: Context,
    private val postLoginUseCase: PostLoginUseCase
) : BaseViewModel() {

    init {
        postLogin()
    }

    private fun postLogin() {
        val loginRequest = LoginRequest("asdf", "asdf")

        addDisposable(postLoginUseCase.buildUseCaseObservable(PostLoginUseCase.Params(loginRequest)), object : DisposableSingleObserver<Auth>() {
            override fun onSuccess(auth: Auth) {
                SharedPreferencesManager.setToken(context, auth.access_token)
            }
            override fun onError(e: Throwable) {
                e.printStackTrace()
            }
        })
    }
}