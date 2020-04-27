package com.arifaizin.core.data.datasource.remote

import androidx.annotation.Nullable


class ApiResponse<T>(
    val status: StatusResponse, @param:Nullable @field:Nullable
    val body: T, @param:Nullable @field:Nullable
    val message: String?
) {
    companion object {

        fun <T> success(@Nullable body: T): ApiResponse<T> {
            return ApiResponse(
                StatusResponse.SUCCESS,
                body,
                null
            )
        }

        fun <T> error(msg: String, @Nullable body: T): ApiResponse<T> {
            return ApiResponse(
                StatusResponse.ERROR,
                body,
                msg
            )
        }
    }

}