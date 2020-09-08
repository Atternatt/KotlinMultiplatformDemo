package com.m2f.IMDB.core.data

import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import androidx.annotation.RequiresApi

actual class DeviceStorageManager actual constructor() {

  private val sharedPreferences: SharedPreferences =
      application.applicationContext.getSharedPreferences("user", Context.MODE_PRIVATE)

  /**
   * Retrieve all values from the storage.
   */
  actual fun getAll(key: String): Map<String, *> {
    return sharedPreferences.all
  }

  /**
   * Retrieve a String value stored at [key]. If storage doesn't contain [key] - returns [defaultValue].
   */
  actual fun getString(key: String, defaultValue: String?): String? =
      sharedPreferences.getString(key, defaultValue)

  /**
   * Put a String [value] stored at [key] to the storage.
   */
  @RequiresApi(Build.VERSION_CODES.GINGERBREAD)
  actual fun putString(key: String, value: String) {
    sharedPreferences.edit().putString(key, value).apply()
  }

  /**
   * Retrieve an Int value stored at [key]. If storage doesn't contain [key] - returns [defaultValue].
   */
  actual fun getInt(key: String, defaultValue: Int): Int =
      sharedPreferences.getInt(key, defaultValue)

  /**
   * Put an Int [value] stored at [key] to the storage.
   */
  @RequiresApi(Build.VERSION_CODES.GINGERBREAD)
  actual fun putInt(key: String, value: Int) {
    sharedPreferences.edit().putInt(key, value).apply()
  }

  /**
   * Retrieve a Long value stored at [key]. If storage doesn't contain [key] - returns [defaultValue].
   */
  @RequiresApi(Build.VERSION_CODES.GINGERBREAD)
  actual fun getLong(key: String, defaultValue: Long): Long =
      sharedPreferences.getLong(key, defaultValue)

  /**
   * Put a Long [value] stored at [key] to the storage.
   */
  @RequiresApi(Build.VERSION_CODES.GINGERBREAD)
  actual fun putLong(key: String, value: Long) {
    return sharedPreferences.edit().putLong(key, value).apply()
  }

  /**
   * Retrieve a Float value stored at [key]. If storage doesn't contain [key] - returns [defaultValue].
   */
  actual fun getFloat(key: String, defaultValue: Float): Float =
      sharedPreferences.getFloat(key, defaultValue)

  /**
   * Put a Float [value] stored at [key] to the storage.
   */
  @RequiresApi(Build.VERSION_CODES.GINGERBREAD)
  actual fun putFloat(key: String, value: Float) {
    sharedPreferences.edit().putFloat(key, value).apply()
  }

  /**
   * Retrieve a Double value stored at [key]. If storage doesn't contain [key] - returns [defaultValue].
   */
  actual fun getDouble(key: String, defaultValue: Double): Double =
      Double.fromBits(sharedPreferences.getLong(key, defaultValue.toRawBits()))

  /**
   * Put a Double [value] stored at [key] to the storage.
   */
  @RequiresApi(Build.VERSION_CODES.GINGERBREAD)
  actual fun putDouble(key: String, value: Double) {
    sharedPreferences.edit().putLong(key, value.toRawBits()).apply()
  }

  /**
   * Retrieve a Boolean value stored at [key]. If storage doesn't contain [key] - returns [defaultValue].
   */
  actual fun getBoolean(key: String, defaultValue: Boolean): Boolean =
      sharedPreferences.getBoolean(key, defaultValue)

  /**
   * Put a Boolean [value] stored at [key] to the storage.
   */
  @RequiresApi(Build.VERSION_CODES.GINGERBREAD)
  actual fun putBoolean(key: String, value: Boolean) {
    sharedPreferences.edit().putBoolean(key, value).apply()
  }

  /**
   * Checks whether the storage contains a value with specified [key].
   */
  actual fun contains(key: String): Boolean = sharedPreferences.contains(key)

  /**
   * Removes value with specified [key] from the storage
   */
  @RequiresApi(Build.VERSION_CODES.GINGERBREAD)
  actual fun remove(key: String) {
    sharedPreferences.edit().remove(key).apply()
  }

  /**
   * Removes all values from the storage
   */
  @RequiresApi(Build.VERSION_CODES.GINGERBREAD)
  actual fun clear() {
    sharedPreferences.edit().clear().apply()
  }

}