package com.habithatch.demo.ui.goals

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.habithatch.demo.data.models.GoalModel

@Suppress("ktlint:standard:function-naming","FunctionNaming")
@Composable
fun PriorityToggle(
    modifier: Modifier = Modifier.size(36.dp),
    priority: GoalModel.Priority,
    onPriorityToggle: () -> Unit,
) {
    IconButton(
        onClick = onPriorityToggle,
        modifier = modifier,
    ) {
        Icon(
            painter = painterResource(id = priority.iconResourceId),
            contentDescription = priority.label,
            tint = priority.getColor(),
        )
    }
}
