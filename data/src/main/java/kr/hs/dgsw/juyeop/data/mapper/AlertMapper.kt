package kr.hs.dgsw.juyeop.data.mapper

import kr.hs.dgsw.juyeop.data.entity.AlertData
import kr.hs.dgsw.juyeop.domain.entity.Alert

fun AlertData.toEntity(): Alert {
    return Alert(
        spot_name = spot_name,
        address = address,
        latitude = latitude,
        longitude = longitude,
        visited_at = visited_at
    )
}