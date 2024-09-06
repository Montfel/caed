package com.montfel.caed.domain.model

data class Quantity(
    val type: QuantityType,
    val typeQuantity: Int,
    val missingQuantity: Int,
)
