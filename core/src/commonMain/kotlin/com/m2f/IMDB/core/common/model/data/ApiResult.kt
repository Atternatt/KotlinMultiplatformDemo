package com.m2f.IMDB.core.common.model.data


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ApiResult(
    val code: Int,
    val status: String,
    val copyright: String,
    val attributionText: String,
    val attributionHTML: String,
    val etag: String,
    @SerialName("data")
    val _data: DataEntity?
)