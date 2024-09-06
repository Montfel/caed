package com.montfel.caed.presentation.packagedetail

sealed interface PackageDetailEvent {
    data class GetPackageDetail(val code: String): PackageDetailEvent
}