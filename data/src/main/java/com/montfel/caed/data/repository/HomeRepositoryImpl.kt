package com.montfel.caed.data.repository

import com.montfel.caed.data.mapper.toBox
import com.montfel.caed.data.mapper.toStatus
import com.montfel.caed.data.service.HomeService
import com.montfel.caed.domain.model.Box
import com.montfel.caed.domain.model.Status
import com.montfel.caed.domain.repository.HomeRepository
import com.montfel.caed.domain.util.ResultType
import com.montfel.caed.domain.util.resultWrapper
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val service: HomeService,
) : HomeRepository {
    override suspend fun getHome(): ResultType<Box> {
        return resultWrapper {
            service.getHome().toBox()
        }
    }

    override suspend fun getPackageDetail(code: String): ResultType<List<Status>> {
        return resultWrapper {
            service.getPackageDetail(code).map { it.toStatus() }
        }
    }
}