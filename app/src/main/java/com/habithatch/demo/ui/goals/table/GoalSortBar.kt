package com.habithatch.demo.ui.goals.table

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.habithatch.demo.core.query.GoalSortOption
import java.util.SortedSet

@Suppress("ktlint:standard:function-naming", "FunctionNaming")
@Composable
fun GoalSortBar(
    modifier: Modifier = Modifier,
    sortOptions: SortedSet<GoalSortOption>,
    onSortOptionChange: (GoalSortOption) -> Unit,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
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
                    modifier = Modifier.padding(end = 4.dp),
                )
                Icon(
                    painter = painterResource(id = sortOption.sortState.iconId),
                    contentDescription = sortOption.sortState.name,
                    modifier = Modifier.size(16.dp),
                )
            }
        }
    }
}
