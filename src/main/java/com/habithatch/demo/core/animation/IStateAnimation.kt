package com.habithatch.demo.core.animation

import kotlinx.coroutines.flow.StateFlow

interface IStateAnimation {
    val state: StateFlow<Any?>

    fun start()

    fun stop()
}
