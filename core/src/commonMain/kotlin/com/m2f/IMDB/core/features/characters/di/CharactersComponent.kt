package com.m2f.IMDB.core.features.characters.di

import com.harmony.kotlin.data.datasource.toGetRepository
import com.harmony.kotlin.data.mapper.Mapper
import com.harmony.kotlin.data.repository.GetRepository
import com.m2f.IMDB.core.common.model.data.CharacterEntity
import com.m2f.IMDB.core.common.model.data.mapper.*
import com.m2f.IMDB.core.common.model.domain.Character
import com.m2f.IMDB.core.features.characters.data.GetCharactersNetworkDataSource
import com.m2f.IMDB.core.features.characters.domain.DefaultGetCharactersInteractor
import com.m2f.IMDB.core.features.characters.domain.GetCharactersInteractor
import com.m2f.IMDB.core.features.characters.presentation.CharactersPresenter
import com.m2f.IMDB.core.features.characters.presentation.DefaultCharactersPresenter
import com.m2f.IMDB.core.model.NetworkConfiguration
import kotlinx.coroutines.CoroutineScope


interface CharactersComponent {

    fun charactersPresenter(view: CharactersPresenter.View): CharactersPresenter
}

internal class DefaultCharactersComponent(
    private val networkConfiguration: NetworkConfiguration,
    private val coroutineScope: CoroutineScope
) : CharactersComponent {

    override fun charactersPresenter(view: CharactersPresenter.View): CharactersPresenter {
        return DefaultCharactersPresenter(view, providesGetCharactersInteractor())
    }

    //region private dependencies
    private fun providesGetCharactersNetworkDatasource(): GetCharactersNetworkDataSource =
        GetCharactersNetworkDataSource(networkConfiguration)

    private fun providesCharacterMapper(): Mapper<CharacterEntity, Character> {
        return CharacterEntityToCharacterMapper(
            thumbnailMapper = ThumnailentityToThumbnailMapper(),
            itemListMapper = ItemEntityListToItemListMapper(
                itemMapper = ItemEntityToItemMapper()
            ),
            urlMapper = UrlEntityToUrlMapper()
        )
    }

    private fun providesGetCharactersRepository(
        mapper: Mapper<CharacterEntity, Character>
    ): GetRepository<Character> {
        return providesGetCharactersNetworkDatasource().toGetRepository(mapper)
    }

    private fun providesGetCharactersInteractor(): GetCharactersInteractor {
        return DefaultGetCharactersInteractor(
            getCharactersRepository = providesGetCharactersRepository(
                mapper = providesCharacterMapper()
            ),
            coroutineScope = coroutineScope
        )
    }

    //endregion

}