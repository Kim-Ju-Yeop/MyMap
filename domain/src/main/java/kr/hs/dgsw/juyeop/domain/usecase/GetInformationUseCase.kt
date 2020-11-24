package kr.hs.dgsw.juyeop.domain.usecase

import io.reactivex.Single
import kr.hs.dgsw.juyeop.domain.base.BaseUseCase
import kr.hs.dgsw.juyeop.domain.base.ParamUseCase
import kr.hs.dgsw.juyeop.domain.entity.Member
import kr.hs.dgsw.juyeop.domain.entity.Spot
import kr.hs.dgsw.juyeop.domain.repository.MemberRepository
import kr.hs.dgsw.juyeop.domain.repository.SpotRepository
import javax.inject.Inject

class GetInformationUseCase @Inject constructor(
    private val memberRepository: MemberRepository
): BaseUseCase<Single<Member>>() {

    override fun buildUseCaseObservable(): Single<Member> {
        return memberRepository.getInformation()
    }
}