package com.habithatch.demo.ui.goals

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.habithatch.demo.R
import com.habithatch.demo.core.util.GoalSortOptionState
import com.habithatch.demo.core.util.SortState

@Composable
fun GoalSortBar(
    goalSortOptionStates: List<GoalSortOptionState>,
    sortOptionStateClicked: (GoalSortOptionState) -> Unit,
) {
    val upIcon = R.drawable.vuesax_arrow_up_1
    val downIcon = R.drawable.vuesax_arrow_down_1
    val notSortedIcon = R.drawable.vuesax_sort

    Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
    ) {
        goalSortOptionStates.forEach { goalSortOptionState ->
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                .clickable {
                    sortOptionStateClicked(goalSortOptionState)
                }
                .padding(8.dp)) {
                Text(
                        text = goalSortOptionState.sortOption.label,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(end = 8.dp)
                )
                Icon(
                        painter = when (goalSortOptionState.sortState) {
                            SortState.ASCENDING -> painterResource(upIcon)
                            SortState.DESCENDING -> painterResource(downIcon)
                            SortState.NOT_USED -> painterResource(notSortedIcon)
                        },
                        contentDescription = goalSortOptionState.sortState.name,
                )
            }
        }
    }
}