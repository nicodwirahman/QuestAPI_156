package com.example.p12.ui.ViewModel

import com.example.p12.model.Mahasiswa


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