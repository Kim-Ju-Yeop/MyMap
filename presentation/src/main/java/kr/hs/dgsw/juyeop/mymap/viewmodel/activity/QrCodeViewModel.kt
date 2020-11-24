package kr.hs.dgsw.juyeop.mymap.viewmodel.activity

import androidx.lifecycle.MutableLiveData
import io.reactivex.observers.DisposableCompletableObserver
import io.reactivex.observers.DisposableSingleObserver
import kr.hs.dgsw.juyeop.domain.entity.Spot
import kr.hs.dgsw.juyeop.domain.request.SpotRequest
import kr.hs.dgsw.juyeop.domain.usecase.GetSpotUseCase
import kr.hs.dgsw.juyeop.domain.usecase.PostSpotUseCase
import kr.hs.dgsw.juyeop.mymap.base.viewmodel.BaseViewModel
import kr.hs.dgsw.juyeop.mymap.widget.SingleLiveEvent

class QrCodeViewModel(
    private val getSpotUseCase: GetSpotUseCase,
    private val postSpotUseCase: PostSpotUseCase
) : BaseViewModel() {

    lateinit var spot_id: String

    val name = MutableLiveData<String>()
    val address = MutableLiveData<String>()

    val onCancelEvent = SingleLiveEvent<Unit>()
    val onNextEvent = SingleLiveEvent<Unit>()
    val onSuccessEvent = SingleLiveEvent<Unit>()

    fun getSpot() {
        addDisposable(getSpotUseCase.buildUseCaseObservable(GetSpotUseCase.Params(Integer.parseInt(spot_id))), object : DisposableSingleObserver<Spot>() {
            override fun onSuccess(spot: Spot) {
                name.value = spot.spot_name
                address.value = spot.address
            }
            override fun onError(e: Throwable) {
                onErrorEvent.value = e
            }
        })
    }

    fun postSpot() {
        val spotRequest = SpotRequest(Integer.parseInt(spot_id))
        addDisposable(postSpotUseCase.buildUseCaseObservable(PostSpotUseCase.Params(spotRequest)), object : DisposableCompletableObserver() {
            override fun onComplete() {
                onSuccessEvent.call()
            }
            override fun onError(e: Throwable) {
                onErrorEvent.value = e
            }
        })
    }

    fun cancelEvent() {
        onCancelEvent.call()
    }
    fun nextEvent() {
        onNextEvent.call()
    }
}