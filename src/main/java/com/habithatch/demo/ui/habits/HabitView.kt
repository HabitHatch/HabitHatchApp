package com.habithatch.demo.ui.habits

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.habithatch.demo.ui.habits.item.HabitItem
import com.habithatch.demo.R

/**
 * A view that displays a list of habits.
 */
@Suppress("ktlint:standard:function-naming", "FunctionNaming")
@Composable
fun HabitsView(
    state: HabitsViewState,
    contentPadding: PaddingValues = PaddingValues(4.dp),
    verticalArrangement: Arrangement.Vertical = Arrangement.spacedBy(8.dp),
) {
    if (state.showCreateExampleHabits) {
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            Text(
                text = stringResource(id = R.string.no_habits_explanation),
                modifier =
                    Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(32.dp),
            )
            Button(
                onClick = state.onCreateExampleHabits,
                modifier = Modifier.align(Alignment.CenterHorizontally).padding(vertical = 32.dp),
            ) {
                Text(stringResource(id = R.string.example_habits_button))
            }
        }
    }
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = contentPadding,
        verticalArrangement = verticalArrangement,
    ) {
        state.habits.forEach { habit ->
            item {
                HabitItem(
                    habit = habit,
                    onCycleHabitStatus = { state.onToggleHabitStatus(habit) },
                )
            }
        }
    }
}
