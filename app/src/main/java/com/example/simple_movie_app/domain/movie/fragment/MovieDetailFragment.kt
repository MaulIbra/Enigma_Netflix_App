package com.example.simple_movie_app.domain.movie.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

import com.example.simple_movie_app.R
import com.example.simple_movie_app.domain.movie.MovieViewModel
import kotlinx.android.synthetic.main.fragment_movie_detail.*

class MovieDetailFragment : Fragment() {

    val movieViewModel by activityViewModels<MovieViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movieViewModel.movie.observe(viewLifecycleOwner, Observer {
            Glide.with(this).load(it.imageUrl)
                .placeholder(R.drawable.ic_progres_bar).diskCacheStrategy(
                    DiskCacheStrategy.NONE
                )
                .into(imgMovie)
            tvMovieDuration.text = "${it.duration} Min"
            tvMovieSynopsis.text = it.synopsis
        })
    }

}
