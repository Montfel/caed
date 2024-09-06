package com.montfel.caed.data.repository

import com.montfel.caed.data.mapper.toBox
import com.montfel.caed.data.service.HomeService
import com.montfel.caed.domain.model.Box
import com.montfel.caed.domain.repository.HomeRepository
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val service: HomeService
): HomeRepository {
    override suspend fun getHome(): Box {
        return service.getHome().toBox()
    }

    override suspend fun getPackageDetail(code: String): Any {
        TODO("Not yet implemented")
    }
}