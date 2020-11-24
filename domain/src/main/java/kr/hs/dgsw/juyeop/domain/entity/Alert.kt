package kr.hs.dgsw.juyeop.domain.entity

data class Alert(
    val spot_name: String,
    val address: String,
    val latitude: String,
    val longitude: String,
    val visited_at: String
)