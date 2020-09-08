package com.m2f.IMDB.core.model

//import com.harmony.kotlin.data.datasource.cache.CacheSQLStorageDataSource
import kotlinx.serialization.cbor.Cbor

data class CacheConfiguration(val cbor: Cbor = Cbor.Default,
                              /*val cacheSQLStorageDataSource: CacheSQLStorageDataSource*/) {
  companion object {
    const val databaseName = "cache-application"
  }
}