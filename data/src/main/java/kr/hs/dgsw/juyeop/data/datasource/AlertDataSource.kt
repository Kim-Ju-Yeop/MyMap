package kr.hs.dgsw.juyeop.data.datasource

import io.reactivex.Single
import kr.hs.dgsw.juyeop.data.base.BaseDataSource
import kr.hs.dgsw.juyeop.data.entity.AlertData
import kr.hs.dgsw.juyeop.data.network.remote.AlertRemote
import javax.inject.Inject

class AlertDataSource @Inject constructor(
    override val remote: AlertRemote,
    override val cache: Any
) : BaseDataSource<AlertRemote, Any>() {

    fun getAlert() : Single<List<AlertData>> {
        return remote.getAlert()
    }
}

