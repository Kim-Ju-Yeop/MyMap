package kr.hs.dgsw.juyeop.mymap.viewmodel.fragment

import kr.hs.dgsw.juyeop.mymap.base.viewmodel.BaseViewModel
import kr.hs.dgsw.juyeop.mymap.widget.SingleLiveEvent

class HomeViewModel : BaseViewModel() {

    val onQrCodeEvent = SingleLiveEvent<Unit>()

    fun qrcodeEvent() {
        onQrCodeEvent.call()
    }
}