package com.example.simple_movie_app.domain.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.simple_movie_app.data.api.MovieApiService
import com.example.simple_movie_app.data.api.WrapperResponse
import com.example.simple_movie_app.domain.movie.model.Movie
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.reflect.Type


/**
 * Created by Maulana Ibrahim on 23/August/2020
 * Email maulibrahim19@gmail.com
 */
class MovieRepository(val movieApiService: MovieApiService) {

    val movieList: MutableLiveData<List<Movie>> = MutableLiveData()
    val movie: MutableLiveData<Movie> = MutableLiveData()
    val message:MutableLiveData<String> = MutableLiveData()

    fun getMovie() {
        movieApiService.getMovie().enqueue(object : Callback<WrapperResponse> {
            override fun onFailure(call: Call<WrapperResponse>, t: Throwable) {
                println(t.localizedMessage)
            }

            override fun onResponse(
                call: Call<WrapperResponse>,
                response: Response<WrapperResponse>
            ) {
                val responseMovie = response.body()
                val res = responseMovie?.data
                val listOfMyClassObject: Type = object : TypeToken<List<Movie?>?>() {}.type
                val gson = Gson()
                val outputList: List<Movie> = gson.fromJson(gson.toJson(res), listOfMyClassObject)
                movieList.value = outputList
            }
        })
    }

    fun getMovieById(id: String = "") {
        movieApiService.getMovieById(id).enqueue(object : Callback<WrapperResponse> {
            override fun onFailure(call: Call<WrapperResponse>, t: Throwable) {
                println(t.localizedMessage)
            }

            override fun onResponse(
                call: Call<WrapperResponse>,
                response: Response<WrapperResponse>
            ) {
                val responseMovie = response.body()
                val res = responseMovie?.data
                val gson = Gson()
                movie.value = gson.fromJson(
                    gson.toJson(res),
                    Movie::class.java
                )
            }
        })
    }

    fun createMovie(movie: Movie) {
        movieApiService.createMovie(movie).enqueue(object : Callback<WrapperResponse> {
            override fun onFailure(call: Call<WrapperResponse>, t: Throwable) {
                println(t.localizedMessage)
            }

            override fun onResponse(
                call: Call<WrapperResponse>,
                response: Response<WrapperResponse>
            ) {
                if (response.code() == 201){
                    message.value = "Success"
                }else{
                    message.value = "Failed"
                }
            }
        })
    }

}