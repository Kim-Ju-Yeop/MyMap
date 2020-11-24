package kr.hs.dgsw.juyeop.mymap.viewmodel.activity

import io.reactivex.observers.DisposableSingleObserver
import kr.hs.dgsw.juyeop.domain.entity.Alert
import kr.hs.dgsw.juyeop.domain.usecase.GetAlertUseCase
import kr.hs.dgsw.juyeop.mymap.base.viewmodel.BaseViewModel
import kr.hs.dgsw.juyeop.mymap.view.adapter.AlertItemAdapter

class AlertViewModel(
    private val getAlertUseCase: GetAlertUseCase
) : BaseViewModel() {

    val alertItemList = ArrayList<Alert>()
    val alertItemAdapter = AlertItemAdapter()

    init {
        alertItemAdapter.setList(alertItemList)
        getAlert()
    }

    fun getAlert() {
        isLoading.value = false
        addDisposable(getAlertUseCase.buildUseCaseObservable(), object : DisposableSingleObserver<List<Alert>>() {
            override fun onSuccess(alertList: List<Alert>) {
                isLoading.value = true
                alertItemList.clear()
                alertItemList.addAll(alertList)
                alertItemAdapter.notifyDataSetChanged()
            }
            override fun onError(e: Throwable) {
                isLoading.value = true
                e.printStackTrace()
            }
        })
    }
}