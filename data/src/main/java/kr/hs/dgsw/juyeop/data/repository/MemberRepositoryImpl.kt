package kr.hs.dgsw.juyeop.data.repository

import io.reactivex.Single
import kr.hs.dgsw.juyeop.data.datasource.MemberDataSource
import kr.hs.dgsw.juyeop.data.mapper.toEntity
import kr.hs.dgsw.juyeop.domain.entity.Member
import kr.hs.dgsw.juyeop.domain.repository.MemberRepository
import javax.inject.Inject

class MemberRepositoryImpl @Inject constructor(
    private val memberDataSource: MemberDataSource
): MemberRepository {

    override fun getInformation(): Single<Member> {
        return memberDataSource.getInformation().map { member -> member.toEntity() }
    }
}