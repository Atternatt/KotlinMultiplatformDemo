package com.m2f.IMDB.core.common.model.data.mapper

import com.harmony.kotlin.data.mapper.Mapper
import com.m2f.IMDB.core.common.model.data.CharacterEntity
import com.m2f.IMDB.core.common.model.data.ItemEntityList
import com.m2f.IMDB.core.common.model.data.ThumbnailEntity
import com.m2f.IMDB.core.common.model.data.UrlEntity
import com.m2f.IMDB.core.common.model.domain.Character
import com.m2f.IMDB.core.common.model.domain.ItemList
import com.m2f.IMDB.core.common.model.domain.Thumbnail
import com.m2f.IMDB.core.common.model.domain.Url


class CharacterEntityToCharacterMapper(
    private val thumbnailMapper: Mapper<ThumbnailEntity, Thumbnail>,
    private val itemListMapper: Mapper<ItemEntityList, ItemList>,
    private val urlMapper: Mapper<UrlEntity, Url>
) : Mapper<CharacterEntity, Character> {
    override fun map(from: CharacterEntity): Character = with(from) {
        Character(
            id = id,
            name = name,
            description = description,
            modified = modified,
            thumbnail = thumbnailMapper.map(thumbnail),
            resourceURI = resourceURI,
            comics = itemListMapper.map(comics),
            series = itemListMapper.map(series),
            urls = urls.map(urlMapper)
        )
    }
}