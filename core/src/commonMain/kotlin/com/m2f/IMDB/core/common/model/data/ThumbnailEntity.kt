package com.m2f.IMDB.core.common.model.data


import kotlinx.serialization.Serializable

@Serializable
data class ThumbnailEntity(
    val path: String,
    val extension: String
)