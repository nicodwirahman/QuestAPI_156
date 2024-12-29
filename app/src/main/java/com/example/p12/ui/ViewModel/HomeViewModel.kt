package com.example.p12.ui.ViewModel

import com.example.p12.model.Mahasiswa

sealed class HomeUiState{
    data class success(val mahasiswa: List<Mahasiswa>): HomeUiState()
    object Error: HomeUiState()
    object  Loading: HomeUiState()
}