package com.example.simple_movie_app.domain.movie.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.simple_movie_app.R
import com.example.simple_movie_app.domain.movie.model.Movie

/**
 * Created by Maulana Ibrahim on 23/August/2020
 * Email maulibrahim19@gmail.com
 */
class MovieRecycleAdapter(val movieList:List<Movie>):RecyclerView.Adapter<MovieViewHolder>() {

    lateinit var listener:IMovieRecycleListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_item, parent, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        Glide.with(holder.itemView.context).load(movieList[position].imageUrl)
            .placeholder(R.drawable.ic_progres_bar).diskCacheStrategy(
                DiskCacheStrategy.NONE
            )
            .into(holder.imageUrl)
        holder.itemView.setOnClickListener {
            listener.onItemClick(movieList[position].movieId)
        }
    }
}