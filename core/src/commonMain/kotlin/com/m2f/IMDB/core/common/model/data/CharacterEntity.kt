package com.m2f.IMDB.core.common.model.data


import kotlinx.serialization.Serializable

@Serializable
data class CharacterEntity(
    val id: Int,
    val name: String,
    val description: String,
    val modified: String,
    val thumbnail: ThumbnailEntity,
    val resourceURI: String,
    val comics: ItemEntityList,
    val series: ItemEntityList,
    val urls: List<UrlEntity>
)