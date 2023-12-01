package com.example.mvvmkotlin.data.repository.artist.datasourceImpl

import com.example.mvvmkotlin.data.db.ArtistDao
import com.example.mvvmkotlin.data.model.artist.Artist
import com.example.mvvmkotlin.data.repository.artist.datasource.ArtistLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImpl(private val artistDoa: ArtistDao): ArtistLocalDataSource {
    override suspend fun getArtistsFromDB(): List<Artist> {
        return artistDoa.getArtists()
    }

    override suspend fun saveArtistsToDB(artists: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch {
            artistDoa.saveArtists(artists)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            artistDoa.deleteAllArtists()
        }
    }

}