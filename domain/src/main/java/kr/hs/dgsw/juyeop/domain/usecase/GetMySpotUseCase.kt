package kr.hs.dgsw.juyeop.domain.usecase

import io.reactivex.Single
import kr.hs.dgsw.juyeop.domain.base.ParamUseCase
import kr.hs.dgsw.juyeop.domain.entity.Spot
import kr.hs.dgsw.juyeop.domain.repository.SpotRepository
import javax.inject.Inject

class GetMySpotUseCase @Inject constructor(
    private val spotRepository: SpotRepository
): ParamUseCase<GetMySpotUseCase.Params, Single<List<Spot>>>() {

    override fun buildUseCaseObservable(params: Params): Single<List<Spot>> {
        return spotRepository.getMySpot(params.date)
    }

    data class Params(
        val date: String
    )
}