package kr.hs.dgsw.juyeop.domain.entity

data class Auth (
    val access_token: String,
    val refresh_token: String
)