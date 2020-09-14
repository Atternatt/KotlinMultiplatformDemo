package com.m2f.IMDB.core.features.characters.domain

import com.harmony.kotlin.data.operation.DefaultOperation
import com.harmony.kotlin.data.operation.MainSyncOperation
import com.harmony.kotlin.data.repository.GetRepository
import com.m2f.IMDB.core.common.model.domain.Character
import com.m2f.IMDB.core.features.characters.data.query.CharactersQuery
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.withContext


internal class DefaultGetCharactersInteractor(
    private val getCharactersRepository: GetRepository<Character>,
    private val coroutineScope: CoroutineScope
) : GetCharactersInteractor {
    override suspend fun invoke(forceRefresh: Boolean): List<Character> =
        withContext(coroutineScope.coroutineContext) {
            val operation = if (forceRefresh) MainSyncOperation else DefaultOperation
            getCharactersRepository.getAll(CharactersQuery, operation)
        }
}