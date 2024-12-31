package com.habithatch.demo.ui.common.forms

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * A search field that allows the user to input a search query.
 *
 * @param searchQuery The current search query.
 * @param onQueryChange The callback to be called when the search query changes.
 * @param modifier The modifier to be applied to the search field.
 * @param shape The shape of the search field.
 * @param textStyle The text style of the search field.
 */
@Suppress("ktlint:standard:function-naming", "FunctionNaming")
@Composable
fun SearchField(
    searchQuery: String,
    onQueryChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    shape: CornerBasedShape = MaterialTheme.shapes.large,
    textStyle: TextStyle = MaterialTheme.typography.bodySmall,
) {
    Row(
        modifier =
            modifier
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.outline.copy(alpha = 0.2f),
                    shape = shape,
                ).padding(vertical = 4.dp, horizontal = 14.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = Icons.Default.Search.name,
            tint = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f),
            modifier = Modifier.fillMaxHeight(0.6f),
        )
        BasicTextField(
            value = searchQuery,
            onValueChange = onQueryChange,
            textStyle = textStyle,
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, top = 4.dp, bottom = 4.dp),
        )
    }
}

@Suppress("ktlint:standard:function-naming", "FunctionNaming")
@Preview(showBackground = true)
@Composable
fun SearchFieldPreview() {
    Column(
        modifier =
            Modifier
                .padding(vertical = 16.dp, horizontal = 32.dp)
                .height(48.dp),
    ) {
        SearchField(
            searchQuery = "Search Query",
            onQueryChange = {},
        )
    }
}
