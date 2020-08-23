package com.example.simple_movie_app.data.api

import com.example.simple_movie_app.domain.movie.model.Movie
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

/**
 * Created by Maulana Ibrahim on 23/August/2020
 * Email maulibrahim19@gmail.com
 */
interface MovieApiService {

    @GET(ApiEndPoint.ENDPOINT_GET_MOVIE_LIST)
    fun getMovie():Call<WrapperResponse>

    @GET(ApiEndPoint.ENDPOINT_GET_MOVIE_BY_ID)
    fun getMovieById(@Path("id") id: String): Call<WrapperResponse>

    @POST(ApiEndPoint.ENDPOINT_ADD_MOVIE)
    fun createMovie(@Body movie: Movie): Call<WrapperResponse>
}