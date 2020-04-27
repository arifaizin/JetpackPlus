package com.arifaizin.jetpackpro.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import com.arifaizin.core.BuildConfig
import com.arifaizin.core.data.model.movie.MovieModel
import com.arifaizin.core.data.model.tvshow.TvShowModel
import com.arifaizin.jetpackpro.MyApplication
import com.arifaizin.jetpackpro.R
import com.arifaizin.jetpackpro.viewmodel.DetailMovieViewModel
import com.arifaizin.jetpackpro.viewmodel.ViewModelFactory
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*
import javax.inject.Inject

class DetailActivity : AppCompatActivity() {

    private lateinit var detailMovieViewModel: DetailMovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as MyApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.hide()

        detailMovieViewModel = obtainViewModel(this)

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

    @Inject
    lateinit var factory: ViewModelFactory
    private fun obtainViewModel(activity: FragmentActivity): DetailMovieViewModel {
        return ViewModelProviders.of(activity, factory).get(DetailMovieViewModel::class.java)
    }
}
