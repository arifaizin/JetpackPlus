package com.arif.jetpackpro.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.arif.jetpackpro.BuildConfig
import com.arif.jetpackpro.MyApplication
import com.arif.jetpackpro.R
import com.arif.jetpackpro.model.movie.MovieModel
import com.arif.jetpackpro.model.tvshow.TvShowModel
import com.arif.jetpackpro.viewmodel.DetailMovieViewModel
import com.arif.jetpackpro.viewmodel.ViewModelFactory
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*
import javax.inject.Inject

class DetailActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelFactory

    private val detailMovieViewModel: DetailMovieViewModel by viewModels {
        factory
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        (application as MyApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.hide()

//        detailMovieViewModel = obtainViewModel(this)

        val index: Int = intent.getIntExtra("index",0)
        if (index == 1) {
            val dataMovie: MovieModel = intent.getParcelableExtra("data")
            showDetailMovie(dataMovie)
        } else {
            val dataTvShow: TvShowModel = intent.getParcelableExtra("data")
            showDetailTvShow(dataTvShow)
        }
    }

    private fun showDetailMovie(dataMovie: MovieModel) {
        detailTextTitle.text = dataMovie.title
        detailTextRelease.text = dataMovie.releaseDate
        detailTextOverview.text = dataMovie.overview

        Glide.with(this).load(BuildConfig.POSTER_URL+dataMovie.posterPath).into(detailImagePoster)
        Glide.with(this).load(BuildConfig.POSTER_URL+dataMovie.backdropPath).into(detailImageHeader)

        var statusFavorite = dataMovie.isFavorite as Boolean
        setStatusFavorite(statusFavorite)
        detailButtonFavorite.setOnClickListener {
            statusFavorite = !statusFavorite
            detailMovieViewModel.setFavoriteMovie(dataMovie, statusFavorite)
            setStatusFavorite(statusFavorite)
        }
    }

    private fun showDetailTvShow(dataTvShow: TvShowModel) {
        detailTextTitle.text = dataTvShow.name
        detailTextRelease.text = dataTvShow.firstAirDate
        detailTextOverview.text = dataTvShow.overview

        Glide.with(this).load(BuildConfig.POSTER_URL+dataTvShow.posterPath).into(detailImagePoster)
        Glide.with(this).load(BuildConfig.POSTER_URL+dataTvShow.backdropPath).into(detailImageHeader)

        var statusFavorite = dataTvShow.isFavorite as Boolean
        setStatusFavorite(statusFavorite)
        detailButtonFavorite.setOnClickListener {
            statusFavorite = !statusFavorite
            detailMovieViewModel.setFavoriteTvShow(dataTvShow, statusFavorite)
            setStatusFavorite(statusFavorite)
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) detailButtonFavorite.setImageDrawable(
            ContextCompat.getDrawable(
                this,
                R.drawable.ic_action_favorite
            )
        )
        else detailButtonFavorite.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_action_not_favorite))
    }

//    @Inject
//    lateinit var factory: ViewModelFactory
//    private fun obtainViewModel(activity: FragmentActivity): DetailMovieViewModel {
//        // Use a Factory to inject dependencies into the ViewModel
////        val factory = ViewModelFactory.getInstance(activity.application)
//        return ViewModelProviders.of(activity, factory).get(DetailMovieViewModel::class.java)
//    }
}
