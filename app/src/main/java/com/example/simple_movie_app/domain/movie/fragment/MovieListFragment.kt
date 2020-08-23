package com.example.simple_movie_app.domain.movie.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.simple_movie_app.R
import com.example.simple_movie_app.domain.movie.MovieViewModel
import com.example.simple_movie_app.domain.movie.adapter.IMovieRecycleListener
import com.example.simple_movie_app.domain.movie.adapter.MovieRecycleAdapter
import kotlinx.android.synthetic.main.fragment_movie_list.*

class MovieListFragment : Fragment(),IMovieRecycleListener {

    private val movieViewModel by activityViewModels<MovieViewModel>()
    lateinit var movieRecycleAdapter: MovieRecycleAdapter
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        rvMovieList.layoutManager = GridLayoutManager(context,2)
        movieViewModel.getMovie()
        movieViewModel.movieList.observe(viewLifecycleOwner, Observer {
            movieRecycleAdapter = MovieRecycleAdapter(it)
            movieRecycleAdapter.listener = this
            rvMovieList.adapter = movieRecycleAdapter
        })
    }

    override fun onItemClick(movieId: String) {
        movieViewModel.getMovieById(movieId)
        navController.navigate(R.id.toMovieDetailFragment)
    }

}
