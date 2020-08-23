package com.example.simple_movie_app.domain.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.simple_movie_app.config.RetrofitBuilder
import com.example.simple_movie_app.data.api.MovieApiService
import com.example.simple_movie_app.domain.movie.model.Movie

/**
 * Created by Maulana Ibrahim on 23/August/2020
 * Email maulibrahim19@gmail.com
 */
class MovieViewModel:ViewModel() {

    private val movieRepository: MovieRepository

    init {
        val movieApiService = RetrofitBuilder.createRetrofit().create(MovieApiService::class.java)
        movieRepository =
            MovieRepository(
                movieApiService
            )
        movieRepository.getMovie()
    }

    val movie:LiveData<Movie> = movieRepository.movie
    val movieList:LiveData<List<Movie>> = movieRepository.movieList

    fun getMovie(){
        movieRepository.getMovie()
    }

    fun getMovieById(id:String){
        movieRepository.getMovieById(id)
    }

    fun createMovie(movie: Movie){
        movieRepository.createMovie(movie)
    }
}