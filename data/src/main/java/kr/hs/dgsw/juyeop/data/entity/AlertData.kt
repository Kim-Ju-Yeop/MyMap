package kr.hs.dgsw.juyeop.data.entity

data class AlertData(
    val spot_name: String,
    val address: String,
    val latitude: String,
    val longitude: String,
    val visited_at: String
)