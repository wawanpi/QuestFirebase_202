package com.example.pertemuan14.ui.ViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.pertemuan14.model.Mahasiswa
import com.example.pertemuan14.repository.MahasiswaRepository

class InsertViewModel(
    private val mhs: MahasiswaRepository
) :ViewModel(){
    var uiEvent: InsertUiState by mutableStateOf(InsertUiState())
        private set
    var uiState: FromState by mutableStateOf(FromState.Idle)

    //Memperbarui state berdasarkan input pengguna

}

sealed class FromState{
    object Idle : FromState()
    object Loading : FromState()
    data class Success(val message: String) : FromState()
    data class Error(val message: String) : FromState()
}

data class InsertUiState(
    val insertUiEvent: MahasiswaEvent = MahasiswaEvent(),
    val isEntryValid: FromErrorState = FromErrorState(),
)

data class FromErrorState(
    val nim: String?= null,
    val nama: String?= null,
    val jenisKelamin: String?= null,
    val alamat: String?= null,
    val kelas: String?= null,
    val angkatan: String?= null,
    ){
    fun isValid(): Boolean {
        return nim == null && nama == null && jenisKelamin == null && alamat == null && kelas == null && angkatan == null
    }
}

data class MahasiswaEvent(
    val nim: String = "",
    val nama: String = "",
    val jenisKelamin: String = "",
    val alamat: String = "",
    val kelas: String = "",
    val angkatan: String = "",
)
fun MahasiswaEvent.toMhsModel() : Mahasiswa = Mahasiswa(
    nim = nim,
    nama = nama,
    jenisKelamin = jenisKelamin,
    alamat = alamat,
    kelas = kelas,
    angkatan = angkatan,
)