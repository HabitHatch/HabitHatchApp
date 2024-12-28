package com.habithatch.demo.ui.navigation

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.habithatch.demo.core.navigation.Screen

@Suppress("ktlint:standard:function-naming")
@Composable
fun NavItem(
    modifier: Modifier = Modifier.size(24.dp),
    navScreen: Screen,
    isActive: Boolean,
    iconColor: Color,
    onNavigationItemClicked: () -> Unit,
) {
    IconButton(
        onClick = {
            if (navScreen.enabled && !isActive) {
                onNavigationItemClicked()
            }
        },
        modifier = modifier,
        enabled = navScreen.enabled,
    ) {
        Icon(
            painter = painterResource(navScreen.iconResourceId),
            contentDescription = navScreen.route,
            tint = iconColor,
        )
    }
}
