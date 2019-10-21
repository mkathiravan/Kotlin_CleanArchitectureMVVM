package net.kathir.mvvm_kotlin_cleanarchitecture.presentation.imagedetail

import androidx.databinding.ObservableField
import javax.inject.Inject

class ImageDetailViewModel @Inject constructor() {

    val imageUrl = ObservableField<String>()

    fun bound(url: String) {
        imageUrl.set(url)
    }


}