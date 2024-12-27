package com.habithatch.demo.ui.common

data class DialogState(
    val show: Boolean = false,
    val title: String = "",
    val message: String = "",
    val onConfirm: () -> Unit = {},
    val onDismiss: () -> Unit = {},
)
