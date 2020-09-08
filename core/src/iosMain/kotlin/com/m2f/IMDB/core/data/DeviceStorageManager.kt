package com.m2f.IMDB.core.data

actual class DeviceStorageManager actual constructor() {

    /**
     * Retrieve all values from the storage.
     */
    actual fun getAll(key: String): Map<String, *> {
        throw Throwable()
    }

    /**
     * Retrieve a String value stored at [key]. If storage doesn't contain [key] - returns [defaultValue].
     */
    actual fun getString(key: String, defaultValue: String?): String? {
        throw Throwable()
    }

    /**
     * Put a String [value] stored at [key] to the storage.
     */
    actual fun putString(key: String, value: String) {
    }

    /**
     * Retrieve an Int value stored at [key]. If storage doesn't contain [key] - returns [defaultValue].
     */
    actual fun getInt(key: String, defaultValue: Int): Int {
        throw Throwable()
    }

    /**
     * Put an Int [value] stored at [key] to the storage.
     */
    actual fun putInt(key: String, value: Int) {
    }

    /**
     * Retrieve a Long value stored at [key]. If storage doesn't contain [key] - returns [defaultValue].
     */
    actual fun getLong(key: String, defaultValue: Long): Long {
        throw Throwable()
    }

    /**
     * Put a Long [value] stored at [key] to the storage.
     */
    actual fun putLong(key: String, value: Long) {
    }

    /**
     * Retrieve a Float value stored at [key]. If storage doesn't contain [key] - returns [defaultValue].
     */
    actual fun getFloat(key: String, defaultValue: Float): Float {
        throw Throwable()
    }

    /**
     * Put a Float [value] stored at [key] to the storage.
     */
    actual fun putFloat(key: String, value: Float) {
    }

    /**
     * Retrieve a Double value stored at [key]. If storage doesn't contain [key] - returns [defaultValue].
     */
    actual fun getDouble(key: String, defaultValue: Double): Double {
        throw Throwable()
    }

    /**
     * Put a Double [value] stored at [key] to the storage.
     */
    actual fun putDouble(key: String, value: Double) {
    }

    /**
     * Retrieve a Boolean value stored at [key]. If storage doesn't contain [key] - returns [defaultValue].
     */
    actual fun getBoolean(key: String, defaultValue: Boolean): Boolean {
        throw Throwable()
    }

    /**
     * Put a Boolean [value] stored at [key] to the storage.
     */
    actual fun putBoolean(key: String, value: Boolean) {
    }

    /**
     * Checks whether the storage contains a value with specified [key].
     */
    actual fun contains(key: String): Boolean {
        throw Throwable()
    }

    /**
     * Removes value with specified [key] from the storage
     */
    actual fun remove(key: String) {
    }

    /**
     * Removes all values from the storage
     */
    actual fun clear() {
    }

}