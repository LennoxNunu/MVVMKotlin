package com.example.mvvmkotlin.data.repository.artist

import android.util.Log
import com.example.mvvmkotlin.data.model.artist.Artist
import com.example.mvvmkotlin.data.model.artist.ArtistList
import com.example.mvvmkotlin.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.mvvmkotlin.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.mvvmkotlin.data.repository.artist.datasource.ArtistRemoteDatasource
import com.example.mvvmkotlin.domain.repository.ArtistRepository
import retrofit2.Response

class ArtistRepositoryImpl(
    private val artistRemoteDatasource: ArtistRemoteDatasource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
) : ArtistRepository {

    override suspend fun getArtists(): List<Artist>? {
        return getArtistsFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
        val newListOfArtists:List<Artist> = getArtistsFromAPI()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistsToDB(newListOfArtists)
        artistCacheDataSource.saveArtistsToCache(newListOfArtists)
        return newListOfArtists
    }

    suspend fun getArtistsFromAPI(): List<Artist> {
        lateinit var artistList: List<Artist>

        try {
            val response: Response<ArtistList> = artistRemoteDatasource.getArtists()
            val body: ArtistList? = response.body()
            if (body != null) {
                artistList = body.artists
            }
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        return artistList
    }


    suspend fun getArtistsFromDB():List<Artist>{
        lateinit var artistList: List<Artist>

        try {
            artistList = artistLocalDataSource.getArtistsFromDB()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        if(artistList.size > 0){
            return artistList
        }else{
            artistList = getArtistsFromAPI()
            artistLocalDataSource.saveArtistsToDB(artistList)
        }

        return artistList
    }

    suspend fun getArtistsFromCache():List<Artist>{
        lateinit var artistList: List<Artist>

        try {
            artistList = artistCacheDataSource.getArtistsFromCathe()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        if(artistList.size > 0){
            return artistList
        }else{
            artistList = getArtistsFromDB()
            artistCacheDataSource.saveArtistsToCache(artistList)
        }

        return artistList

    }
}