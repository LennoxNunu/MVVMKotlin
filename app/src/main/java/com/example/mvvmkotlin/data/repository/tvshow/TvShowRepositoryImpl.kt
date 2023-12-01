package com.example.mvvmkotlin.data.repository.tvshow

import android.util.Log
import com.example.mvvmkotlin.data.model.movie.Movie
import com.example.mvvmkotlin.data.model.movie.MovieList
import com.example.mvvmkotlin.data.model.tvshow.TvShow
import com.example.mvvmkotlin.data.model.tvshow.TvShowList
import com.example.mvvmkotlin.data.repository.movie.datasource.MovieCacheDataSource
import com.example.mvvmkotlin.data.repository.movie.datasource.MovieLocalDataSource
import com.example.mvvmkotlin.data.repository.movie.datasource.MovieRemoteDatasource
import com.example.mvvmkotlin.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.example.mvvmkotlin.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.example.mvvmkotlin.data.repository.tvshow.datasource.TvShowRemoteDatasource
import com.example.mvvmkotlin.domain.repository.MovieRepository
import com.example.mvvmkotlin.domain.repository.TvShowRepository
import retrofit2.Response

class TvShowRepositoryImpl(
    private val tvShowRemoteDatasource: TvShowRemoteDatasource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource
) : TvShowRepository {

    override suspend fun getTvShows(): List<TvShow>? {
        return getTvShowsFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow>? {
        val newListOfTvShows:List<TvShow> = getTvShowsFromAPI()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTvShowsToDB(newListOfTvShows)
        tvShowCacheDataSource.saveTvShowsToCache(newListOfTvShows)
        return newListOfTvShows
    }

    suspend fun getTvShowsFromAPI(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>

        try {
            val response: Response<TvShowList> = tvShowRemoteDatasource.getTvShows()
            val body: TvShowList? = response.body()
            if (body != null) {
                tvShowList = body.tvShows
            }
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        return tvShowList
    }


    suspend fun getTvShowsFromDB():List<TvShow>{
        lateinit var tvShowList: List<TvShow>

        try {
            tvShowList = tvShowLocalDataSource.getTvShowsFromDB()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        if(tvShowList.size > 0){
            return tvShowList
        }else{
            tvShowList = getTvShowsFromAPI()
            tvShowLocalDataSource.saveTvShowsToDB(tvShowList)
        }

        return tvShowList
    }

    suspend fun getTvShowsFromCache():List<TvShow>{
        lateinit var tvShowList: List<TvShow>

        try {
            tvShowList = tvShowCacheDataSource.getTvShowsFromCathe()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        if(tvShowList.size > 0){
            return tvShowList
        }else{
            tvShowList = getTvShowsFromDB()
            tvShowCacheDataSource.saveTvShowsToCache(tvShowList)
        }

        return tvShowList

    }
}