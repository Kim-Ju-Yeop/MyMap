package kr.hs.dgsw.juyeop.domain.usecase

import io.reactivex.Completable
import kr.hs.dgsw.juyeop.domain.base.ParamUseCase
import kr.hs.dgsw.juyeop.domain.repository.SpotRepository
import kr.hs.dgsw.juyeop.domain.request.SpotRequest
import javax.inject.Inject

class PostSpotUseCase @Inject constructor(
    private val spotRepository: SpotRepository
): ParamUseCase<PostSpotUseCase.Params, Completable>() {

    override fun buildUseCaseObservable(params: Params): Completable {
        return spotRepository.postSpot(params.spotRequest)
    }

    data class Params(
        val spotRequest: SpotRequest
    )
}