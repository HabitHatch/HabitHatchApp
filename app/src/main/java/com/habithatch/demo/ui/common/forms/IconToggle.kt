package com.habithatch.demo.ui.common.forms

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.habithatch.demo.core.query.GoalFilter

@Suppress("ktlint:standard:function-naming")
@Composable
fun IconToggle(
    modifier: Modifier = Modifier,
    iconColor: Color,
    goalFilterBuilder: GoalFilter.Builder,
    onGoalFilterChange: (GoalFilter) -> Unit,
) {
    val goalFilter = goalFilterBuilder.build()
    val isDoneStatusVisible = goalFilter.isDoneVisible()
    IconButton(
        modifier = modifier,
        onClick = {
            val newGoalFilter =
                goalFilterBuilder
                    .setDoneStatusVisibility(!isDoneStatusVisible)
                    .build()
            onGoalFilterChange(newGoalFilter)
        },
    ) {
        Icon(
            imageVector = Icons.Default.CheckCircle,
            contentDescription = "Done",
            tint = iconColor,
            modifier = Modifier.padding(horizontal = 4.dp),
        )
    }
}
