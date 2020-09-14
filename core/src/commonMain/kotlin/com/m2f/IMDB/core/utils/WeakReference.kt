package com.m2f.IMDB.core.utils

import kotlin.reflect.KProperty


expect class WeakReference<T : Any>(referred: T) {
    fun clear()
    fun get(): T?
}


/**
 * Delegate property
 */
class WeakRef<out T : Any>(element: T) {
    private val weak = WeakReference(element)
    operator fun getValue(thisRef: Any, property: KProperty<*>): T? = weak.get()
}