package com.m2f.IMDB.core.model

import io.ktor.client.*
import kotlinx.serialization.json.Json


data class NetworkConfiguration(
    val httpClient: HttpClient,
    val apiPath: String,
    val json: Json,
    val globalHeaders: List<Pair<String, String>> = emptyList()
) {
    val topCelebritiesIds: String = "$apiPath/actors/list-most-popular-celebs"

}