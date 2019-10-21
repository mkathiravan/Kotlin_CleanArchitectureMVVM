package net.kathir.mvvm_kotlin_cleanarchitecture.presentation.restaurantdetail

import android.app.AlertDialog
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import net.kathir.mvvm_kotlin_cleanarchitecture.R
import net.kathir.mvvm_kotlin_cleanarchitecture.presentation.BaseActivity
import javax.inject.Inject

class RestaurantDetailActivity : BaseActivity() {

    @Inject lateinit var viewModel: RestaurantDetailViewModel
    private val disposables = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        screenComponent.inject(this)


        val binding: net.kathir.mvvm_kotlin_cleanarchitecture.databinding.ActivityRestaurantDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_restaurant_detail)

        binding.viewModel = viewModel
        viewModel.bound(intent.getIntExtra(EXTRA_RESTAURANT_ID, -1))
    }

    override fun onResume() {
        super.onResume()
        viewModel.showErrorGettingRestaurantDetails.observe()
            .subscribe {
                AlertDialog.Builder(this)
                    .setTitle(getString(R.string.error_title))
                    .setMessage(getString(R.string.restaurant_detail_message))
                    .setNeutralButton(getString(R.string.ok), { dialog, _ -> dialog.dismiss() })
            }.addTo(disposables)
    }

    override fun onPause() {
        disposables.clear()
        super.onPause()
    }

    override fun onDestroy() {
        viewModel.unbound()
        super.onDestroy()
    }





    companion object {
        const val EXTRA_RESTAURANT_ID = "restaurant_id"
    }

}