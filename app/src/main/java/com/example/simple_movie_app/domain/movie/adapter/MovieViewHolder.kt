package com.example.simple_movie_app.domain.movie.adapter

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.simple_movie_app.R
import kotlinx.android.synthetic.main.movie_item.view.*

/**
 * Created by Maulana Ibrahim on 23/August/2020
 * Email maulibrahim19@gmail.com
 */
class MovieViewHolder(v:View):RecyclerView.ViewHolder(v) {
    val imageUrl: ImageView = v.findViewById(R.id.img_item_photo)
}