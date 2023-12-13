package com.example.mvvmkotlin.data.db


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.mvvmkotlin.data.model.artist.Artist
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ArtistDaoTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var dao: ArtistDao
    private lateinit var database: TMDBDatabase

    @Before
    fun setUp() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            TMDBDatabase::class.java
        ).build()
        dao = database.artistDao()
    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun saveArtistsTest() = runBlocking{
        val artists = listOf(
            Artist(1,"name1",0.1,"profilePath1"),
            Artist(2,"name2",0.2,"profilePath2"),
            Artist(3,"name3",0.3,"profilePath3")

        )
        dao.saveArtists(artists)

        val allArtists = dao.getArtists()
        Truth.assertThat(allArtists).isEqualTo(artists)
    }


    @Test
    fun deleteMoviesTest() = runBlocking {
        val artists = listOf(
            Artist(1,"name1",0.1,"profilePath1"),
            Artist(2,"name2",0.2,"profilePath2"),
            Artist(3,"name3",0.3,"profilePath3")

        )
        dao.saveArtists(artists)
        dao.deleteAllArtists()
        val artistsResult = dao.getArtists()
        Truth.assertThat(artistsResult).isEmpty()
    }

}