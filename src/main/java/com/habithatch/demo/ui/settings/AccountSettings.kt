package com.habithatch.demo.ui.settings

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.habithatch.demo.R
import com.habithatch.demo.ui.common.forms.DeleteButton

/** A view that displays account settings */
@Suppress("ktlint:standard:function-naming", "FunctionNaming")
@Composable
fun AccountSettings(
    modifier: Modifier = Modifier,
    onOpenDeleteAccountDialog: () -> Unit = {},
) {
    Column(modifier = modifier) {
        SettingsGroup(
            titleRes = R.string.account_settings,
            hasTopDivider = false,
        ) {
            ListItem(
                headlineContent = { Text(stringResource(R.string.username)) },
                supportingContent = { Text(stringResource(R.string.user_example_email)) },
                leadingContent = {
                    Icon(
                        Icons.Default.Person,
                        contentDescription = stringResource(R.string.account_icon_description),
                    )
                },
            )
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center,
            ) {
                DeleteButton(
                    modifier = Modifier.padding(top = 8.dp),
                    textRes = R.string.delete_account_button,
                    onClick = onOpenDeleteAccountDialog,
                )
            }
        }
    }
}
