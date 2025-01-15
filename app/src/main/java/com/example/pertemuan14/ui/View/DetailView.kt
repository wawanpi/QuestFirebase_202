package com.example.pertemuan14.ui.View

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pertemuan14.model.Mahasiswa



// UI saat data loading
@Composable
fun OnLoadingDetail(modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun DetailView(
    mahasiswa: Mahasiswa,             // Data mahasiswa yang ditampilkan
    onUpdateClick: (String) -> Unit,  // Action buat update data
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Kartu detail mahasiswa
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.onPrimaryContainer
            )
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Teks detail data mahasiswa
                Text(text = "Nama: ${mahasiswa.nama}", style = MaterialTheme.typography.titleLarge)
                Text(text = "NIM: ${mahasiswa.nim}", style = MaterialTheme.typography.titleMedium)
                Text(text = "Judul Skripsi: ${mahasiswa.judul_skripsi}", style = MaterialTheme.typography.titleLarge)
                Text(text = "Dosen Pembimbing: ${mahasiswa.dosen_pembimbing}", style = MaterialTheme.typography.titleLarge)
                Text(text = "Kelas: ${mahasiswa.kelas}", style = MaterialTheme.typography.titleMedium)
                Text(text = "Angkatan: ${mahasiswa.angkatan}", style = MaterialTheme.typography.titleMedium)
                Text(text = "Jenis Kelamin: ${mahasiswa.jenis_kelamin}", style = MaterialTheme.typography.titleMedium)
                Text(text = "Alamat: ${mahasiswa.alamat}", style = MaterialTheme.typography.titleMedium)
            }
        }

        // Tombol FloatingActionButton buat update
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomEnd
        ) {
            FloatingActionButton(
                onClick = { onUpdateClick(mahasiswa.nim) }
            ) {
                Icon(imageVector = Icons.Default.Edit, contentDescription = "Update Data")
            }
        }
    }
}

// UI saat ada error
@Composable
fun OnError(retryAction: () -> Unit) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "An error occurred. Please try again.")
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = retryAction) {
                Text(text = "Retry")
            }
        }
    }
}