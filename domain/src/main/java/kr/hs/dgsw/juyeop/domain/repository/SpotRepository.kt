package kr.hs.dgsw.juyeop.domain.repository

import io.reactivex.Completable
import io.reactivex.Single
import kr.hs.dgsw.juyeop.domain.entity.Spot
import kr.hs.dgsw.juyeop.domain.request.SpotRequest

interface SpotRepository {

    fun getSpot(date: String): Single<List<Spot>>

    fun postSpot(spotRequest: SpotRequest): Completable
}