package kr.hs.dgsw.juyeop.data.network.remote

import io.reactivex.Single
import kr.hs.dgsw.juyeop.data.base.remote.BaseRemote
import kr.hs.dgsw.juyeop.data.entity.MemberData
import kr.hs.dgsw.juyeop.data.network.service.MemberService
import retrofit2.Response

class MemberRemote(override val service: MemberService) : BaseRemote<MemberService>() {

    fun getInformation(): Single<MemberData> {
        return service.getInformation().map(getResponse())
    }
}