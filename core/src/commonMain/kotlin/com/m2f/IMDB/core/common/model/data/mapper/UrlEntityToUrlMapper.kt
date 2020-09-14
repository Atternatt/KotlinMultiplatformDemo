package com.m2f.IMDB.core.common.model.data.mapper

import com.harmony.kotlin.data.mapper.Mapper
import com.m2f.IMDB.core.common.model.data.UrlEntity
import com.m2f.IMDB.core.common.model.domain.Url


class UrlEntityToUrlMapper: Mapper<UrlEntity, Url> {
    override fun map(from: UrlEntity): Url = with(from) {
        Url(type, url)
    }
}