package kr.hs.dgsw.juyeop.domain.repository

import io.reactivex.Single
import kr.hs.dgsw.juyeop.domain.entity.Alert

interface AlertRepository {

    fun getAlert(): Single<List<Alert>>
}