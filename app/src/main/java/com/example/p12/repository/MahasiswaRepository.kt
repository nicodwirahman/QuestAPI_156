package com.example.p12.repository

import com.example.p12.model.Mahasiswa
import com.example.p12.service_api.MahasiswaService

interface MahasiswaRepository {
    suspend fun getMahasiswa(): List<Mahasiswa>

    suspend fun  insertMahasiswa(mahasiswa: Mahasiswa)

    suspend fun updateMahasiswa(nim: String, mahasiswa: Mahasiswa)

    suspend fun  deleteMahasiswa(nim: String)

    suspend fun getMahasiswabyNim(nim: String): Mahasiswa
}

class NetworkMahasiswaRepository(
    private val MahasiswaApiService: MahasiswaService
): MahasiswaRepository {
    override suspend fun insertMahasiswa(mahasiswa: Mahasiswa) {
        MahasiswaApiService.insertMahasiswa(mahasiswa)

    }

    override suspend fun updateMahasiswa(nim: String, mahasiswa: Mahasiswa) {
        MahasiswaApiService.updateMahasiswa(nim, mahasiswa)
    }

    override suspend fun getMahasiswabyNim(): List<Mahasiswa> =
        kontakApiService.getAllMahasiswa()

    override suspend fun getMahasiswa(): List<Mahasiswa> {
        TODO("Not yet implemented")
    }
    }
    }

