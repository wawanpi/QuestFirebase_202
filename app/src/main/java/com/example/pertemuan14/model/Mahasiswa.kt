package com.example.pertemuan14.model

data class Mahasiswa(
    val nim: String,
    val nama: String,
    val judul_skripsi: String,
    val dosen_pembimbing: String,
    val alamat: String,
    val jenis_kelamin: String,
    val kelas: String,
    val angkatan:String
    )
{
    constructor(

    ):this("","","","","","","","")
}