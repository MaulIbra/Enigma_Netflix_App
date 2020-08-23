package com.example.simple_movie_app.domain.movie.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels

import com.example.simple_movie_app.R
import com.example.simple_movie_app.domain.movie.MovieViewModel
import com.example.simple_movie_app.domain.movie.model.Movie
import kotlinx.android.synthetic.main.fragment_movie_input.*

class MovieInputFragment : Fragment(),View.OnClickListener {

    val movieViewModel by activityViewModels<MovieViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_input, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnSubmit.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0){
            btnSubmit->{
                val movie = Movie(
                    title= movieTitle.text.toString(),
                    duration = movieDuration.text.toString().toIntOrNull()?:0,
                    imageUrl = movieImageUrl.text.toString(),
                    synopsis = movieSynopsis.text.toString()
                )
                movieViewModel.createMovie(movie)
                Toast.makeText(context,"INSERTION SUCCESS",Toast.LENGTH_SHORT).show()
            }
        }
    }
}
