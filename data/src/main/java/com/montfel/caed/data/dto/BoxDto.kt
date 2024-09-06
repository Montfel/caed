package com.montfel.caed.data.dto

data class BoxDto(
    val packages: List<PackageDto>,
    val status: List<StatusDto>,
    val data: DataDto
)
