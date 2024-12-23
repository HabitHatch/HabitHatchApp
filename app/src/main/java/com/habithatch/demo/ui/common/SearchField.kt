package com.habithatch.demo.ui.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Suppress("ktlint:standard:function-naming")
@Composable
fun SearchField(
    searchQuery: String,
    onQueryChange: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.Companion.CenterVertically,
    ) {
        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = Icons.Default.Search.name,
            tint = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
            modifier = Modifier.padding(start = 12.dp),
        )
        Spacer(modifier = Modifier.width(8.dp))
        Box(
            contentAlignment = Alignment.Companion.CenterStart,
            modifier =
                Modifier
                    .fillMaxHeight()
                    .weight(1f),
        ) {
            BasicTextField(
                value = searchQuery,
                onValueChange = { onQueryChange(it) },
                textStyle =
                    MaterialTheme.typography.bodySmall.copy(
                        color = MaterialTheme.colorScheme.onSurface,
                    ),
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 4.dp),
            )
        }
    }
}
