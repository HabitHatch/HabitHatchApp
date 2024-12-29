package com.habithatch.demo.ui.goals.table

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Suppress("ktlint:standard:function-naming", "FunctionNaming")
@Composable
fun GoalQueryTable(
    modifier: Modifier = Modifier,
    filterContent: @Composable () -> Unit,
    sortContent: @Composable () -> Unit,
    goalsContent: @Composable () -> Unit,
) {
    Column(
        modifier = modifier,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().height(48.dp).padding(vertical = 4.dp),
        ) {
            filterContent()
            Spacer(modifier = Modifier.width(16.dp))
            sortContent()
        }
        goalsContent()
    }
}
