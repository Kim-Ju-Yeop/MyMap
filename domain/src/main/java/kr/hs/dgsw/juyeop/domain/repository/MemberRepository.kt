package kr.hs.dgsw.juyeop.domain.repository

import io.reactivex.Single
import kr.hs.dgsw.juyeop.domain.entity.Member

interface MemberRepository {

    fun getInformation(): Single<Member>
}