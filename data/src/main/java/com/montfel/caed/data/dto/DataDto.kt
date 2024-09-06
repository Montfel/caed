package com.montfel.caed.data.dto

import com.google.gson.annotations.SerializedName

data class DataDto(
    @SerializedName("box_code")
    val boxCode: String,
    @SerializedName("delivery_point")
    val deliveryPoint: String,
    val city: String,
    val school: String,
    val grade: String,
    val cv: String,
)
