package com.montfel.caed.presentation.packagedetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.montfel.caed.presentation.R
import com.montfel.caed.presentation.components.NavigationBarCustom
import com.montfel.caed.presentation.components.PackageStatus
import com.montfel.caed.presentation.theme.Gray
import com.montfel.caed.presentation.theme.GrayE3

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PackageDetailScreen(
    code: String,
    onNavigateBack: () -> Unit,
) {
    val viewModel: PackageDetailViewModel = hiltViewModel()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    val selectedTabIndex by rememberSaveable { mutableIntStateOf(0) }
    val titles = listOf(stringResource(R.string.status), stringResource(R.string.data))

    LaunchedEffect(Unit) {
        viewModel.onEvent(PackageDetailEvent.GetPackageDetail(code))
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(R.string.package_code, code))
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
            Spacer(modifier = Modifier.height(20.dp))

            Column(
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                TabRow(
                    selectedTabIndex = selectedTabIndex,
                    containerColor = Color.Transparent,
                    divider = {
                        HorizontalDivider(
                            color = GrayE3
                        )
                    },
                ) {
                    titles.forEachIndexed { index, title ->
                        Tab(
                            selected = index == 0,
                            onClick = {},
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
                        uiState.status?.let {
                            PackageStatus(it)
                        }
                    }
                }
            }
        }
    }
}

