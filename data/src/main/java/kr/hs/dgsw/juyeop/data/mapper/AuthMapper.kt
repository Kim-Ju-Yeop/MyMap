package kr.hs.dgsw.juyeop.data.mapper

import kr.hs.dgsw.juyeop.data.entity.AuthData
import kr.hs.dgsw.juyeop.domain.entity.Auth

fun AuthData.toEntity(): Auth {
    return Auth(
        access_token = access_token,
        refresh_token = refresh_token
    )
}