package kr.hs.dgsw.juyeop.data.network.remote

import io.reactivex.Completable
import io.reactivex.Single
import kr.hs.dgsw.juyeop.data.base.BaseRemote
import kr.hs.dgsw.juyeop.data.entity.SpotData
import kr.hs.dgsw.juyeop.data.network.service.SpotService
import kr.hs.dgsw.juyeop.domain.request.SpotRequest

class SpotRemote(override val service: SpotService) : BaseRemote<SpotService>() {

    fun getMySpot(date: String): Single<List<SpotData>> {
        return service.getMySpot(date).map(getResponse())
    }

    fun getSpot(spot_id: Int): Single<SpotData> {
        return service.getSpot(spot_id).map(getResponse())
    }

    fun postSpot(spotRequest: SpotRequest): Completable {
        return service.postSpot(spotRequest)
    }
}