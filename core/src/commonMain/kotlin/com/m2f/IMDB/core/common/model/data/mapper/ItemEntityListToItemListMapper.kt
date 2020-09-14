package com.m2f.IMDB.core.common.model.data.mapper

import com.harmony.kotlin.data.mapper.Mapper
import com.m2f.IMDB.core.common.model.data.ItemEntity
import com.m2f.IMDB.core.common.model.data.ItemEntityList
import com.m2f.IMDB.core.common.model.domain.Item
import com.m2f.IMDB.core.common.model.domain.ItemList


class ItemEntityListToItemListMapper(private val itemMapper: Mapper<ItemEntity, Item>) :
    Mapper<ItemEntityList, ItemList> {

    override fun map(from: ItemEntityList): ItemList = with(from) {
        ItemList(collectionURI, items.map(itemMapper))
    }
}