package kr.hs.dgsw.juyeop.domain.usecase

import io.reactivex.Completable
import kr.hs.dgsw.juyeop.domain.base.ParamUseCase
import kr.hs.dgsw.juyeop.domain.repository.StatusRepository
import kr.hs.dgsw.juyeop.domain.request.StatusRequest
import javax.inject.Inject

class PostInfectionUseCase @Inject constructor(
    private val statusRepository: StatusRepository
): ParamUseCase<PostInfectionUseCase.Params, Completable>() {

    override fun buildUseCaseObservable(params: Params): Completable {
        return statusRepository.postInfection(params.statusRequest)
    }

    data class Params(
        val statusRequest: StatusRequest
    )
}