package com.example.simple_movie_app.data.api

/**
 * Created by Maulana Ibrahim on 23/August/2020
 * Email maulibrahim19@gmail.com
 */
class WrapperResponse(
    var statusCode:Int,
    var message:String,
    val data: Any
)