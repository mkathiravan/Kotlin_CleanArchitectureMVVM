package net.kathir.mvvm_kotlin_cleanarchitecture.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ObservableList
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import net.kathir.domain.model.Restaurant
import net.kathir.mvvm_kotlin_cleanarchitecture.databinding.ListItemRestaurantBinding



class RestaurantListAdapter(restaurants: ObservableList<Restaurant>) : ObservableRecyclerViewAdapter<Restaurant, RestaurantListAdapter.Holder>(restaurants){



    lateinit var onImageClickedListener: (restaurant: Restaurant) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(
            net.kathir.mvvm_kotlin_cleanarchitecture.databinding.ListItemRestaurantBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            onItemClickListener, onImageClickedListener)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position))
    }

    class Holder(
        private val binding: net.kathir.mvvm_kotlin_cleanarchitecture.databinding.ListItemRestaurantBinding,
        private val onItemClickListener: ((item: Any) -> Unit)?,
        private val onImageClickedListener: ((restaurant: Restaurant) -> Unit)?) :
        RecyclerView.ViewHolder(binding.root) {

        private lateinit var restaurant: Restaurant

        fun bind(restaurant: Restaurant) {
            this.restaurant = restaurant

            Picasso.get().load(restaurant.coverImgUrl).resize(100, 50).into(binding.image)
            binding.name.text = restaurant.name
            binding.description.text = restaurant.description
            binding.minutes.text = restaurant.status

            binding.root.setOnClickListener { onItemClickListener?.invoke(restaurant) }
            binding.image.setOnClickListener { onImageClickedListener?.invoke(restaurant) }
        }
    }
}