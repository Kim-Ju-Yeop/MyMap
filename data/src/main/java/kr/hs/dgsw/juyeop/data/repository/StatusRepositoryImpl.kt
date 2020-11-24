package kr.hs.dgsw.juyeop.data.repository

import io.reactivex.Completable
import kr.hs.dgsw.juyeop.data.datasource.StatusDataSource
import kr.hs.dgsw.juyeop.domain.repository.StatusRepository
import kr.hs.dgsw.juyeop.domain.request.StatusRequest
import javax.inject.Inject

class StatusRepositoryImpl @Inject constructor(
    private val statusDataSource: StatusDataSource
): StatusRepository {

    override fun postInfection(statusRequest: StatusRequest): Completable {
        return statusDataSource.postInfection(statusRequest)
    }
}