package com.example.movieslist.ui

import androidx.lifecycle.MutableLiveData
import com.example.movieslist.base.BaseViewModel
import com.example.movieslist.db.models.Response
import com.example.movieslist.network.IImageRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class DisplayImageViewModel : BaseViewModel() {
    @Inject
    lateinit var repository: IImageRepository

    val loadingVisibility: MutableLiveData<Boolean> = MutableLiveData()
    val errorMessage: MutableLiveData<String> = MutableLiveData()
    val loadedData: MutableLiveData<Response> = MutableLiveData()

    private lateinit var subscription: Disposable

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }

    fun getImage(login: String, password: String) {
        subscription = repository.getImage(login, password)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onRetrieveImageStart() }
            .doOnTerminate { onRetrieveImageFinish() }
            .subscribe(
                { result -> onRetrieveImageSuccess(result) },
                { onRetrieveImageError(it.message) }
            )
    }

    private fun onRetrieveImageStart() {
        loadingVisibility.postValue(true)
        errorMessage.value = null
    }

    private fun onRetrieveImageFinish() {
        loadingVisibility.postValue(false)
    }

    private fun onRetrieveImageSuccess(image: Response) {
        loadedData.postValue(image)
    }

    private fun onRetrieveImageError(message: String?) {
        errorMessage.value = message
    }
}