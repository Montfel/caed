package com.montfel.caed.data.dto

data class BoxDto(
    val quantities: List<QuantityDto>,
    val packages: List<PackageDto>,
    val status: List<StatusDto>,
    val data: DataDto
)
