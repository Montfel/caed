package com.montfel.caed.domain.repository

import com.montfel.caed.domain.model.Box
import com.montfel.caed.domain.model.Status
import com.montfel.caed.domain.util.ResultType

interface HomeRepository {
    suspend fun getHome(): ResultType<Box>
    suspend fun getPackageDetail(code: String): ResultType<List<Status>>
}