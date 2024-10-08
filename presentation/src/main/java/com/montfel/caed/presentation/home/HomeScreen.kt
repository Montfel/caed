package com.montfel.caed.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.montfel.caed.presentation.R
import com.montfel.caed.presentation.components.BoxStatus
import com.montfel.caed.presentation.components.Data
import com.montfel.caed.presentation.components.ErrorScreen
import com.montfel.caed.presentation.components.LoadingScreen
import com.montfel.caed.presentation.components.NavigationBarCustom
import com.montfel.caed.presentation.components.Packages
import com.montfel.caed.presentation.components.QuantityCard
import com.montfel.caed.presentation.theme.Gray
import com.montfel.caed.presentation.theme.GrayE3

@Composable
fun HomeRoute(
    onNavigateBack: () -> Unit,
    onNavigateToPackageDetail: (code: String) -> Unit,
) {
    val viewModel: HomeViewModel = hiltViewModel()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    when(uiState.stateOfUi) {
        HomeStateOfUi.Error -> {
            ErrorScreen(onClick = {})
        }
        HomeStateOfUi.Loading -> {
            LoadingScreen()
        }
        HomeStateOfUi.Success -> {
            HomeScreen(
                uiState = uiState,
                onNavigateBack = onNavigateBack,
                onNavigateToPackageDetail = onNavigateToPackageDetail
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    uiState: HomeUiState,
    onNavigateBack: () -> Unit,
    onNavigateToPackageDetail: (code: String) -> Unit,
) {
    var selectedTabIndex by rememberSaveable { mutableIntStateOf(0) }
    val titles = listOf(
        stringResource(R.string.packages),
        stringResource(R.string.status),
        stringResource(R.string.data)
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(R.string.packages_list))
                },
                navigationIcon = {
                    IconButton(
                        onClick = onNavigateBack
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = null
                        )
                    }
                }
            )
        },
        bottomBar = {
            NavigationBarCustom()
        },
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding()
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues)
        ) {
            Spacer(modifier = Modifier.height(6.dp))

            LazyRow(
                contentPadding = PaddingValues(horizontal = 21.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                uiState.box?.quantities?.let {
                    items(it) { quantity ->
                        QuantityCard(quantity)
                    }
                }
            }

            Spacer(modifier = Modifier.height(18.dp))

            Column(
                modifier = Modifier.padding(horizontal = 15.dp)
            ) {
                TabRow(
                    selectedTabIndex = selectedTabIndex,
                    containerColor = Color.Transparent,
                    divider = {
                        HorizontalDivider(color = GrayE3)
                    },
                ) {
                    titles.forEachIndexed { index, title ->
                        Tab(
                            selected = selectedTabIndex == index,
                            onClick = { selectedTabIndex = index },
                            modifier = Modifier.height(50.dp)
                        ) {
                            Text(
                                text = title,
                                color = if (selectedTabIndex == index) Color.Black else Gray,
                            )
                        }
                    }
                }

                when (selectedTabIndex) {
                    0 -> {
                        uiState.box?.packages?.let {
                            Packages(
                                packages = it,
                                onClick = onNavigateToPackageDetail
                            )
                        }
                    }

                    1 -> {
                        uiState.box?.status?.let {
                            BoxStatus(it)
                        }
                    }

                    2 -> {
                        uiState.box?.data?.let {
                            Data(it)
                        }
                    }
                }
            }
        }
    }
}

