package com.example.mvvmkotlin.data.repository.artist

import com.example.mvvmkotlin.data.model.artist.Artist
import com.example.mvvmkotlin.domain.repository.ArtistRepository

class FakeArtistRepositoryImpl: ArtistRepository {
    private val artists = mutableListOf<Artist>()

    init {
        artists.add(Artist(1,"name1",0.1,"profilePath1"))
        artists.add(Artist(2,"name2",0.2,"profilePath2"))
    }

    override suspend fun getArtists(): List<Artist>? {
        return artists
    }

    override suspend fun updateArtists(): List<Artist>? {
        artists.clear()
        artists.add(Artist(3,"name3",0.3,"profilePath3"))
        artists.add(Artist(4,"name4",0.4,"profilePath4"))
        return artists
    }
}