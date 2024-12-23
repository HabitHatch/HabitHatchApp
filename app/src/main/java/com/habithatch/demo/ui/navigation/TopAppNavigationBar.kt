package com.habithatch.demo.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.habithatch.demo.core.config.HabitHatchDevConfig
import com.habithatch.demo.core.navigation.NavigationItem

@OptIn(ExperimentalMaterial3Api::class)
@Suppress("ktlint:standard:function-naming")
@Composable
fun TopAppInformationBar(
    title: String,
    primaryNavigationItem: NavigationItem? = null,
    modifier: Modifier = Modifier,
    onPrimaryNavigationItemClick: () -> Unit = {},
) {
    CenterAlignedTopAppBar(
        colors =
            TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.tertiary,
                titleContentColor = MaterialTheme.colorScheme.onTertiary,
            ),
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
            )
        },
        actions = {
            if (primaryNavigationItem != null) {
                IconButton(
                    onClick = onPrimaryNavigationItemClick,
                    modifier =
                        Modifier
                            .size(44.dp),
                ) {
                    Icon(
                        painter = painterResource(primaryNavigationItem.iconResourceId),
                        contentDescription = primaryNavigationItem.screen.route,
                        tint = MaterialTheme.colorScheme.onTertiary,
                        modifier = Modifier.fillMaxSize().padding(8.dp),
                    )
                }
            }
        },
        modifier = modifier,
    )
}

@Preview()
@Suppress("ktlint:standard:function-naming")
@Composable
fun TopAppInformationBarPreview() {
    TopAppInformationBar(
        title = "Home",
        primaryNavigationItem = HabitHatchDevConfig.primaryNavigationItem,
        onPrimaryNavigationItemClick = {},
    )
}
