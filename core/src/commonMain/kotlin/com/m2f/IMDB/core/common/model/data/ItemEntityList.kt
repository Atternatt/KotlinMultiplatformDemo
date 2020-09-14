package com.m2f.IMDB.core.common.model.data


import kotlinx.serialization.Serializable

@Serializable
data class ItemEntityList(
    val available: Int,
    val collectionURI: String,
    val items: List<ItemEntity>,
    val returned: Int
) : List<ItemEntity> by items