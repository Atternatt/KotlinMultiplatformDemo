package com.m2f.IMDB.core.features.characters.data

import com.harmony.kotlin.data.datasource.GetDataSource
import com.harmony.kotlin.data.datasource.network.DefaultGenericNetworkErrorMapper
import com.harmony.kotlin.data.error.DataNotFoundException
import com.harmony.kotlin.data.error.QueryNotSupportedException
import com.harmony.kotlin.data.mapper.Mapper
import com.harmony.kotlin.data.query.Query
import com.m2f.IMDB.core.Config
import com.m2f.IMDB.core.common.model.data.ApiResult
import com.m2f.IMDB.core.common.model.data.CharacterEntity
import com.m2f.IMDB.core.features.characters.data.query.CharactersQuery
import com.m2f.IMDB.core.model.NetworkConfiguration
import com.soywiz.klock.DateTime
import com.soywiz.krypto.md5
import io.ktor.client.features.*
import io.ktor.client.request.*
import io.ktor.utils.io.core.*
import kotlinx.serialization.decodeFromString


class GetCharactersNetworkDataSource(
    private val networkConfiguration: NetworkConfiguration,
    private val errorMapper: Mapper<ClientRequestException, Exception> = DefaultGenericNetworkErrorMapper
) : GetDataSource<CharacterEntity> {

    override suspend fun get(query: Query): CharacterEntity = throw NotImplementedError()

    override suspend fun getAll(query: Query): List<CharacterEntity> = when (query) {
        is CharactersQuery -> try {
            val result: ApiResult = with(networkConfiguration) {
                val r = httpClient.get<String>(actors) {
                    val now = DateTime.nowUnix()
                    parameter("ts", now)
                    parameter("apikey", Config.PUBLIC_API_KEY)
                    parameter("hash", "$now${Config.PRIVATE_API_KEY}${Config.PUBLIC_API_KEY}".toByteArray().md5().hex)
                }
                json.decodeFromString(r)
            }
            if(result.code == 200) {
                result._data?.results!!
            } else {
                throw DataNotFoundException()
            }
        } catch (ex: ClientRequestException) {
            throw errorMapper.map(ex)
        }
        else -> throw QueryNotSupportedException()
    }
}