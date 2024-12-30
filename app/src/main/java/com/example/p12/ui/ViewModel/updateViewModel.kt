package com.example.p12.ui.ViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.p12.repository.MahasiswaRepository
import kotlinx.coroutines.launch

// State untuk Update Mahasiswa
data class UpdateUiState(
    val insertUiEvent: InsertUiEvent = InsertUiEvent()
)
