package com.montfel.caed.data.service

import com.montfel.caed.data.dto.BoxDto
import com.montfel.caed.data.dto.StatusDto
import retrofit2.http.GET
import retrofit2.http.Path

interface HomeService {
    @GET("/home")
    suspend fun getHome(): BoxDto

    @GET("/package_detail/{code}")
    suspend fun getPackageDetail(
        @Path("code") code: String
    ): List<StatusDto>
}