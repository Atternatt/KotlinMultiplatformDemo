package com.m2f.imdb.features.characters

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.m2f.IMDB.core.common.model.domain.Character
import com.m2f.IMDB.core.di.CoreComponent
import com.m2f.IMDB.core.features.characters.presentation.CharactersPresenter
import com.m2f.imdb.R
import com.m2f.imdb.common.showGenericErrorDialog
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_characters.*
import javax.inject.Inject

@AndroidEntryPoint
class CharactersActivity : AppCompatActivity(), CharactersPresenter.View {

    companion object {
        const val TAG = "MainActivity"
    }

    @Inject
    lateinit var coreComponent: CoreComponent

    private val presenter: CharactersPresenter by lazy {
        coreComponent.charactersComponent().charactersPresenter(this)
    }

    private val characterAdapter: CharacterAdapter by lazy { CharacterAdapter { character ->
        //todo: show details of the character
    } }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_characters)

        presenter.onActionRetrieveCharacters(false)
        list_characters.adapter = characterAdapter

        swiperefresh.setOnRefreshListener {
            presenter.onActionRetrieveCharacters(true)
        }
    }

    override fun onEventCharactersRetrieved(characterList: List<Character>) {
        Log.d(TAG, characterList.size.toString())
        swiperefresh.isRefreshing = false
        characterAdapter.initData(characterList)
    }

    override fun onEventFailedToRetrieveCharacters(ex: Exception) {
        showGenericErrorDialog()
        swiperefresh.isRefreshing = false
    }
}