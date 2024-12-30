package com.example.p12.ui.ViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.p12.repository.MahasiswaRepository
import kotlinx.coroutines.launch

class UpdateMhsViewModel(
    mhsRepository1: SavedStateHandle,
    private val mhsRepository: MahasiswaRepository
) : ViewModel() {
    var uiState by mutableStateOf(UpdateUiState())
        private set

    // Memuat data Mahasiswa berdasarkan NIM


    // Memperbarui UI State berdasarkan event baru
    fun updateInsertMhsState(insertUiEvent: InsertUiEvent) {
        uiState = uiState.copy(insertUiEvent = insertUiEvent)
    }
}




// State untuk Update Mahasiswa
data class UpdateUiState(
    val insertUiEvent: InsertUiEvent = InsertUiEvent()
)
