package com.habithatch.demo.ui.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Suppress("ktlint:standard:function-naming", "FunctionNaming")
@Composable
fun ImageTextCard(
    modifier: Modifier = Modifier,
    imageContent: @Composable () -> Unit,
    text: @Composable () -> Unit,
    spacing: Dp = 8.dp,
    onSelected: () -> Unit,
) {
    Column(
        modifier = modifier.clickable { onSelected() },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(spacing),
    ) {
        imageContent()
        text()
    }
}
