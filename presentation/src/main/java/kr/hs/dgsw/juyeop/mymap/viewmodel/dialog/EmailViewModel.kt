package kr.hs.dgsw.juyeop.mymap.viewmodel.dialog

import androidx.lifecycle.MutableLiveData
import io.reactivex.observers.DisposableCompletableObserver
import kr.hs.dgsw.juyeop.domain.request.StatusRequest
import kr.hs.dgsw.juyeop.domain.usecase.PostInfectionUseCase
import kr.hs.dgsw.juyeop.mymap.base.viewmodel.BaseViewModel
import kr.hs.dgsw.juyeop.mymap.widget.SingleLiveEvent

class EmailViewModel(
    private val postInfectionUseCase: PostInfectionUseCase
) : BaseViewModel() {

    val email = MutableLiveData<String>()
    val onDismissEvent = SingleLiveEvent<Unit>()
    val onCompleteEvent = SingleLiveEvent<Unit>()
    val onFailureEvent = SingleLiveEvent<Unit>()

    fun cancelEvent() {
        onDismissEvent.call()
    }
    fun nextEvent() {
        val statusRequest = StatusRequest(email.value.toString())
        addDisposable(postInfectionUseCase.buildUseCaseObservable(PostInfectionUseCase.Params(statusRequest)), object : DisposableCompletableObserver() {
            override fun onComplete() {
                onCompleteEvent.call()
            }
            override fun onError(e: Throwable) {
                onFailureEvent.call()
                e.printStackTrace()
            }
        })
    }
}