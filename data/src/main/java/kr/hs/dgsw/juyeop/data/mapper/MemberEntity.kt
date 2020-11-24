package kr.hs.dgsw.juyeop.data.mapper

import kr.hs.dgsw.juyeop.data.entity.MemberData
import kr.hs.dgsw.juyeop.domain.entity.Member

fun MemberData.toEntity(): Member {
    return Member(
        name = name,
        address = address,
        blood_type = blood_type,
        birth_date = birth_date
    )
}