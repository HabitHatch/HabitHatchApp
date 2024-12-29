package com.habithatch.demo.ui.goals.table

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.habithatch.demo.core.query.GoalFilter
import com.habithatch.demo.core.theme.success
import com.habithatch.demo.ui.common.forms.IconToggle
import com.habithatch.demo.ui.common.forms.SearchField

@Suppress("ktlint:standard:function-naming", "FunctionNaming")
@Composable
fun GoalFilterBar(
    modifier: Modifier = Modifier,
    goalFilterBuilder: GoalFilter.Builder,
    onGoalFilterChange: (GoalFilter) -> Unit,
) {
    val goalFilter = goalFilterBuilder.build()
    val searchQuery = goalFilter.searchQuery.orEmpty()
    val isDoneStatusVisible = goalFilter.isDoneVisible()
    val doneIconColor =
        if (isDoneStatusVisible) {
            MaterialTheme.colorScheme.success
        } else {
            MaterialTheme.colorScheme.outline
        }
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
                val newGoalFilter = goalFilterBuilder.setSearchQuery(it).build()
                onGoalFilterChange(newGoalFilter)
            },
        )
        IconToggle(
            modifier = Modifier.fillMaxHeight().width(48.dp),
            iconColor = doneIconColor,
            goalFilterBuilder = goalFilterBuilder,
            onGoalFilterChange = onGoalFilterChange,
        )
    }
}
