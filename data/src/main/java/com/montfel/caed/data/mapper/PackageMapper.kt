package com.montfel.caed.data.mapper

import com.montfel.caed.data.dto.PackageDto
import com.montfel.caed.domain.model.Package
import com.montfel.caed.domain.model.StatusType

fun PackageDto.toPackage(): Package {
    return Package(
        code = code,
        status = StatusType.valueOf(status)
    )
}