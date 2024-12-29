package com.example.p12.ui.ViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.p12.repository.MahasiswaRepository

class UpdateMhsView(private val mhsRepository: MahasiswaRepository):ViewModel(){
    var uiState by mutableStateOf(UpdateUiState)
}


data class UpdateUiState(
    val insertUiState: InsertUiState = InsertUiState()
)