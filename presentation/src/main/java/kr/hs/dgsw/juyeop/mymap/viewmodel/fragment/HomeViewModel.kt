package kr.hs.dgsw.juyeop.mymap.viewmodel.fragment

import androidx.lifecycle.MutableLiveData
import io.reactivex.observers.DisposableSingleObserver
import kr.hs.dgsw.juyeop.domain.entity.Spot
import kr.hs.dgsw.juyeop.domain.usecase.GetMySpotUseCase
import kr.hs.dgsw.juyeop.mymap.base.viewmodel.BaseViewModel
import kr.hs.dgsw.juyeop.mymap.view.adapter.SpotItemAdapter
import kr.hs.dgsw.juyeop.mymap.widget.SingleLiveEvent
import kr.hs.dgsw.juyeop.mymap.widget.extension.dateFormat
import java.util.Date

class HomeViewModel(
    private val getMySpotUseCase: GetMySpotUseCase
) : BaseViewModel() {

    val spotItemList = ArrayList<Spot>()
    val spotItemAdapter = SpotItemAdapter()

    val todayDate = MutableLiveData<String>()
    val onQrCodeEvent = SingleLiveEvent<Unit>()

    init {
        todayDate.value = Date().dateFormat()
        spotItemAdapter.setList(spotItemList)
        getMySpot()
    }

    private fun getMySpot() {
        addDisposable(getMySpotUseCase.buildUseCaseObservable(GetMySpotUseCase.Params(todayDate.value.toString())),
            object : DisposableSingleObserver<List<Spot>>() {
                override fun onSuccess(spotList: List<Spot>) {
                    spotItemList.addAll(spotList)
                    spotItemAdapter.notifyDataSetChanged()
                }
                override fun onError(e: Throwable) {
                    onErrorEvent.value = e
                }
            })
    }

    fun qrcodeEvent() {
        onQrCodeEvent.call()
    }
}