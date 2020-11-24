package kr.hs.dgsw.juyeop.data.repository

import io.reactivex.Single
import kr.hs.dgsw.juyeop.data.datasource.AlertDataSource
import kr.hs.dgsw.juyeop.data.mapper.toEntity
import kr.hs.dgsw.juyeop.domain.entity.Alert
import kr.hs.dgsw.juyeop.domain.repository.AlertRepository
import javax.inject.Inject

class AlertRepositoryImpl @Inject constructor(
    private val alertDataSource: AlertDataSource
): AlertRepository {

    override fun getAlert(): Single<List<Alert>> {
        return alertDataSource.getAlert().map { alert -> alert.map { it.toEntity() } }
    }
}