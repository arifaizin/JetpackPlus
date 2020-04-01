package com.arif.jetpackpro.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Singleton
class ViewModelFactory @Inject constructor(
    private val creators: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val creator = creators[modelClass] ?: creators.entries.firstOrNull {
            modelClass.isAssignableFrom(it.key)
        }?.value ?: throw IllegalArgumentException("unknown model class $modelClass")
        @Suppress("UNCHECKED_CAST")
        return creator.get() as T
    }
}
//@Singleton
////TODO 1: Add @Inject - Dagger tau bagaimana ViewModelFactoey dibuat, namun masih belum tau bagaimana MovieRepository dibuat
//class ViewModelFactory @Inject constructor(private val movieRepository: MovieRepository) :
//    ViewModelProvider.NewInstanceFactory() {
//
//    @Suppress("UNCHECKED_CAST")
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        return when {
//            modelClass.isAssignableFrom(MovieViewModel::class.java) -> MovieViewModel(movieRepository) as T
//            modelClass.isAssignableFrom(DetailMovieViewModel::class.java) -> DetailMovieViewModel(movieRepository) as T
//            modelClass.isAssignableFrom(FavoriteViewModel::class.java) -> FavoriteViewModel(movieRepository) as T
//            else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
//        }
//    }

//    companion object {
//        @Volatile
//        private var INSTANCE: ViewModelFactory? = null
//
//        fun getInstance(application: Application): ViewModelFactory? {
//            if (INSTANCE == null) {
//                synchronized(ViewModelFactory::class.java) {
//                    if (INSTANCE == null) {
//                        INSTANCE = ViewModelFactory(Injection.provideRepository(application))
//                    }
//                }
//            }
//            return INSTANCE
//        }
//    }
//}