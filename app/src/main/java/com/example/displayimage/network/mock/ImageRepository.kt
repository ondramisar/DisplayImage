package com.example.displayimage.network.mock

import com.example.displayimage.db.models.Response
import com.example.displayimage.network.IImageRepository
import io.reactivex.Flowable

class ImageRepository : IImageRepository {

    override fun getImage(login: String, password: String): Flowable<Response> {
        return TODO()
    }
}
