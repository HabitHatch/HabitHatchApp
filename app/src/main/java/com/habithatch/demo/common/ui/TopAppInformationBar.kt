package com.habithatch.demo.common.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
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
import com.habithatch.demo.core.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppInformationBar(
    title: String,
    primaryNavigationItem: NavigationItem? = null,
    onPrimaryNavigationItemClick: () -> Unit = {},
) {
    CenterAlignedTopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.tertiary,
                    titleContentColor = MaterialTheme.colorScheme.onTertiary,
            ),
            title = {
                Text(
                        text = title,
                        style = MaterialTheme.typography.titleMedium
                )
            },
            actions = {
                if (primaryNavigationItem != null) {
                    IconButton(
                            onClick = onPrimaryNavigationItemClick,
                            modifier = Modifier
                                .size(28.dp)
                                .padding(4.dp)

                    ) {
                        Icon(
                                painter = painterResource(primaryNavigationItem.iconResourceId),
                                contentDescription = primaryNavigationItem.screen.route,
                                tint = MaterialTheme.colorScheme.onTertiary,
                        )
                    }
                }
            },
            modifier = Modifier.height(60.dp)
    )
}

@Preview()
@Composable
fun TopAppInformationBarPreview() {
    val primaryNavigationItem = HabitHatchDevConfig.accountItem
    TopAppInformationBar(
            title = "Home",
            primaryNavigationItem = primaryNavigationItem,
            onPrimaryNavigationItemClick = {}
    )

}