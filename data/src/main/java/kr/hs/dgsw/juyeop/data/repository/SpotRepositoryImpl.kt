package kr.hs.dgsw.juyeop.data.repository

import io.reactivex.Completable
import io.reactivex.Single
import kr.hs.dgsw.juyeop.data.datasource.SpotDataSource
import kr.hs.dgsw.juyeop.data.mapper.toEntity
import kr.hs.dgsw.juyeop.domain.entity.Spot
import kr.hs.dgsw.juyeop.domain.repository.SpotRepository
import kr.hs.dgsw.juyeop.domain.request.SpotRequest
import javax.inject.Inject

class SpotRepositoryImpl @Inject constructor(
    private val spotDataSource: SpotDataSource
): SpotRepository {

    override fun getSpot(date: String): Single<List<Spot>> {
        return spotDataSource.getSpot(date).map { spot -> spot.map { it.toEntity() } }
    }

    override fun postSpot(spotRequest: SpotRequest): Completable {
        return spotDataSource.postSpot(spotRequest)
    }
}