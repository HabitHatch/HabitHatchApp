import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.habithatch.demo.core.config.HabitHatchDevConfig
import com.habithatch.demo.core.navigation.NavigationItem
import com.habithatch.demo.core.navigation.Screen

@Composable
fun BottomNavigationBar(
    navigationItems: List<NavigationItem>,
    activeNavigationItem: NavigationItem?,
    onNavigationItemClicked: (NavigationItem) -> Unit
) {
    @Composable
    fun colorForItem(item: NavigationItem): Color {
        return if (item == activeNavigationItem) {
            MaterialTheme.colorScheme.primary
        } else if (item.enabled) {
            MaterialTheme.colorScheme.secondary
        } else {
            MaterialTheme.colorScheme.secondary
        }
    }

    BottomAppBar(
            modifier = Modifier.fillMaxWidth().height(64.dp),
            actions = {
                navigationItems.forEach { item ->
                    IconButton(
                            onClick = {
                                if (item.enabled && item != activeNavigationItem) {
                                    onNavigationItemClicked(item)
                                }
                            },
                            modifier = Modifier
                                .weight(1f)
                                .size(24.dp),
                            enabled = item.enabled
                    ) {
                        Icon(
                                painter = painterResource(item.iconResourceId),
                                contentDescription = item.screen.route,
                                tint = colorForItem(item),
                        )
                    }
                }
            }
    )
}

@Preview()
@Composable
fun BottomNavigationBarPreview() {
    val navigationItems = HabitHatchDevConfig.navigationItems

    val homeItem = NavigationItem.findNavigationItemByRoute(
            route = Screen.HOME.route,
            navigationItems = navigationItems
    )

    if (homeItem == null) {
        return
    }

    BottomNavigationBar(
            onNavigationItemClicked = {},
            activeNavigationItem = homeItem,
            navigationItems = navigationItems
    )
}