package com.montfel.caed.data.dto

import com.google.gson.annotations.SerializedName

data class QuantityDto(
    val type: String,

    @SerializedName("type_quantity")
    val typeQuantity: Int,

    @SerializedName("missing_quantity")
    val missingQuantity: Int,
)
