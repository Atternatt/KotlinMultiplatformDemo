package com.m2f.IMDB.core.common.model.data


import kotlinx.serialization.Serializable

@Serializable
data class UrlEntity(
    val type: String,
    val url: String
)