package com.habithatch.demo.ui.navigation

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.habithatch.demo.R
import com.habithatch.demo.core.navigation.Screen

/**
 * A top navigation bar that displays the title and navigation items.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Suppress("ktlint:standard:function-naming", "FunctionNaming", "LongParameterList")
@Composable
fun TopNavBar(
    title: String,
    rightNavItem: Screen? = null,
    leftNavItem: Screen? = null,
    modifier: Modifier = Modifier,
    onRightNavItemClicked: () -> Unit = {},
    onLeftNavItemClicked: () -> Unit = {},
) {
    val navBarColor = MaterialTheme.colorScheme.surface

    CenterAlignedTopAppBar(
        modifier = modifier,
        expandedHeight = 50.dp,
        colors =
            TopAppBarDefaults.topAppBarColors(
                containerColor = navBarColor,
                titleContentColor = MaterialTheme.colorScheme.contentColorFor(navBarColor),
            ),
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge.copy
                    (fontWeight = FontWeight.Bold)
            )
        },
        navigationIcon = {
            leftNavItem?.let {
                NavItem(
                    navScreen = leftNavItem,
                    iconColor = MaterialTheme.colorScheme.onSurface,
                    onClick = onLeftNavItemClicked,
                )
            }
        },
        actions = {
            rightNavItem?.let {
                NavItem(
                    navScreen = rightNavItem,
                    iconColor = MaterialTheme.colorScheme.onSurface,
                    onClick = onRightNavItemClicked,
                )
            }
        },
    )
}

@Preview()
@Suppress("ktlint:standard:function-naming", "FunctionNaming")
@Composable
fun TopAppInformationBarPreview() {
    TopNavBar(
        title = "Home",
        rightNavItem = Screen("settings", R.drawable.vuesax_profile_circle),
    )
}
