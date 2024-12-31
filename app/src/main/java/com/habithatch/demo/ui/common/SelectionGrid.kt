package com.habithatch.demo.ui.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.habithatch.demo.R


/**
 * A grid of elements that can be selected.
 */
@Suppress("ktlint:standard:function-naming", "FunctionNaming")
@Composable
fun <T> SelectionGrid(
    elements: List<T>,
    columns: Int = 2,
    outSidePadding: Dp = 50.dp,
    spaceBetween: Dp = 30.dp,
    onConfirm: (T) -> Unit,
    card: @Composable (T, Boolean, () -> Unit) -> Unit,
) {
    var currentElement by remember { mutableStateOf<T?>(null) }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(columns),
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(outSidePadding),
            horizontalArrangement = Arrangement.spacedBy(spaceBetween),
            verticalArrangement = Arrangement.spacedBy(spaceBetween),
        ) {
            elements.forEach { pet ->
                item {
                    card(pet, currentElement == pet, { currentElement = if (currentElement == pet) null else pet })
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { currentElement?.let { onConfirm(it) } },
            enabled = currentElement != null,
        ) {
            Text(text = stringResource(R.string.confirm_selection))
        }
    }
}
