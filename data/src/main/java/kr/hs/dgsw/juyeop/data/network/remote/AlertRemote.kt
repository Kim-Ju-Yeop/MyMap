package kr.hs.dgsw.juyeop.data.network.remote

import io.reactivex.Single
import kr.hs.dgsw.juyeop.data.base.remote.BaseRemote
import kr.hs.dgsw.juyeop.data.entity.AlertData
import kr.hs.dgsw.juyeop.data.network.service.AlertService

class AlertRemote(override val service: AlertService) : BaseRemote<AlertService>() {

    fun getAlert(): Single<List<AlertData>> {
        return service.getAlert().map(getResponse())
    }
}