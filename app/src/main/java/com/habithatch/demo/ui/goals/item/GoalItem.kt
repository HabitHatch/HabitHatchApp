package com.habithatch.demo.ui.goals.item

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.habithatch.demo.data.models.GoalModel
import com.habithatch.demo.ui.goals.GoalStyleProvider

@Suppress("ktlint:standard:function-naming", "FunctionNaming")
@Composable
fun GoalItem(
    goal: GoalModel,
    rowPadding: PaddingValues = PaddingValues(12.dp),
    checkBoxPadding: PaddingValues = PaddingValues(end = 8.dp),
    onCycleGoalStatus: () -> Unit = {},
) {
    val goalStyle = GoalStyleProvider.getGoalStyle(goal)
    Card(
        modifier =
            Modifier
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = goalStyle.borderColor,
                    shape = goalStyle.cardShape,
                ),
        colors = goalStyle.cardColors,
        shape = goalStyle.cardShape,
    ) {
        Row(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(rowPadding),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Checkbox(
                checked = goal.isDone(),
                onCheckedChange = { onCycleGoalStatus() },
                modifier = Modifier.padding(checkBoxPadding),
            )

            Text(
                text = goal.title,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                style = goalStyle.textStyle,
                modifier = Modifier.weight(1f),
            )
            Icon(
                modifier = Modifier.weight(0.25f),
                painter = painterResource(goal.priority.iconResourceId),
                contentDescription = goal.priority.label,
                tint = goalStyle.iconColor,
            )
        }
    }
}
