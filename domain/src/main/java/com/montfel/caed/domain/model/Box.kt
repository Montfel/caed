package com.montfel.caed.domain.model

data class Box(
    val packages: List<Package>,
    val status: List<Status>,
    val data: Data
)
