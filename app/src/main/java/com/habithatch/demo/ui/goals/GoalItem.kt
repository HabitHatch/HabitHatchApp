package com.habithatch.demo.ui.goals

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.habithatch.demo.data.models.GoalModel

@Composable
fun GoalItem(
    goal: GoalModel,
    rowPadding: PaddingValues = PaddingValues(8.dp),
    checkBoxPadding: PaddingValues = PaddingValues(end = 8.dp),
    onToggleGoalStatus: () -> Unit = {},
    onGoalClicked: () -> Unit = {}
) {
    val cardShape = MaterialTheme.shapes.medium
    Card(
            modifier = Modifier
                .fillMaxWidth()
                .then(
                        Modifier.border(
                                width = 1.dp,
                                color = goal.priority.getColor(),
                                shape = cardShape
                        )
                )
                .clickable(onClick = onGoalClicked),
            colors = CardDefaults.cardColors(
                    containerColor = if (goal.isDone()) MaterialTheme.colorScheme.secondaryContainer else MaterialTheme.colorScheme.primaryContainer,
            ),
            shape = cardShape
    ) {
        Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(rowPadding),
                verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                    checked = goal.isDone(),
                    onCheckedChange = { onToggleGoalStatus() },
                    modifier = Modifier.padding(checkBoxPadding)
            )

            Text(
                    text = goal.title,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.titleMedium.copy(
                            textDecoration = if (goal.isDone()) TextDecoration.LineThrough else TextDecoration.None,
                            color = if (goal.isDone()) MaterialTheme.colorScheme.onPrimaryContainer else MaterialTheme.colorScheme.onPrimary
                    ),
                    modifier = Modifier.weight(1f)
            )
            Icon(
                    modifier = Modifier.weight(0.25f),
                    painter = painterResource(goal.priority.iconResourceId),
                    contentDescription = goal.priority.label,
                    tint = goal.priority.getColor()
            )
        }
    }
}