package kr.hs.dgsw.juyeop.mymap.viewmodel.activity

import android.content.Context
import kr.hs.dgsw.juyeop.data.util.SharedPreferencesManager
import kr.hs.dgsw.juyeop.mymap.base.viewmodel.BaseViewModel
import kr.hs.dgsw.juyeop.mymap.widget.SingleLiveEvent

class SplashViewModel(
    private val context: Context
) : BaseViewModel() {

    val onNullEvent = SingleLiveEvent<Unit>()
    val onNotNullEvent = SingleLiveEvent<Unit>()

    init {
        if (SharedPreferencesManager.getToken(context).isNullOrEmpty()) onNullEvent.call()
        else onNotNullEvent.call()
    }
}