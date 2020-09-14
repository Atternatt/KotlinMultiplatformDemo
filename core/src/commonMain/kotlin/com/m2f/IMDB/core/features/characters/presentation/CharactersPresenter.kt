package com.m2f.IMDB.core.features.characters.presentation

import com.m2f.IMDB.core.common.model.domain.Character
import com.m2f.IMDB.core.features.characters.domain.GetCharactersInteractor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext


interface CharactersPresenter {

    fun onActionRetrieveCharacters(forceRefresh: Boolean)

    interface View {
        fun onEventCharactersRetrieved(characterList: List<Character>)
        fun onEventFailedToRetrieveCharacters()
    }
}

internal class DefaultCharactersPresenter(
    private val view: CharactersPresenter.View,
    private val getCharactersInteractor: GetCharactersInteractor
) : CharactersPresenter, CoroutineScope {

    override val coroutineContext: CoroutineContext by lazy { Job() }

    override fun onActionRetrieveCharacters(forceRefresh: Boolean) {
        launch(Dispatchers.Main) {
            try {
                val characters = getCharactersInteractor(forceRefresh)
                view.onEventCharactersRetrieved(characters)
            } catch (ex: Exception) {
                view.onEventFailedToRetrieveCharacters()
            }
        }
    }


}