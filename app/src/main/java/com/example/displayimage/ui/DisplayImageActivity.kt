package com.example.displayimage.ui

import android.annotation.SuppressLint
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Base64
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.displayimage.R
import com.example.displayimage.di.ViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*


class DisplayImageActivity : AppCompatActivity() {
    private lateinit var viewModel: DisplayImageViewModel

    @SuppressLint("SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar_detail)

        viewModel = ViewModelProviders.of(this, ViewModelFactory()).get(DisplayImageViewModel::class.java)
        viewModel.errorMessage.observe(this, Observer { errorMessage ->
            if (errorMessage != null) showError() else hideError()
        })
        viewModel.loadingVisibility.observe(this, Observer { loading ->
            if (loading) {
                image_view.visibility = View.GONE
                progress_bar_detail.visibility = View.VISIBLE
            } else {
                image_view.visibility = View.VISIBLE
                progress_bar_detail.visibility = View.GONE
            }
        })

        get_image.setOnClickListener {
            viewModel.getImage(login.text.toString(), password.text.toString())
        }

        viewModel.loadedData.observe(this, Observer {
            val decodedString = Base64.decode(it.image, Base64.DEFAULT)
            val decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.size)
            image_view.setImageBitmap(decodedByte)
        })

    }

    private fun showError() {
        error_text_detail.visibility = View.VISIBLE
        error_text_detail.text = resources.getString(R.string.loading_text)
    }

    private fun hideError() {
        error_text_detail.visibility = View.GONE
    }
}
