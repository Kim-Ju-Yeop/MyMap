package kr.hs.dgsw.juyeop.mymap.viewmodel.adapter

import androidx.lifecycle.MutableLiveData
import kr.hs.dgsw.juyeop.domain.entity.Spot
import kr.hs.dgsw.juyeop.mymap.base.viewmodel.BaseViewModel

class SpotItemViewModel : BaseViewModel() {

    val time = MutableLiveData<String>()
    val name = MutableLiveData<String>()
    val address = MutableLiveData<String>()

    fun bind(spot: Spot) {
        time.value = spot.visited_at?.substring(11, 16)
        name.value = spot.spot_name
        address.value = spot.address
    }
}