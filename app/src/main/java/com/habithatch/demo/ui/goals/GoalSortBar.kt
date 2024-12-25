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
import com.habithatch.demo.core.query.GoalSortOption
import com.habithatch.demo.core.query.SortState

@Suppress("ktlint:standard:function-naming")
@Composable
fun GoalSortBar(
    sortOptions: List<GoalSortOption>,
    onSortOptionChange: (GoalSortOption) -> Unit,
) {
    val upIcon = R.drawable.vuesax_arrow_up_1
    val downIcon = R.drawable.vuesax_arrow_down_1
    val notSortedIcon = R.drawable.vuesax_sort

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        sortOptions.forEach { sortOption ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier =
                    Modifier
                        .clickable {
                            val newSortOption = sortOption.cycleState()
                            onSortOptionChange(newSortOption)
                        }.padding(8.dp),
            ) {
                Text(
                    text = sortOption.label,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(end = 8.dp),
                )
                Icon(
                    painter =
                        when (sortOption.sortState) {
                            SortState.ASCENDING -> painterResource(upIcon)
                            SortState.DESCENDING -> painterResource(downIcon)
                            SortState.NOT_USED -> painterResource(notSortedIcon)
                        },
                    contentDescription = sortOption.sortState.name,
                )
            }
        }
    }
}
