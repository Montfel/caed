package com.montfel.caed.presentation.packagedetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.montfel.caed.domain.repository.HomeRepository
import com.montfel.caed.domain.util.ResultType
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class PackageDetailViewModel @Inject constructor(
    private val homeRepository: HomeRepository,
) : ViewModel() {
    private val _uiState = MutableStateFlow(PackageDetailUiState())
    val uiState = _uiState.asStateFlow()

    fun onEvent(event: PackageDetailEvent) {
        when (event) {
            is PackageDetailEvent.GetPackageDetail -> getPackageDetail(event.code)
        }
    }

    private fun getPackageDetail(code: String) {
        viewModelScope.launch {
            when (val result = homeRepository.getPackageDetail(code)) {
                is ResultType.Failure -> {
                    _uiState.update {
                        it.copy(
                            stateOfUi = PackageDetailStateOfUi.Error
                        )
                    }
                }

                is ResultType.Success -> {
                    _uiState.update {
                        it.copy(
                            status = result.data,
                            stateOfUi = PackageDetailStateOfUi.Success
                        )
                    }
                }
            }
        }
    }
}

