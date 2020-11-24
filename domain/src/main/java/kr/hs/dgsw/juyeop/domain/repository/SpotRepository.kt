package kr.hs.dgsw.juyeop.domain.repository

import io.reactivex.Completable
import io.reactivex.Single
import kr.hs.dgsw.juyeop.domain.entity.Spot
import kr.hs.dgsw.juyeop.domain.request.SpotRequest

interface SpotRepository {

    fun getMySpot(date: String): Single<List<Spot>>

    fun getSpot(spot_id: Int): Single<Spot>

    fun postSpot(spotRequest: SpotRequest): Completable
}