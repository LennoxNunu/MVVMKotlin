package com.example.mvvmkotlin.data.repository.movie

import android.util.Log
import com.example.mvvmkotlin.data.model.movie.Movie
import com.example.mvvmkotlin.data.model.movie.MovieList
import com.example.mvvmkotlin.data.repository.movie.datasource.MovieCacheDataSource
import com.example.mvvmkotlin.data.repository.movie.datasource.MovieLocalDataSource
import com.example.mvvmkotlin.data.repository.movie.datasource.MovieRemoteDatasource
import com.example.mvvmkotlin.domain.repository.MovieRepository
import retrofit2.Response

class MovieRepositoryImpl(
    private val movieRemoteDatasource: MovieRemoteDatasource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
) : MovieRepository {

    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovies:List<Movie> = getMoviesFromAPI()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newListOfMovies)
        movieCacheDataSource.saveMoviesToCache(newListOfMovies)
        return newListOfMovies
    }

    suspend fun getMoviesFromAPI(): List<Movie> {
        lateinit var movieList: List<Movie>

        try {
            val response: Response<MovieList> = movieRemoteDatasource.getMovies()
            val body: MovieList? = response.body()
            if (body != null) {
                movieList = body.movies
            }
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        return movieList
    }


    suspend fun getMoviesFromDB():List<Movie>{
        lateinit var movieList: List<Movie>

        try {
         movieList = movieLocalDataSource.getMoviesFromDB()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        if(movieList.size > 0){
            return movieList
        }else{
            movieList = getMoviesFromAPI()
            movieLocalDataSource.saveMoviesToDB(movieList)
        }

        return movieList
    }

    suspend fun getMoviesFromCache():List<Movie>{
        lateinit var movieList: List<Movie>

        try {
            movieList = movieCacheDataSource.getMoviesFromCathe()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        if(movieList.size > 0){
            return movieList
        }else{
            movieList = getMoviesFromDB()
            movieCacheDataSource.saveMoviesToCache(movieList)
        }

        return movieList

    }
}