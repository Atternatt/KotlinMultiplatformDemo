package com.m2f.IMDB.core

expect object Platform {
    fun name(): String
}

fun hello(): String = "Hello from ${Platform.name()}"
