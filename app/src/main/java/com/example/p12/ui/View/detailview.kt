package com.example.p12.ui.View

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.p12.model.Mahasiswa
import com.example.p12.ui.ViewModel.DetailUiState
import com.example.p12.ui.ViewModel.DetailViewModel
import com.example.p12.ui.ViewModel.PenyediaViewModel
import com.example.p12.ui.navigasi.CustomeTopAppBar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    nim: String,
    navigateBack: () -> Unit,
    onUpdateClick: (String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: DetailViewModel = viewModel(factory = PenyediaViewModel.Factory)
) {
    val detailUiState = viewModel.detailUiState.collectAsState().value

    // Load data mahasiswa saat pertama kali layar ditampilkan
    LaunchedEffect(nim) {
        viewModel.getDetailMahasiswa(nim)
    }

    Scaffold(
        modifier = modifier,
        topBar = {
            CustomeTopAppBar(
                title = "Detail Mahasiswa",
                canNavigateBack = true,
                navigateUp = navigateBack
            )
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            when (detailUiState) {
                is DetailUiState.Loading -> OnLoading(modifier = Modifier.fillMaxSize())
                is DetailUiState.Success -> DetailContent(
                    mahasiswa = detailUiState.mahasiswa,
                    onUpdateClick = onUpdateClick,
                    modifier = Modifier.fillMaxSize()
                )
                is DetailUiState.Error -> OnError(retryAction = { viewModel.getDetailMahasiswa(nim) })
            }
        }
    }
}

@Composable
fun DetailContent(
    mahasiswa: Mahasiswa,
    onUpdateClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Nama: ${mahasiswa.nama}",
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            text = "NIM: ${mahasiswa.nim}",
            style = MaterialTheme.typography.titleMedium
        )
        Text(
            text = "Kelas: ${mahasiswa.kelas}",
            style = MaterialTheme.typography.titleMedium
        )
        Text(
            text = "Angkatan: ${mahasiswa.angkatan}",
            style = MaterialTheme.typography.titleMedium
        )
        Text(
            text = "Jenis Kelamin: ${mahasiswa.jeniskelamin}",
            style = MaterialTheme.typography.titleMedium
        )
        Text(
            text = "Alamat: ${mahasiswa.alamat}",
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { onUpdateClick(mahasiswa.nim) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Update Data")
        }
    }
}

@Composable
fun OnLoadingDetail(modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {
        Text(text = "Loading...")
    }
}

@Composable
fun OnError(retryAction: () -> Unit) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "An error occurred. Please try again.")
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = retryAction) {
                Text(text = "Retry")
            }
        }
    }
}