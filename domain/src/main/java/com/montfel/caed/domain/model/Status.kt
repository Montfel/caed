package com.montfel.caed.domain.model

data class Status(
    val date: String,
    val time: String,
    val status: StatusType,
    val description: String
)
