package com.example.movieslist.network

import com.example.movieslist.base.BaseRepository
import com.example.movieslist.db.models.Response
import com.example.movieslist.utils.extencion.SHA1
import io.reactivex.Flowable
import javax.inject.Inject

class ImageRepository : BaseRepository(), IImageRepository {
    @Inject
    lateinit var networkApi: NetworkApi

    override fun getImage(login: String, password: String): Flowable<Response> {
        return networkApi.getImage(login, password.SHA1())
    }
}