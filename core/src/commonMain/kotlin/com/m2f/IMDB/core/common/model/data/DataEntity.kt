package com.m2f.IMDB.core.common.model.data


import kotlinx.serialization.Serializable

@Serializable
data class DataEntity(
    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    val results: List<CharacterEntity>
)