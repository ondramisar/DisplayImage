package com.example.movieslist.network

import com.example.movieslist.db.models.Response
import io.reactivex.Flowable

interface IImageRepository {
    fun getImage(login: String, password: String): Flowable<Response>
}
