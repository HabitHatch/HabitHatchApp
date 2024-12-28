package com.habithatch.demo.ui.navigation

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.habithatch.demo.core.app.AppModule
import com.habithatch.demo.core.config.HabitHatchDevConfig
import com.habithatch.demo.core.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Suppress("ktlint:standard:function-naming", "FunctionNaming", "LongParameterList")
@Composable
fun TopNavBar(
    title: String,
    rightNavItem: Screen? = null,
    leftNavItem: Screen? = null,
    modifier: Modifier = Modifier,
    iconButtonModifier: Modifier = Modifier.fillMaxHeight().width(60.dp),
    iconModifier: Modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp),
    onRightNavItemClicked: () -> Unit = {},
    onLeftNavItemClicked: () -> Unit = {},
) {
    val navBarColor = MaterialTheme.colorScheme.tertiary

    CenterAlignedTopAppBar(
        modifier = modifier,
        expandedHeight = 44.dp,
        colors =
            TopAppBarDefaults.topAppBarColors(
                containerColor = navBarColor,
                titleContentColor = MaterialTheme.colorScheme.contentColorFor(navBarColor),
            ),
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
            )
        },
        navigationIcon = {
            if (leftNavItem == null) return@CenterAlignedTopAppBar

            NavItem(
                navScreen = leftNavItem,
                isActive = false,
                iconColor = MaterialTheme.colorScheme.onTertiary,
                onNavigationItemClicked = onLeftNavItemClicked,
            )
        },
        actions = {
            if (rightNavItem == null) return@CenterAlignedTopAppBar

            NavItem(
                navScreen = rightNavItem,
                isActive = false,
                iconColor = MaterialTheme.colorScheme.onTertiary,
                onNavigationItemClicked = onRightNavItemClicked,
            )
        },
    )
}

@Preview()
@Suppress("ktlint:standard:function-naming", "FunctionNaming")
@Composable
fun TopAppInformationBarPreview() {
    TopNavBar(
        title = "Home",
        rightNavItem = HabitHatchDevConfig(AppModule.provideGoogleFontProvider()).topRightNavItem,
        onRightNavItemClicked = {},
    )
}
