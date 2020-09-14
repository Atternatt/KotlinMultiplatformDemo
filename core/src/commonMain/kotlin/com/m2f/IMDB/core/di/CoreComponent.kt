package com.m2f.IMDB.core.di

import com.m2f.IMDB.core.Config
import com.m2f.IMDB.core.features.characters.di.CharactersComponent
import com.m2f.IMDB.core.features.characters.di.DefaultCharactersComponent
import com.m2f.IMDB.core.model.NetworkConfiguration
import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.logging.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.serialization.json.Json


interface CoreComponent {

    companion object {
        //entrypoint for all the external dependencies
        fun defaultInstance(): CoreComponent = CoreModule()
    }

    fun charactersComponent(): CharactersComponent


}

internal class CoreModule : CoreComponent {

    override fun charactersComponent(): CharactersComponent {
        return DefaultCharactersComponent(networkConfiguration, coroutineScope)
    }

    //region private dependencies
    private val coroutineScope: CoroutineScope by lazy { CoroutineScope(Dispatchers.Default) }

    private val networkConfiguration by lazy {
        NetworkConfiguration(
            httpClient,
            Config.API_PATH,
            json,
            globalHeaders = emptyList()
        )
    }

    private val json: Json by lazy {
        Json {
            ignoreUnknownKeys = true
            isLenient = true
        }
    }

    private val httpClient: HttpClient by lazy {
        HttpClient {
            install(JsonFeature) {
                serializer = defaultSerializer()
            }
            install(Logging) {
                logger = Logger.SIMPLE
                level = LogLevel.ALL
            }
        }
    }
    //endregion

}
