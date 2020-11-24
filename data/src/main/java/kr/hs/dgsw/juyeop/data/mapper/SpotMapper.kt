package kr.hs.dgsw.juyeop.data.mapper

import kr.hs.dgsw.juyeop.data.entity.SpotData
import kr.hs.dgsw.juyeop.domain.entity.Spot

fun SpotData.toEntity(): Spot {
    return Spot(
        spot_name = spot_name,
        address = address,
        latitude = latitude,
        longitude = longitude,
        visited_at = visited_at
    )
}