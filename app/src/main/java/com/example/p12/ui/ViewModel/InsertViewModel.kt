package com.example.p12.ui.ViewModel

import com.example.p12.model.Mahasiswa


data class InsertUiState(
    val insert
)

data class InsertUiEvent(
    val nim: String ="",
    val nama: String ="",
    val alamat: String ="",
    val jenisKelamin: String ="",
    val kelas: String ="",
    val angkatan: String =""
)