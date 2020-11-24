package kr.hs.dgsw.juyeop.data.network.remote

import io.reactivex.Completable
import kr.hs.dgsw.juyeop.data.base.remote.BaseRemote
import kr.hs.dgsw.juyeop.data.network.service.StatusService
import kr.hs.dgsw.juyeop.domain.request.StatusRequest

class StatusRemote(override val service: StatusService) : BaseRemote<StatusService>() {

    fun postInfection(statusRequest: StatusRequest): Completable {
        return service.postInfection(statusRequest)
    }
}