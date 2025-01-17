package com.habithatch.demo.ui.settings

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Suppress("ktlint:standard:function-naming")
@Composable
fun SettingsGroup(
    @StringRes titleRes: Int,
    hasTopDivider: Boolean = true,
    content: @Composable () -> Unit,
) {
    if (hasTopDivider) {
        HorizontalDivider(
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f),
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp),
        )
    }
    Column(
        modifier = Modifier.padding(vertical = 8.dp),
    ) {
        Text(
            text = stringResource(titleRes),
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(4.dp),
        )
        content()
    }
}
