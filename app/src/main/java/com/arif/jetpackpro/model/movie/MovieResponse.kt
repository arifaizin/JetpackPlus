package com.arif.jetpackpro.model.movie

import com.google.gson.annotations.SerializedName
import javax.annotation.Generated

@Generated("com.robohorse.robopojogenerator")
data class MovieResponse(

    @field:SerializedName("page")
    val page: Int? = null,

    @field:SerializedName("total_pages")
    val totalPages: Int? = null,

    @field:SerializedName("results")
    val results: List<MovieModel>? = java.util.ArrayList(),

    @field:SerializedName("total_results")
    val totalResults: Int? = null
)