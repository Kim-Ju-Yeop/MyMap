package kr.hs.dgsw.juyeop.data.datasource

import io.reactivex.Single
import kr.hs.dgsw.juyeop.data.base.BaseDataSource
import kr.hs.dgsw.juyeop.data.entity.MemberData
import kr.hs.dgsw.juyeop.data.network.remote.MemberRemote
import retrofit2.Response
import javax.inject.Inject

class MemberDataSource @Inject constructor(
    override val remote: MemberRemote,
    override val cache: Any
) : BaseDataSource<MemberRemote, Any>() {

    fun getInformation(): Single<MemberData> {
        return remote.getInformation()
    }
}