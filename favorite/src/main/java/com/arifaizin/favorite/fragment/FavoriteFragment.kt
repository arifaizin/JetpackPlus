package com.arifaizin.favorite.fragment


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cn.pedant.SweetAlert.SweetAlertDialog
import com.arif.jetpackpro.activity.DetailActivity
import com.arifaizin.core.adapter.ListMoviePagedAdapter
import com.arifaizin.core.adapter.ListTvShowPagedAdapter
import com.arifaizin.core.model.movie.MovieModel
import com.arifaizin.core.model.tvshow.TvShowModel
import com.arifaizin.core.util.ItemClickSupport
import com.arifaizin.core.util.gone
import com.arifaizin.core.util.visible
import com.arifaizin.core.valueobject.Status
import com.arifaizin.favorite.R
import com.arifaizin.favorite.dagger.FavoriteApplication
import com.arifaizin.favorite.viewmodel.FavoriteViewModel
import com.arifaizin.favorite.viewmodel.FavoriteViewModelFactory
import kotlinx.android.synthetic.main.fragment_favorite.*
import org.jetbrains.anko.startActivity
import javax.inject.Inject

class FavoriteFragment : Fragment() {
    private lateinit var progressDialog: SweetAlertDialog
    private var index: Int? = 0
    private lateinit var movieViewModel: FavoriteViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

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
            movieViewModel.getDataMovie().observe(this, Observer { movie ->
                if (movie != null) {
                    when (movie.status) {
                        Status.LOADING -> progressDialog.show()
                        Status.SUCCESS -> {
                            progressDialog.dismissWithAnimation()
                            showMovieList(movie.data as PagedList<MovieModel>, adapter)
                        }
                        Status.ERROR -> {
                            progressDialog.dismissWithAnimation()
                            showErrorDialog()
                        }
                    }
                }
            })
        } else {
            val adapter = ListTvShowPagedAdapter()
            recycleMovie.adapter = adapter
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

    override fun onAttach(context: Context) {
        super.onAttach(context)
        FavoriteApplication.inject(this)
    }

    @Inject
    lateinit var factory: FavoriteViewModelFactory

    private fun obtainViewModel(activity: FragmentActivity): FavoriteViewModel {
        // Use a Factory to inject dependencies into the ViewModel
//        val factory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProviders.of(activity, factory).get(FavoriteViewModel::class.java)
    }

    private fun showMovieList(
        listMovie: PagedList<MovieModel>,
        adapter: ListMoviePagedAdapter
    ) {
        if (listMovie.size > 0) {
            recycleMovie.visible()
            adapter.submitList(listMovie)
            adapter.notifyDataSetChanged()
            ItemClickSupport.addTo(recycleMovie).setOnItemClickListener(object : ItemClickSupport.OnItemClickListener {
                override fun onItemClicked(recyclerView: RecyclerView, position: Int, v: View) {
                    context?.startActivity<DetailActivity>("data" to listMovie[position], "index" to index)
                }
            })
        } else {
            recycleMovie.gone()
        }
    }

    private fun showTvShowList(
        listTvShow: PagedList<TvShowModel>,
        adapter: ListTvShowPagedAdapter
    ) {
        if (listTvShow.size > 0) {
            recycleMovie.visible()
            adapter.submitList(listTvShow)
            adapter.notifyDataSetChanged()
            ItemClickSupport.addTo(recycleMovie).setOnItemClickListener(object : ItemClickSupport.OnItemClickListener {
                override fun onItemClicked(recyclerView: RecyclerView, position: Int, v: View) {
                    context?.startActivity<DetailActivity>("data" to listTvShow[position], "index" to index)
                }
            })
        } else {
            recycleMovie.gone()
        }
    }

    private fun createDialog() {
        progressDialog = SweetAlertDialog(activity, SweetAlertDialog.PROGRESS_TYPE)
            .setTitleText(getString(R.string.loading))
            .setContentText(getString(R.string.waiting_text))
    }

    companion object {
        private const val ARG_SECTION_NUMBER = "section_number"

        @JvmStatic
        fun newInstance(sectionNumber: Int): FavoriteFragment {
            return FavoriteFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }
}
