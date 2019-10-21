package net.kathir.mvvm_kotlin_cleanarchitecture.databinding

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.BindingConversion
import com.squareup.picasso.Picasso

@BindingConversion
fun setVisibility(state: Boolean) : Int{
    return if(state) View.VISIBLE else View.GONE
}

@BindingAdapter("imageUrl")
fun loadImage(imageView: ImageView, url: String?)
{
    if (url != null) {
        Picasso.get().load(url).into(imageView)
    }
}
