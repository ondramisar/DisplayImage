package com.example.displayimage.network

import com.example.displayimage.base.BaseRepository
import com.example.displayimage.db.models.Response
import com.example.displayimage.utils.extencion.SHA1
import io.reactivex.Flowable
import javax.inject.Inject

class ImageRepository : BaseRepository(), IImageRepository {
    @Inject
    lateinit var networkApi: NetworkApi

    override fun getImage(login: String, password: String): Flowable<Response> {
        return networkApi.getImage(login, password.SHA1())
    }
}