package net.kathir.mvvm_kotlin_cleanarchitecture.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.disposables.CompositeDisposable
import net.kathir.mvvm_kotlin_cleanarchitecture.R
import net.kathir.mvvm_kotlin_cleanarchitecture.databinding.ActivityMainBinding
import net.kathir.mvvm_kotlin_cleanarchitecture.ext.addTo
import net.kathir.mvvm_kotlin_cleanarchitecture.presentation.BaseActivity
import net.kathir.mvvm_kotlin_cleanarchitecture.presentation.adapter.RestaurantListAdapter
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject lateinit var viewModel: MainViewModel
    private val disposables = CompositeDisposable()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        screenComponent.inject(this)

        binding.viewModel = viewModel
        viewModel.bound()

    }

    // onResume we need to subscribe to our viewModel actions
    override fun onResume() {
        super.onResume()

        viewModel.showErrorGettingRestaurants.observe()
            .subscribe {
                AlertDialog.Builder(this)
                    .setTitle(getString(R.string.error_title))
                    .setMessage(getString(R.string.restaurant_list_error_message))
                    .setNeutralButton(getString(R.string.ok)) { dialog, _ -> dialog.dismiss() }
            }.addTo(disposables)
    }

    // onPause we need to unsubscribe from viewModel actions since the view is not backgrounded
    override fun onPause() {
        disposables.clear()
        super.onPause()
    }

    override fun onDestroy() {
        viewModel.unbound()
        super.onDestroy()
    }

    companion object {
        /**
         * bindList uses Databinding to initialize the recyclerView using an ObservableList from the MainViewModel
         * this is referenced in activity_main.xml as 'app:adapter={@viewModel}'
         */
        @JvmStatic
        @BindingAdapter("adapter")
        fun bindList(recyclerView: RecyclerView, viewModel: MainViewModel) {
            val adapter = RestaurantListAdapter(viewModel.restaurantList)
            adapter.onItemClickListener = { viewModel.onRestaurantClicked(it) }
            adapter.onImageClickedListener = { viewModel.onRestaurantImageClicked(it) }
            recyclerView.addItemDecoration(DividerItemDecoration(recyclerView.context, DividerItemDecoration.VERTICAL))
            recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
            recyclerView.adapter = adapter
        }
    }
}
