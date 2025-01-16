package com.habithatch.demo.ui.habits.item

import androidx.compose.foundation.border
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
import com.habithatch.demo.data.models.HabitModel
import com.habithatch.demo.ui.habits.HabitStyleProvider

/**
 * A card that displays a habit.
 */
@Suppress("ktlint:standard:function-naming", "FunctionNaming")
@Composable
fun HabitItem(
    habit: HabitModel,
    rowPadding: PaddingValues = PaddingValues(12.dp),
    checkBoxPadding: PaddingValues = PaddingValues(end = 8.dp),
    onCycleHabitStatus: () -> Unit = {},
) {
    val habitStyle = HabitStyleProvider.getHabitStyle(habit)
    Card(
        modifier =
            Modifier
                .fillMaxWidth(),
        colors = habitStyle.cardColors,
        shape = habitStyle.cardShape,
    ) {
        Row(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(rowPadding),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Checkbox(
                checked = habit.isDone(),
                onCheckedChange = { onCycleHabitStatus() },
                modifier = Modifier.padding(checkBoxPadding),
            )

            Text(
                text = habit.title,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                style = habitStyle.textStyle,
                modifier = Modifier.weight(1f),
            )
            Icon(
                modifier = Modifier.weight(0.25f),
                painter = painterResource(habit.priority.iconResourceId),
                contentDescription = habit.priority.label,
                tint = habitStyle.iconColor,
            )
        }
    }
}
