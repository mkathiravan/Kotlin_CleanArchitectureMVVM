package net.kathir.mvvm_kotlin_cleanarchitecture.presentation.adapter

import androidx.databinding.ObservableList
import androidx.recyclerview.widget.RecyclerView

abstract class ObservableRecyclerViewAdapter<T, Holder: RecyclerView.ViewHolder>(private val items: ObservableList<T>) : RecyclerView.Adapter<Holder>() {

    lateinit var onItemClickListener: (item: Any) -> Unit

    init {
        items.addOnListChangedCallback(object: ObservableList.OnListChangedCallback<ObservableList<T>>() {
            override fun onChanged(sender: ObservableList<T>?) {
                notifyDataSetChanged()
            }

            override fun onItemRangeRemoved(sender: ObservableList<T>?, positionStart: Int, itemCount: Int) {
                notifyItemRangeRemoved(positionStart, itemCount)
            }

            override fun onItemRangeMoved(sender: ObservableList<T>?, fromPosition: Int, toPosition: Int, itemCount: Int) {
                notifyDataSetChanged()
            }

            override fun onItemRangeInserted(sender: ObservableList<T>?, positionStart: Int, itemCount: Int) {
                notifyItemRangeInserted(positionStart, itemCount)
            }

            override fun onItemRangeChanged(sender: ObservableList<T>?, positionStart: Int, itemCount: Int) {
                notifyItemRangeChanged(positionStart, itemCount)
            }
        })
    }

    override fun getItemCount(): Int = items.size

    fun getItem(i: Int): T {
        return items[i]
    }

    fun getItems(): ObservableList<T> {
        return items
    }

}