package kr.hs.dgsw.juyeop.mymap.viewmodel.fragment

import android.content.Context
import androidx.lifecycle.MutableLiveData
import io.reactivex.observers.DisposableSingleObserver
import kr.hs.dgsw.juyeop.domain.entity.Spot
import kr.hs.dgsw.juyeop.domain.usecase.GetMySpotUseCase
import kr.hs.dgsw.juyeop.mymap.base.viewmodel.BaseViewModel
import kr.hs.dgsw.juyeop.mymap.view.adapter.SpotItemAdapter
import kr.hs.dgsw.juyeop.mymap.widget.SingleLiveEvent
import kr.hs.dgsw.juyeop.mymap.widget.extension.dateFormat
import java.util.*
import kotlin.collections.ArrayList

class HomeViewModel(
    private val context: Context,
    private val getMySpotUseCase: GetMySpotUseCase
) : BaseViewModel() {

    val calendar = Calendar.getInstance()

    val spotItemList = ArrayList<Spot>()
    val spotItemAdapter = SpotItemAdapter()

    val todayDate = MutableLiveData<String>()
    val onQrCodeEvent = SingleLiveEvent<Unit>()
    val onDatePickerEvent = SingleLiveEvent<Unit>()

    init {
        todayDate.value = calendar.time.dateFormat()
        spotItemAdapter.setList(spotItemList)
    }

    fun getMySpot() {
        addDisposable(getMySpotUseCase.buildUseCaseObservable(GetMySpotUseCase.Params(todayDate.value.toString())),
            object : DisposableSingleObserver<List<Spot>>() {
                override fun onSuccess(spotList: List<Spot>) {
                    spotItemList.clear()
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
    fun datePickerEvent() {
        onDatePickerEvent.call()
    }

    fun backEvent() {
        calendar.add(Calendar.DATE, -1)

        var formatMonth = (calendar.get(Calendar.MONTH)+1).toString()
        var formatDay = calendar.get(Calendar.DAY_OF_MONTH).toString()

        if ((calendar.get(Calendar.MONTH)+1) < 10) formatMonth = "0" + formatMonth
        if (calendar.get(Calendar.DAY_OF_MONTH) < 10) formatDay = "0" + formatDay

        todayDate.value = "${calendar.get(Calendar.YEAR)}-$formatMonth-$formatDay"
        getMySpot()
    }
    fun nextEvent() {
        calendar.add(Calendar.DATE, 1)

        var formatMonth = (calendar.get(Calendar.MONTH)+1).toString()
        var formatDay = calendar.get(Calendar.DAY_OF_MONTH).toString()

        if ((calendar.get(Calendar.MONTH)+1) < 10) formatMonth = "0" + formatMonth
        if (calendar.get(Calendar.DAY_OF_MONTH) < 10) formatDay = "0" + formatDay

        todayDate.value = "${calendar.get(Calendar.YEAR)}-$formatMonth-$formatDay"
        getMySpot()
    }
}