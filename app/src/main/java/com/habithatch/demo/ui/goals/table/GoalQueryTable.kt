package com.habithatch.demo.ui.goals.table

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Suppress("ktlint:standard:function-naming", "FunctionNaming")
@Composable
fun GoalQueryTable(
    modifier: Modifier = Modifier,
    filterContent: @Composable (defaultModifier: Modifier) -> Unit,
    sortContent: @Composable (defaultModifier: Modifier) -> Unit,
    goalsContent: @Composable () -> Unit,
) {
    val defaultModifier =
        Modifier
            .fillMaxHeight()
            .widthIn(min = 100.dp, max = 200.dp)

    Column(
        modifier = modifier,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().height(48.dp).padding(vertical = 4.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            filterContent(defaultModifier)
            sortContent(defaultModifier)
        }
        goalsContent()
    }
}
