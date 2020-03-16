package com.arif.jetpackpro.model.tvshow

import com.google.gson.annotations.SerializedName
import javax.annotation.Generated

@Generated("com.robohorse.robopojogenerator")
data class TvShowResponse(

    @field:SerializedName("page")
    val page: Int? = null,

    @field:SerializedName("total_pages")
    val totalPages: Int? = null,

    @field:SerializedName("results")
    val results: List<TvShowModel>? = ArrayList(),

    @field:SerializedName("total_results")
    val totalResults: Int? = null
)