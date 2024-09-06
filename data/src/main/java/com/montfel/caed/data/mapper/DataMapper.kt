package com.montfel.caed.data.mapper

import com.montfel.caed.data.dto.DataDto
import com.montfel.caed.domain.model.Data

fun DataDto.toData(): Data {
    return Data(
        boxCode = boxCode,
        deliveryPoint = deliveryPoint,
        city = city,
        school = school,
        grade = grade,
        cv = cv
    )
}