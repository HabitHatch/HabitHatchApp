package com.habithatch.demo.ui.goals.table

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.habithatch.demo.R
import com.habithatch.demo.core.theme.success
import com.habithatch.demo.ui.common.forms.SearchField
import com.habithatch.demo.ui.common.forms.SimpleIconButton
import com.habithatch.demo.ui.goals.GoalFilterState

@Composable
fun getDoneColor(isDoneStatusVisible: Boolean): Color =
    if (isDoneStatusVisible) {
        MaterialTheme.colorScheme.success
    } else {
        MaterialTheme.colorScheme.outline
    }

@Suppress("ktlint:standard:function-naming", "FunctionNaming")
@Composable
fun GoalFilterBar(
    state: GoalFilterState,
    modifier: Modifier = Modifier,
) {
    val goalFilter = state.goalFilterBuilder.build()
    val searchQuery = goalFilter.searchQuery.orEmpty()
    val isDoneVisible = state.goalFilterBuilder.build().isDoneVisible()
    val doneIconColor = getDoneColor(isDoneVisible)
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
    ) {
        SearchField(
            modifier =
                Modifier
                    .align(Alignment.CenterVertically)
                    .heightIn(max = 34.dp)
                    .weight(1f),
            searchQuery = searchQuery,
            onQueryChange = {
                state.onGoalFilterChange(state.goalFilterBuilder.setSearchQuery(it).build())
            },
        )

        SimpleIconButton(
            modifier = modifier,
            labelRes = R.string.status_toggle_label,
            color = doneIconColor,
            painter = painterResource(R.drawable.vuesax_tick_circle),
            onClick = {
                state.onGoalFilterChange(
                    state.goalFilterBuilder
                        .setDoneStatusVisibility(!isDoneVisible)
                        .build(),
                )
            },
        )
    }
}
