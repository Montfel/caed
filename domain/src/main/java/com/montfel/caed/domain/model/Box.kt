package com.montfel.caed.domain.model

data class Box(
    val quantities: List<Quantity>,
    val packages: List<Package>,
    val status: List<Status>,
    val data: Data
)
