package com.example.simple_movie_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.simple_movie_app.domain.movie.MovieViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val movieViewModel by viewModels<MovieViewModel>()
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = (nav_host_fragment as NavHostFragment).navController
        visibilityNavElements(navController)
        NavigationUI.setupWithNavController(bottom_navigation,navController)
        movieViewModel.getMovie()
        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.listMovie -> {
                    navController.navigate(R.id.toMovieListFragment)
                    true
                }
                R.id.createMovie -> {
                    navController.navigate(R.id.toMovieInputFragment)
                    true
                }
                else ->{
                    navController.navigate(R.id.toMovieListFragment)
                    true
                }
            }
        }
    }

    private fun visibilityNavElements(navController: NavController) {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.movieListFragment,
                R.id.movieInputFragment -> bottom_navigation?.visibility = View.VISIBLE
                else -> bottom_navigation?.visibility = View.GONE
            }
        }
    }
}
