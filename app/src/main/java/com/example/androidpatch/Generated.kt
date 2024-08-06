package com.example.androidpatch

@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.BINARY)
annotation class Generated(@Suppress("unused") val reason: String)