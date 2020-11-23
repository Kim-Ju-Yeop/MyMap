package kr.hs.dgsw.juyeop.mymap.base.viewmodel

import java.lang.ref.WeakReference

open class BaseItemViewModel<N>: BaseViewModel() {

    private lateinit var navigator: WeakReference<N>

    fun getNavigator(): N {
        return navigator.get()!!
    }
    fun setNavigator(navigator: N) {
        this.navigator = WeakReference(navigator)
    }

    override fun onCleared() {
        super.onCleared()
        navigator.clear()
    }
}