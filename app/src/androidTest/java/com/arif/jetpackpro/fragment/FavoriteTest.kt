package com.arif.jetpackpro.fragment

import androidx.paging.LivePagedListBuilder
import androidx.test.filters.LargeTest
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.arif.jetpackpro.databaseTestModule
import com.arif.jetpackpro.model.movie.MovieModel
import com.arif.jetpackpro.room.MovieDao
import com.arif.jetpackpro.room.MovieDatabase
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.loadKoinModules
import org.koin.core.context.stopKoin
import org.koin.java.KoinJavaComponent.inject
import org.koin.test.KoinTest

@LargeTest
@RunWith(AndroidJUnit4ClassRunner::class)
class FavoriteTest : KoinTest {
//    @Rule
//    @JvmField
//    var mActivityTestRule = ActivityTestRule(FavoriteActivity::class.java)

    val movieDatabase by inject(MovieDatabase::class.java)
    val movieDAO by inject(MovieDao::class.java)

    @Before
    fun setUp() {
//        val application = InstrumentationRegistry.getInstrumentation()
//            .targetContext.applicationContext as MyTestApplication
//        application.injectModule(databaseTestModule)
        loadKoinModules(databaseTestModule)
    }

    @Test
    fun testSave() {
//        onView(withId(R.id.action_favorite)).perform(click())
        val movie = MovieModel(title = "Film Apik", posterPath = "https://m.media-amazon.com/images/M/MV5BNzYyZWIwZjQtZGVjZi00NWIxLTk0ODMtNzA3YzE5MWM3OWI0XkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_.jpg")
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
        stopKoin()
    }
}