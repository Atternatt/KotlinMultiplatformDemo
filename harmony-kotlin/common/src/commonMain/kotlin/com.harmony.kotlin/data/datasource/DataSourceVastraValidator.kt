package com.harmony.kotlin.data.datasource

import com.harmony.kotlin.data.error.ObjectNotValidException
import com.harmony.kotlin.data.query.Query
import com.harmony.kotlin.data.validator.vastra.ValidationService
import com.harmony.kotlin.data.validator.vastra.strategies.ValidationStrategyDataSource

class DataSourceVastraValidator<T : ValidationStrategyDataSource>(private val getDataSource: GetDataSource<T>,
                                                                  private val putDataSource: PutDataSource<T>,
                                                                  private val deleteDataSource: DeleteDataSource,
                                                                  private val validator: ValidationService) : GetDataSource<T>, PutDataSource<T>, DeleteDataSource {

  override suspend fun get(query: Query): T = getDataSource.get(query).let {
    if (!validator.isValid(it)) throw ObjectNotValidException() else it
  }

  override suspend fun getAll(query: Query): List<T> = getDataSource.getAll(query).let {
    if (!validator.isValid(it)) throw ObjectNotValidException() else it
  }

  override suspend fun put(query: Query, value: T?): T = putDataSource.put(query, value)

  override suspend fun putAll(query: Query, value: List<T>?): List<T> = putDataSource.putAll(query, value)

  override suspend fun delete(query: Query) = deleteDataSource.delete(query)

  override suspend fun deleteAll(query: Query) = deleteDataSource.deleteAll(query)

}

