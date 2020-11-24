package kr.hs.dgsw.juyeop.mymap.viewmodel.fragment

import androidx.lifecycle.MutableLiveData
import io.reactivex.observers.DisposableSingleObserver
import kr.hs.dgsw.juyeop.domain.entity.Member
import kr.hs.dgsw.juyeop.domain.usecase.GetInformationUseCase
import kr.hs.dgsw.juyeop.mymap.base.viewmodel.BaseViewModel
import kr.hs.dgsw.juyeop.mymap.widget.SingleLiveEvent

class MyInfoViewModel(
    private val getInformationUseCase: GetInformationUseCase
) : BaseViewModel() {

    val name = MutableLiveData<String>()
    val birth = MutableLiveData<String>()
    val blood = MutableLiveData<String>()
    val address = MutableLiveData<String>()

    val onSubmitEvent = SingleLiveEvent<Unit>()

    init {
        getInformation()
    }

    fun getInformation() {
        isLoading.value = false
        addDisposable(getInformationUseCase.buildUseCaseObservable(), object : DisposableSingleObserver<Member>() {
            override fun onSuccess(member: Member) {
                isLoading.value = true
                name.value = member.name
                birth.value = "생년월일 : ${member.birth_date}"
                blood.value = "${member.blood_type}형"
                address.value = member.address
            }
            override fun onError(e: Throwable) {
                isLoading.value = true
                e.printStackTrace()
            }
        })
    }

    fun submitEvent() {
        onSubmitEvent.call()
    }
}