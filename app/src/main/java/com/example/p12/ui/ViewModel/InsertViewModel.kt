package com.example.p12.ui.ViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.p12.model.Mahasiswa
import com.example.p12.repository.MahasiswaRepository

class InsertViewModel(private val mhs: MahasiswaRepository): ViewModel(){
    var uiState by mutableStateOf(InsertUiState())
        private set
}



data class InsertUiState(
    val insertUiEvent: InsertUiEvent = InsertUiEvent()
)

data class InsertUiEvent(
    val nim: String ="",
    val nama: String ="",
    val alamat: String ="",
    val jenisKelamin: String ="",
    val kelas: String ="",
    val angkatan: String =""
)

fun Mahasiswa.toUiStateMhs():InsertUiState = InsertUiState(
    insertUiEvent = toInsertUiEvent()
)



fun Mahasiswa.toInsertUiEvent(): InsertUiEvent = InsertUiEvent(
    nim = nim,
    nama = nama,
    alamat = alamat,
    jenisKelamin = jeniskelamin,
    kelas = kelas,
    angkatan = angkatan,
)