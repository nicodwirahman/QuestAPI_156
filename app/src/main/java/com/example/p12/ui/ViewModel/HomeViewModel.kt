package com.example.p12.ui.ViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil.network.HttpException
import com.example.p12.model.Mahasiswa
import com.example.p12.repository.MahasiswaRepository
import kotlinx.coroutines.launch
import java.io.IOException

sealed class HomeUiState{
    data class success(val mahasiswa: List<Mahasiswa>): HomeUiState()
    object Error: HomeUiState()
    object  Loading: HomeUiState()
}

class HomeViewModel(private val mhs: MahasiswaRepository): ViewModel() {
    var mhsUiState: HomeUiState by mutableStateOf(HomeUiState.Loading)
        private set

    init {
        getMhs()
    }

    fun getMhs() {
        viewModelScope.launch {
            mhsUiState = HomeUiState.Loading
            mhsUiState = try {
                HomeUiState.success(mhs.getMahasiswa())
            } catch (e: IOException) {
                HomeUiState.Error
            } catch (e: HttpException) {
                HomeUiState.Error
            }
        }
    }

    fun deleteMhs(nim: String) {
        viewModelScope.launch { try {
            mhs.deleteMahasiswa(nim)
        } catch (e: IOException){ HomeUiState.Error
        } catch (e:HttpException){ HomeUiState.Error
        }
        }
    }
}
