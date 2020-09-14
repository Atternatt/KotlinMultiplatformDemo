package com.m2f.IMDB.core.common.model.data.mapper

import com.harmony.kotlin.data.mapper.Mapper
import com.m2f.IMDB.core.common.model.data.ItemEntity
import com.m2f.IMDB.core.common.model.domain.Item


class ItemEntityToItemMapper: Mapper<ItemEntity, Item> {
    override fun map(from: ItemEntity): Item = with(from) {
        Item(resourceURI, name)
    }
}