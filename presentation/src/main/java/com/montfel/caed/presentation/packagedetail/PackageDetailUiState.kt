package com.montfel.caed.presentation.packagedetail

import com.montfel.caed.domain.model.Status

data class PackageDetailUiState(
    val status: List<Status>? = null,
    val stateOfUi: PackageDetailStateOfUi = PackageDetailStateOfUi.Loading,
)

sealed interface PackageDetailStateOfUi {
    data object Loading : PackageDetailStateOfUi
    data object Error : PackageDetailStateOfUi
    data object Success : PackageDetailStateOfUi
}