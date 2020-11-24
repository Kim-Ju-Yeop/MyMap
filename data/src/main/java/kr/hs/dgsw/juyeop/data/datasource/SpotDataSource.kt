package kr.hs.dgsw.juyeop.data.datasource

import io.reactivex.Completable
import io.reactivex.Single
import kr.hs.dgsw.juyeop.data.base.BaseDataSource
import kr.hs.dgsw.juyeop.data.entity.SpotData
import kr.hs.dgsw.juyeop.data.network.remote.SpotRemote
import kr.hs.dgsw.juyeop.domain.request.SpotRequest
import javax.inject.Inject

class SpotDataSource @Inject constructor(
    override val remote: SpotRemote,
    override val cache: Any
): BaseDataSource<SpotRemote, Any>() {

    fun getMySpot(date: String): Single<List<SpotData>> {
        return remote.getMySpot(date)
    }

    fun getSpot(spot_id: Int): Single<SpotData> {
        return remote.getSpot(spot_id)
    }

    fun postSpot(spotRequest: SpotRequest): Completable {
        return remote.postSpot(spotRequest)
    }
}