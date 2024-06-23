package ru.mobile_broadcast.androidmeetupdiexample.presentation.main_screen.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import ru.mobile_broadcast.androidmeetupdiexample.databinding.ActivityMainBinding
import ru.mobile_broadcast.androidmeetupdiexample.domain.model.SpaceXRocket
import ru.mobile_broadcast.androidmeetupdiexample.presentation.MainScreenUiState
import ru.mobile_broadcast.androidmeetupdiexample.presentation.main_screen.vm.MainViewModel
import ru.mobile_broadcast.androidmeetupdiexample.util.formatToRusDate

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        supportActionBar?.hide()

        observeViewModel()
    }

    private fun observeViewModel() {
        lifecycleScope.launch {
            viewModel.state.collect { state ->
                updateUI(state)
            }
        }
    }

    private fun updateUI(state: MainScreenUiState) {
        with(binding) {
            when (state) {
                is MainScreenUiState.Loading -> {
                    spacexRocketInfoBlock.visibility = View.GONE
                    progressLoader.visibility = View.VISIBLE
                }

                is MainScreenUiState.Success -> {
                    spacexRocketInfoBlock.visibility = View.VISIBLE
                    progressLoader.visibility = View.GONE
                    bind(state.rocketsList[0])
                }

                is MainScreenUiState.Error -> {
                    spacexRocketInfoBlock.visibility = View.GONE
                    progressLoader.visibility = View.GONE
                    Toast.makeText(this@MainActivity, state.message, Toast.LENGTH_LONG).show()
                }

                is MainScreenUiState.Init -> {
                    viewModel.getRockets()
                }
            }
        }
    }

    private fun bind(spaceXRocket: SpaceXRocket) {
        loadImage(spaceXRocket)
        with(binding) {
            rocketTitle.text = spaceXRocket.rocketName
            firstLaunchDate.text = spaceXRocket.firstFlight.formatToRusDate()
            country.text = spaceXRocket.country
            launchPrice.text = viewModel.getFormattedPrice(spaceXRocket.costPerLaunch)
        }
    }

    private fun loadImage(spaceXRocket: SpaceXRocket) {
        val requestOptions = RequestOptions()
            .diskCacheStrategy(DiskCacheStrategy.ALL)

        Glide.with(this)
            .load(spaceXRocket.imageUrl)
            .apply(requestOptions)
            .into(binding.rocketImage)
    }
}