package net.kathir.mvvm_kotlin_cleanarchitecture.presentation.imagedetail

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import net.kathir.mvvm_kotlin_cleanarchitecture.R
import net.kathir.mvvm_kotlin_cleanarchitecture.presentation.BaseActivity
import javax.inject.Inject

class ImageDetailActivity : BaseActivity() {

    companion object{
        const val EXTRA_URL = "URL"
    }

    @Inject lateinit var viewModel: ImageDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        screenComponent.inject(this)

        val binding: net.kathir.mvvm_kotlin_cleanarchitecture.databinding.ActivityImageDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_image_detail)
        binding.viewModel = viewModel

        viewModel.bound(intent.extras!!.getString(EXTRA_URL, ""))
    }
}