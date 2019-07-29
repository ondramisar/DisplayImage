package com.example.displayimage.network

import com.example.displayimage.db.models.Response
import io.reactivex.Flowable

interface IImageRepository {
    fun getImage(login: String, password: String): Flowable<Response>
}
