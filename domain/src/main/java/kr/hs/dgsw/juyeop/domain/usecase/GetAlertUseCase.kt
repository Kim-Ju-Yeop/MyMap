package kr.hs.dgsw.juyeop.domain.usecase

import io.reactivex.Single
import kr.hs.dgsw.juyeop.domain.base.BaseUseCase
import kr.hs.dgsw.juyeop.domain.entity.Alert
import kr.hs.dgsw.juyeop.domain.repository.AlertRepository
import javax.inject.Inject

class GetAlertUseCase @Inject constructor(
    private val alertRepository: AlertRepository
): BaseUseCase<Single<List<Alert>>>() {

    override fun buildUseCaseObservable(): Single<List<Alert>> {
        return alertRepository.getAlert()
    }
}