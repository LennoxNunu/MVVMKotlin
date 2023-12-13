package com.example.mvvmkotlin.data.db

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.mvvmkotlin.data.model.tvshow.TvShow
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TvShowDaoTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var dao: TvShowDao
    private lateinit var database: TMDBDatabase

    @Before
    fun setUp() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            TMDBDatabase::class.java
        ).build()
        dao = database.tvDao()
    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun saveTvShowsTest() = runBlocking{
        val tvShows = listOf(
            TvShow("",1,"name1","overview1","posterPath1"),
            TvShow("",2,"name2","overview2","posterPath2"),
            TvShow("",3,"name3","overview3","posterPath3")
            )
        dao.saveTvShow(tvShows)

        val allTvShows = dao.getTvShows()
        Truth.assertThat(allTvShows).isEqualTo(tvShows)
    }


    @Test
    fun deleteTvShowsTest() = runBlocking {
        val tvShows = listOf(
            TvShow("",1,"name1","overview1","posterPath1"),
            TvShow("",2,"name2","overview2","posterPath2"),
            TvShow("",3,"name3","overview3","posterPath3")
        )
        dao.saveTvShow(tvShows)
        dao.deleteAllTvShows()
        val tvShowsResult = dao.getTvShows()
        Truth.assertThat(tvShowsResult).isEmpty()
    }
}