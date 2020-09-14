package com.m2f.IMDB.core.common.model.domain


data class Character(
    val id: Int,
    val name: String,
    val description: String,
    val modified: String,
    val thumbnail: Thumbnail,
    val resourceURI: String,
    val comics: ItemList,
    val series: ItemList,
    val urls: List<Url>
)