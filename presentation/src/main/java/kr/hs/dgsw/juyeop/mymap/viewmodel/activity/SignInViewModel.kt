package kr.hs.dgsw.juyeop.mymap.viewmodel.activity

import android.content.Context
import androidx.lifecycle.MutableLiveData
import io.reactivex.observers.DisposableSingleObserver
import kr.hs.dgsw.juyeop.data.util.SharedPreferencesManager
import kr.hs.dgsw.juyeop.domain.entity.Auth
import kr.hs.dgsw.juyeop.domain.request.LoginRequest
import kr.hs.dgsw.juyeop.domain.usecase.PostLoginUseCase
import kr.hs.dgsw.juyeop.mymap.base.viewmodel.BaseViewModel
import kr.hs.dgsw.juyeop.mymap.widget.SingleLiveEvent

class SignInViewModel(
    private val context: Context,
    private val postLoginUseCase: PostLoginUseCase
) : BaseViewModel() {

    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    val onSignInEvent = SingleLiveEvent<Unit>()
    val onSignUpEvent = SingleLiveEvent<Unit>()

    val onSuccessEvent = SingleLiveEvent<Unit>()
    val onFailureEvent = SingleLiveEvent<Unit>()

    fun postLogin() {
        isLoading.value = true
        val loginRequest = LoginRequest(email.value.toString(), password.value.toString())

        addDisposable(postLoginUseCase.buildUseCaseObservable(PostLoginUseCase.Params(loginRequest)), object : DisposableSingleObserver<Auth>() {
            override fun onSuccess(auth: Auth) {
                SharedPreferencesManager.setToken(context, auth.access_token)
                isLoading.value = false
                onSuccessEvent.call()
            }
            override fun onError(e: Throwable) {
                isLoading.value = false
                onFailureEvent.call()
                e.printStackTrace()
            }
        })
    }

    fun signInEvent() {
        onSignInEvent.call()
    }
    fun signUpEvent() {
        onSignUpEvent.call()
    }
}