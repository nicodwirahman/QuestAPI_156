package com.example.p12.ui.ViewModel

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.p12.MahasiswaApplications

object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer {
            HomeViewModel(
                MahasiswaApplications().container.mahasiswaRepository)
        }
        initializer {
            InsertViewModel(
                MahasiswaApplications().container.mahasiswaRepository)
        }
        initializer {
            DetailViewModel(
                createSavedStateHandle(),
                MahasiswaApplications().container.mahasiswaRepository)
        }
        initializer {
            UpdateMhsViewModel(
                createSavedStateHandle(),
                MahasiswaApplications().container.mahasiswaRepository)
        }
    }
}

fun CreationExtras.aplikasiKontak(): MahasiswaApplications =
        (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MahasiswaApplications)

