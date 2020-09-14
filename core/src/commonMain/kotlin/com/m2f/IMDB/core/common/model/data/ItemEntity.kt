package com.m2f.IMDB.core.common.model.data


import kotlinx.serialization.Serializable

@Serializable
data class ItemEntity(
    val resourceURI: String,
    val name: String
)