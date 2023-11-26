package com.example.mvvmkotlin.domain.repository

import com.example.mvvmkotlin.data.model.artist.Artist

interface ArtistRepository {
    suspend fun getArtists():List<Artist>?
    suspend fun updateArtists():List<Artist>?
}