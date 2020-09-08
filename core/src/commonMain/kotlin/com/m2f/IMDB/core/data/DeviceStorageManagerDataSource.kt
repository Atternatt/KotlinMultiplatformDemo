package com.m2f.IMDB.core.data

import com.harmony.kotlin.data.datasource.DeleteDataSource
import com.harmony.kotlin.data.datasource.GetDataSource
import com.harmony.kotlin.data.datasource.PutDataSource
import com.harmony.kotlin.data.error.DataNotFoundException
import com.harmony.kotlin.data.query.KeyQuery
import com.harmony.kotlin.data.query.Query

class DeviceStorageDataSource<T>(
    private val deviceStorageManager: DeviceStorageManager,
    private val prefix: String = ""
): GetDataSource<T>, PutDataSource<T>, DeleteDataSource {

  override suspend fun get(query: Query): T =
      when (query) {
        is KeyQuery -> {
          val key = addPrefixTo(query.key)
          if (!deviceStorageManager.contains(key)) {
            throw DataNotFoundException()
          }

          deviceStorageManager.getAll(key) as T
        }
        else -> notSupportedQuery()
      }


  override suspend fun getAll(query: Query): List<T> =
      throw UnsupportedOperationException("getAll not supported. Use get instead")

  override suspend fun put(query: Query, value: T?): T =
      when (query) {
        is KeyQuery -> {
          value?.let {
            val key = addPrefixTo(query.key)
            when (value) {
              is String -> deviceStorageManager.putString(key, value)
              is Boolean -> deviceStorageManager.putBoolean(key, value)
              is Float -> deviceStorageManager.putFloat(key, value)
              is Int -> deviceStorageManager.putInt(key, value)
              is Long -> deviceStorageManager.putLong(key, value)
              else -> {
                throw UnsupportedOperationException("value type is not supported")
              }
            }

            return@let it
          }
              ?: throw IllegalArgumentException("${DeviceStorageDataSource::class.simpleName}: value must be not null")
        }
        else -> notSupportedQuery()
      }

  override suspend fun putAll(query: Query, value: List<T>?): List<T> =
      throw UnsupportedOperationException("putAll not supported. Use put instead")

  override suspend fun delete(query: Query) =
      when (query) {
        is KeyQuery -> {
          deviceStorageManager.remove(addPrefixTo(query.key))
        }
        else -> notSupportedQuery()
      }

  override suspend fun deleteAll(query: Query) =
      deviceStorageManager.clear()


  private fun addPrefixTo(key: String) = if (prefix.isEmpty()) key else "$prefix.$key"

}