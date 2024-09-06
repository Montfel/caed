package com.montfel.caed.data.mapper

import com.montfel.caed.data.dto.StatusDto
import com.montfel.caed.domain.model.Status
import com.montfel.caed.domain.model.StatusType

fun StatusDto.toStatus(): Status {
    return Status(
        date = date,
        time = time,
        status = StatusType.valueOf(status),
        description = description
    )
}