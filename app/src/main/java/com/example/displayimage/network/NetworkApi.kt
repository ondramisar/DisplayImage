package com.example.movieslist.network

import com.example.movieslist.db.models.Response
import io.reactivex.Flowable
import retrofit2.http.*

interface NetworkApi {

    @FormUrlEncoded
    @Headers("Content-Type: application/x-www-form-urlencoded")
    @POST("image.php")
    fun getImage(@Field("username") username: String, @Header("Authorization") password: String): Flowable<Response>
}