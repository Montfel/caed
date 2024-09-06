package com.montfel.caed.data.mapper

import com.montfel.caed.data.dto.StatusDto
import com.montfel.caed.domain.model.Status

fun StatusDto.toStatus(): Status {
    return Status(
        time = time,
        status = status,
        description = description
    )
}