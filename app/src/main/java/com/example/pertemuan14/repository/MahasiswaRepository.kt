package com.example.pertemuan14.repository

import com.example.pertemuan14.model.Mahasiswa
import kotlinx.coroutines.flow.Flow

interface MahasiswaRepository {
    // Mengambil daftar semua mahasiswa
    suspend fun getAllMahasiswa(): Flow<List<Mahasiswa>>

    // Menambahkan data mahasiswa
    suspend fun insertMahasiswa(mahasiswa: Mahasiswa)

    // Memperbarui data mahasiswa berdasarkan NIM
    suspend fun updateMahasiswa(nim: String, mahasiswa: Mahasiswa)

    // Menghapus mahasiswa berdasarkan NIM
    suspend fun deleteMahasiswa(mahasiswa: Mahasiswa)

    // Mengambil data mahasiswa berdasarkan NIM
    suspend fun getMahasiswabyNim(nim: String): Mahasiswa
}