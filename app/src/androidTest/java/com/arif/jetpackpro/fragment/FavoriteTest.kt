package com.arif.jetpackpro.fragment

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.filters.LargeTest
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.arif.jetpackpro.R
import com.arif.jetpackpro.activity.FavoriteActivity
import com.arif.jetpackpro.databaseTestModule
import com.arif.jetpackpro.model.movie.MovieModel
import com.arif.jetpackpro.room.MovieDao
import com.arif.jetpackpro.room.MovieDatabase
import com.arif.jetpackpro.util.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.loadKoinModules
import org.koin.core.context.stopKoin
import org.koin.java.KoinJavaComponent.inject
import org.koin.test.KoinTest

@LargeTest
@RunWith(AndroidJUnit4ClassRunner::class)
class FavoriteTest : KoinTest {
    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(FavoriteActivity::class.java)



    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource())
        loadKoinModules(databaseTestModule)
    }

    @Test
    fun testSave() {
        val movieDatabase by inject(MovieDatabase::class.java)
        val movieDAO by inject(MovieDao::class.java)
        onView(withId(R.id.action_favorite)).perform(click())
        val movie = MovieModel(title = "Film Apik", posterPath = "https://m.media-amazon.com/images/M/MV5BNzYyZWIwZjQtZGVjZi00NWIxLTk0ODMtNzA3YzE5MWM3OWI0XkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_.jpg")
        val listMovie = arrayListOf<MovieModel>()
        listMovie.add(movie)
        movieDAO.insertMovies(listMovie)

    }
    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource())
//        movieDatabase.close()
        stopKoin()
    }
}