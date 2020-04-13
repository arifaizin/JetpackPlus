package com.arifaizin.core.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.arifaizin.core.BuildConfig
import com.arifaizin.core.R
import com.arifaizin.core.model.tvshow.TvShowModel
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_movie.view.*

class ListTvShowPagedAdapter : PagedListAdapter<TvShowModel, ListTvShowPagedAdapter.MyViewHolder>(
    DIFF_CALLBACK
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder =
        MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false))

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(getItem(position) as TvShowModel)
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movie: TvShowModel){
            with(itemView){
                itemTextTitle.text = movie.name
                itemTextRelease.text = movie.firstAirDate
                Glide.with(context).load(BuildConfig.POSTER_URL+movie.posterPath).into(itemImagePoster)
            }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TvShowModel>() {
            override fun areItemsTheSame(oldItem: TvShowModel, newItem: TvShowModel): Boolean {
                return oldItem.id.toString() == newItem.id.toString()
            }

            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldItem: TvShowModel, newItem: TvShowModel): Boolean {
                return oldItem == newItem
            }
        }
    }
}