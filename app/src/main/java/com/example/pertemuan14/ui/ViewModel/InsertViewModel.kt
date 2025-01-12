package com.example.pertemuan14.ui.ViewModel

import com.example.pertemuan14.model.Mahasiswa



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