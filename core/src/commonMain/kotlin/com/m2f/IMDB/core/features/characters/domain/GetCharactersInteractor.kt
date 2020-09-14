package com.m2f.IMDB.core.features.characters.domain

import com.m2f.IMDB.core.common.model.domain.Character


interface GetCharactersInteractor {

    suspend operator fun invoke(forceRefresh: Boolean): List<Character>
}