package com.montfel.caed.data.mapper

import com.montfel.caed.data.dto.QuantityDto
import com.montfel.caed.domain.model.Quantity
import com.montfel.caed.domain.model.QuantityType

fun QuantityDto.toQuantity(): Quantity {
    return Quantity(
        type = QuantityType.valueOf(type),
        typeQuantity = typeQuantity,
        missingQuantity = missingQuantity
    )
}