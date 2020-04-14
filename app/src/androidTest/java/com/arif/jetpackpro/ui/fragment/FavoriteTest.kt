package com.arif.jetpackpro.ui.fragment

import androidx.paging.LivePagedListBuilder
import androidx.test.filters.LargeTest
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.arifaizin.core.data.model.movie.MovieModel
import com.arifaizin.core.data.room.MovieDao
import com.arifaizin.core.data.room.MovieDatabase
import org.junit.*
import org.junit.runner.RunWith
import javax.inject.Inject

@LargeTest
@RunWith(AndroidJUnit4ClassRunner::class)
class FavoriteTest {
    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(FavoriteActivity::class.java)

    @Inject
    lateinit var movieDatabase: MovieDatabase

    @Inject
    lateinit var movieDAO: MovieDao

    private lateinit var testAppComponent: TestComponent


    @Before
    fun setUp() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext.applicationContext
        val testComponent = DaggerTestComponent.factory().create(context)
        testComponent.inject(this)
    }

    @Test
    fun testSave() {
        val movie = MovieModel(
            title = "Film Apik",
            posterPath = "https://m.media-amazon.com/images/M/MV5BNzYyZWIwZjQtZGVjZi00NWIxLTk0ODMtNzA3YzE5MWM3OWI0XkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_.jpg"
        )
        val listMovie = arrayListOf<MovieModel>()
        listMovie.add(movie)
        val id = movieDAO.insertMovies(listMovie)

        val dao = movieDAO.getFavoriteMovie()
        val requestedMovie = LivePagedListBuilder(dao, 10).build().value?.toList()

        // compare result
        Assert.assertEquals(listMovie[0].id, requestedMovie?.get(0)?.id)
        Assert.assertEquals(1, id[0])

    }

    @After
    fun tearDown() {
        movieDatabase.close()
    }
}