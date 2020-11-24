package kr.hs.dgsw.juyeop.data.datasource

import io.reactivex.Completable
import kr.hs.dgsw.juyeop.data.base.BaseDataSource
import kr.hs.dgsw.juyeop.data.network.remote.StatusRemote
import kr.hs.dgsw.juyeop.domain.request.StatusRequest
import javax.inject.Inject

class StatusDataSource @Inject constructor(
    override val remote: StatusRemote,
    override val cache: Any
) : BaseDataSource<StatusRemote, Any>() {

    fun postInfection(statusRequest: StatusRequest): Completable {
        return remote.postInfection(statusRequest)
    }
}