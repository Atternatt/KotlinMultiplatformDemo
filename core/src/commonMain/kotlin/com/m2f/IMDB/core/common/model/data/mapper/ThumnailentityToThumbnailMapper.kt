package com.m2f.IMDB.core.common.model.data.mapper

import com.harmony.kotlin.data.mapper.Mapper
import com.m2f.IMDB.core.common.model.data.ThumbnailEntity
import com.m2f.IMDB.core.common.model.domain.Thumbnail


class ThumnailentityToThumbnailMapper: Mapper<ThumbnailEntity, Thumbnail> {
    override fun map(from: ThumbnailEntity): Thumbnail = with(from) {
        Thumbnail(path, extension)
    }
}