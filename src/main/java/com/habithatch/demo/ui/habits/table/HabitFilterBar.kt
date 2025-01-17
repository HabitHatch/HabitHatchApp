package com.habithatch.demo.ui.habits.table

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
import com.habithatch.demo.ui.habits.HabitFilterState

@Composable
fun getDoneColor(isDoneStatusVisible: Boolean): Color =
    if (isDoneStatusVisible) {
        MaterialTheme.colorScheme.success
    } else {
        MaterialTheme.colorScheme.outline
    }

/**
 * A bar that contains a search field and a button to toggle the visibility of done habits.
 */
@Suppress("ktlint:standard:function-naming", "FunctionNaming")
@Composable
fun HabitFilterBar(
    state: HabitFilterState,
    modifier: Modifier = Modifier,
) {
    val habitFilter = state.habitFilterBuilder.build()
    val searchQuery = habitFilter.searchQuery.orEmpty()
    val isDoneVisible = state.habitFilterBuilder.build().isDoneVisible()
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
                    .heightIn(max = 38.dp)
                    .widthIn(max = 120.dp)
                    .weight(1f),
            searchQuery = searchQuery,
            onQueryChange = {
                state.onHabitFilterChange(state.habitFilterBuilder.setSearchQuery(it))
            },
        )

        SimpleIconButton(
            labelRes = R.string.status_toggle_label,
            color = doneIconColor,
            painter = painterResource(R.drawable.vuesax_tick_circle),
            onClick = {
                state.onHabitFilterChange(
                    state.habitFilterBuilder
                        .setDoneStatusVisibility(!isDoneVisible),
                )
            },
        )
    }
}
