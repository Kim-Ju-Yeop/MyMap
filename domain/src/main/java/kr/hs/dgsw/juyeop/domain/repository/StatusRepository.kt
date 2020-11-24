package kr.hs.dgsw.juyeop.domain.repository

import io.reactivex.Completable
import kr.hs.dgsw.juyeop.domain.request.StatusRequest

interface StatusRepository {

    fun postInfection(statusRequest: StatusRequest): Completable
}