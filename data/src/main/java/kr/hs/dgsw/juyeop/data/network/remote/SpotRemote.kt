package kr.hs.dgsw.juyeop.data.network.remote

import io.reactivex.Completable
import io.reactivex.Single
import kr.hs.dgsw.juyeop.data.base.BaseRemote
import kr.hs.dgsw.juyeop.data.entity.SpotData
import kr.hs.dgsw.juyeop.data.network.service.SpotService
import kr.hs.dgsw.juyeop.domain.request.SpotRequest

class SpotRemote(override val service: SpotService) : BaseRemote<SpotService>() {

    fun getSpot(date: String): Single<List<SpotData>> {
        return service.getSpot(date).map(getResponse())
    }

    fun postSpot(spotRequest: SpotRequest): Completable {
        return service.postSpot(spotRequest)
    }
}