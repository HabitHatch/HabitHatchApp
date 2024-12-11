package com.habithatch.demo.common

import com.habithatch.demo.data.entities.Goal
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun GoalItem(
    goal: Goal,
    onToggleDone: (Goal) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (goal.isDone) Color(0xFFE0F7FA) else Color.White
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = goal.isDone,
                onCheckedChange = { onToggleDone(goal) },
                modifier = Modifier.padding(end = 8.dp)
            )

            Text(
                text = goal.title,
                style = MaterialTheme.typography.titleMedium.copy(
                    textDecoration = if (goal.isDone) TextDecoration.LineThrough else TextDecoration.None,
                    color = if (goal.isDone) Color.Gray else MaterialTheme.colorScheme.onSurface
                ),
                modifier = Modifier.weight(1f)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GoalItemPreview() {
    GoalItem(
        goal = Goal(id = 1, title = "Test Goal"),
        onToggleDone = {})
}