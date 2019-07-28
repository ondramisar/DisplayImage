package com.example.movieslist.network.mock

import com.example.movieslist.db.models.Response
import com.example.movieslist.network.IImageRepository
import io.reactivex.Flowable

class ImageRepository : IImageRepository {

    override fun getImage(login: String, password: String): Flowable<Response> {
        //  return Flowable.just("")
        return TODO()
    }
}
