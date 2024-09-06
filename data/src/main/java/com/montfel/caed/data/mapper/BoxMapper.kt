package com.montfel.caed.data.mapper

import com.montfel.caed.data.dto.BoxDto
import com.montfel.caed.domain.model.Box

fun BoxDto.toBox(): Box {
    return Box(
        packages = packages.map { it.toPackage() },
        status = status.map { it.toStatus() },
        data = data.toData()
    )
}