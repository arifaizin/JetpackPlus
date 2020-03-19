package com.arif.jetpackpro.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cn.pedant.SweetAlert.SweetAlertDialog
import com.arif.jetpackpro.R
import com.arif.jetpackpro.activity.DetailActivity
import com.arif.jetpackpro.adapter.ListMoviePagedAdapter
import com.arif.jetpackpro.adapter.ListTvShowPagedAdapter
import com.arif.jetpackpro.model.movie.MovieModel
import com.arif.jetpackpro.model.tvshow.TvShowModel
import com.arif.jetpackpro.util.ItemClickSupport
import com.arif.jetpackpro.valueobject.Status
import com.arif.jetpackpro.viewmodel.MovieViewModel
import com.arif.jetpackpro.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_main_tab.*
import org.jetbrains.anko.startActivity
import org.koin.android.ext.android.inject

class ListMovieFragment : androidx.fragment.app.Fragment() {

    private var page = 1
    private var index: Int? = 1
    private lateinit var movieViewModel: MovieViewModel

    private lateinit var progressDialog: SweetAlertDialog

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_main_tab, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        index = arguments?.getInt(ARG_SECTION_NUMBER)

        recycleMovie.setHasFixedSize(true)
        recycleMovie.layoutManager = LinearLayoutManager(activity)

        createDialog()

        getDataMovieOnline()
    }

    private fun getDataMovieOnline() {
        movieViewModel = obtainViewModel(activity as FragmentActivity)
        if (index == 1) {
            val adapter = ListMoviePagedAdapter()
            recycleMovie.adapter = adapter
            recycleMovie.hasFixedSize()
            movieViewModel.getDataMovie(page).observe(this, Observer { movie ->
                Log.d("tes", ""+movie.status+hashCode())
                if (movie != null) {
                    when (movie.status) {
                        Status.LOADING -> progressDialog.show()
                        Status.SUCCESS -> {
                            progressDialog.dismissWithAnimation()
                            showMovieList(movie.data as PagedList<MovieModel>, adapter)
                        }
                        Status.ERROR -> {
                            progressDialog.dismissWithAnimation()
                        }
                    }
                }
            })

            
        } else {
            val adapter = ListTvShowPagedAdapter()
            recycleMovie.adapter = adapter
            recycleMovie.hasFixedSize()
            movieViewModel.getDataTvShow().observe(this, Observer { movie ->
                if (movie != null) {
                    when (movie.status) {
                        Status.LOADING -> progressDialog.show()
                        Status.SUCCESS -> {
                            progressDialog.dismissWithAnimation()
                            showTvShowList(movie.data as PagedList<TvShowModel>, adapter)
                        }
                        Status.ERROR -> {
                            progressDialog.dismissWithAnimation()
                            showErrorDialog()
                        }
                    }
                }
            })
        }
    }

    private fun showErrorDialog() {
        val errorDialog = SweetAlertDialog(activity, SweetAlertDialog.ERROR_TYPE)
            .setTitleText(getString(R.string.error))
            .setContentText(getString(R.string.something_wrong))
        errorDialog.show()
    }

    private val factory: ViewModelFactory by inject()

    private fun obtainViewModel(activity: FragmentActivity): MovieViewModel {
        // Use a Factory to inject dependencies into the ViewModel
//        val factory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProviders.of(activity, factory).get(MovieViewModel::class.java)
    }

    private fun showMovieList(
        listMovie: PagedList<MovieModel>,
        adapter: ListMoviePagedAdapter
    ) {
        adapter.submitList(listMovie)
        adapter.notifyDataSetChanged()
        ItemClickSupport.addTo(recycleMovie).setOnItemClickListener(object : ItemClickSupport.OnItemClickListener {
            override fun onItemClicked(recyclerView: RecyclerView, position: Int, v: View) {
                context?.startActivity<DetailActivity>("data" to listMovie[position], "index" to index)
            }
        })
    }

    private fun showTvShowList(
        listTvShow: PagedList<TvShowModel>,
        adapter: ListTvShowPagedAdapter
    ) {
        adapter.submitList(listTvShow)
        adapter.notifyDataSetChanged()
        ItemClickSupport.addTo(recycleMovie).setOnItemClickListener(object : ItemClickSupport.OnItemClickListener {
            override fun onItemClicked(recyclerView: RecyclerView, position: Int, v: View) {
                context?.startActivity<DetailActivity>("data" to listTvShow[position], "index" to index)
            }
        })
    }

    private fun createDialog() {
        progressDialog = SweetAlertDialog(activity, SweetAlertDialog.PROGRESS_TYPE)
            .setTitleText(getString(R.string.loading))
            .setContentText(getString(R.string.waiting_text))
    }

    companion object {
        private const val ARG_SECTION_NUMBER = "section_number"

        @JvmStatic
        fun newInstance(sectionNumber: Int): ListMovieFragment {
            return ListMovieFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }
}