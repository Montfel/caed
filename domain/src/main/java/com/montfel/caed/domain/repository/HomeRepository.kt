package com.montfel.caed.domain.repository

import com.montfel.caed.domain.model.Box
import com.montfel.caed.domain.model.Status

interface HomeRepository {
    suspend fun getHome(): Box
    suspend fun getPackageDetail(code: String): List<Status>
}