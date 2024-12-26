package com.habithatch.demo.ui.navigation

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import com.habithatch.demo.core.app.AppModule
import com.habithatch.demo.core.config.HabitHatchDevConfig
import com.habithatch.demo.core.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Suppress("ktlint:standard:function-naming")
@Composable
fun TopNavBar(
    title: String,
    primaryNavigationItem: Screen? = null,
    modifier: Modifier = Modifier,
    iconButtonModifier: Modifier = Modifier.fillMaxHeight().width(60.dp),
    iconModifier: Modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp),
    onPrimaryNavigationItemClick: () -> Unit = {},
) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        expandedHeight = 44.dp,
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
                    modifier = iconButtonModifier,
                ) {
                    Icon(
                        painter = painterResource(primaryNavigationItem.iconResourceId),
                        contentDescription = primaryNavigationItem.route,
                        tint = MaterialTheme.colorScheme.onTertiary,
                        modifier = iconModifier,
                    )
                }
            }
        },
    )
}

@Preview()
@Suppress("ktlint:standard:function-naming")
@Composable
fun TopAppInformationBarPreview() {
    TopNavBar(
        title = "Home",
        primaryNavigationItem = HabitHatchDevConfig(AppModule.provideGoogleFontProvider()).primaryNavigationItem,
        onPrimaryNavigationItemClick = {},
    )
}
