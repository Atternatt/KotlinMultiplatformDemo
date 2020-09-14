package com.m2f.IMDB.core.common.model.domain


class ItemList(
    val collectionURI: String,
    val items: List<Item>,
) : List<Item> by items