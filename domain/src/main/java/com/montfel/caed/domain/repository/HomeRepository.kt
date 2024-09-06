package com.montfel.caed.domain.repository

import com.montfel.caed.domain.model.Box

interface HomeRepository {
    suspend fun getHome(): Box
    suspend fun getPackageDetail(code: String): Any
}