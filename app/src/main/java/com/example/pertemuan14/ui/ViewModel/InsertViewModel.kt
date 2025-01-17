package com.example.pertemuan14.ui.ViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pertemuan14.model.Mahasiswa
import com.example.pertemuan14.repository.MahasiswaRepository
import kotlinx.coroutines.launch

class InsertViewModel(
    private val mhs: MahasiswaRepository
) :ViewModel(){
    var uiEvent: InsertUiState by mutableStateOf(InsertUiState())
        private set
    var uiState: FromState by mutableStateOf(FromState.Idle)

    //Memperbarui state berdasarkan input pengguna
    fun updateState(mahasiswaEvent: MahasiswaEvent) {
        uiEvent = uiEvent.copy(
            insertUiEvent = mahasiswaEvent,
        )
    }
    //Validasi data input Pengguna
    fun validateFields(): Boolean {
        val event = uiEvent.insertUiEvent
        val errorState = FromErrorState(
            nim = if (event.nim.isEmpty()) "NIM tidak boleh kosong" else null,
            nama = if (event.nama.isEmpty()) "Nama tidak boleh kosong" else null,
            judul_skripsi = if (event.judul_skripsi.isEmpty()) "Judul Skripsi tidak boleh kosong" else null,
            dosen_pembimbing = if (event.dosen_pembimbing.isEmpty()) "Dosen Pembimbing tidak boleh kosong" else null,
            jenis_kelamin = if (event.jenis_kelamin.isEmpty()) "Jenis Kelamin tidak boleh kosong" else null,
            alamat = if (event.alamat.isEmpty()) "Alamat tidak boleh kosong" else null,
            kelas = if (event.kelas.isEmpty()) "Kelas tidak boleh kosong" else null,
            angkatan = if (event.angkatan.isEmpty()) "Angkatan tidak boleh kosong" else null,
            )
        uiEvent = uiEvent.copy(isEntryValid = errorState)
        return errorState.isValid()
    }
fun insertMhs() {
    if (validateFields()) {
        viewModelScope.launch {
            uiState = FromState.Loading
            try {
                mhs.insertMahasiswa(uiEvent.insertUiEvent.toMhsModel())
                uiState = FromState.Success("Data berhasil ditambahkan")
            } catch (e: Exception) {
                uiState = FromState.Error("Data gagal ditambahkan")
            }
        }
    } else {
        uiState = FromState.Error("Data tidak valid")
    }
}
fun resetState() {
    uiEvent = InsertUiState()
    uiState = FromState.Idle}

fun resetSnackBarMessage() {
        uiState = FromState.Idle
    }
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
    val judul_skripsi: String?= null,
    val dosen_pembimbing: String?= null,
    val jenis_kelamin: String?= null,
    val alamat: String?= null,
    val kelas: String?= null,
    val angkatan: String?= null,
    ){
    fun isValid(): Boolean {
        return nim == null && nama == null && judul_skripsi == null  &&  dosen_pembimbing == null &&jenis_kelamin == null && alamat == null && kelas == null && angkatan == null
    }
}

data class MahasiswaEvent(
    val nim: String = "",
    val nama: String = "",
    val judul_skripsi: String = "",
    val dosen_pembimbing: String = "",
    val jenis_kelamin: String = "",
    val alamat: String = "",
    val kelas: String = "",
    val angkatan: String = "",
)
fun MahasiswaEvent.toMhsModel() : Mahasiswa = Mahasiswa(
    nim = nim,
    nama = nama,
    judul_skripsi = judul_skripsi,
    dosen_pembimbing = dosen_pembimbing,
    jenis_kelamin = jenis_kelamin,
    alamat = alamat,
    kelas = kelas,
    angkatan = angkatan,
)