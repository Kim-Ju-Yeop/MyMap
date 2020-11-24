package kr.hs.dgsw.juyeop.mymap.viewmodel.adapter

import androidx.lifecycle.MutableLiveData
import kr.hs.dgsw.juyeop.domain.entity.Alert
import kr.hs.dgsw.juyeop.mymap.base.viewmodel.BaseViewModel

class AlertItemViewModel : BaseViewModel() {

    val date = MutableLiveData<String>()
    val time = MutableLiveData<String>()
    val name = MutableLiveData<String>()

    fun bind(alert: Alert) {
        date.value = alert.visited_at.substring(5, 10)
        time.value = alert.visited_at.substring(11, 16)
        name.value = alert.spot_name
    }
}