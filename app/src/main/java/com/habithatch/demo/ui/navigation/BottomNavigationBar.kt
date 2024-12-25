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
import com.habithatch.demo.core.navigation.Screen

@Suppress("ktlint:standard:function-naming")
@Composable
fun BottomNavigationBar(
    navigationItems: List<Screen>,
    activeNavigationItem: Screen?,
    onNavigationItemClicked: (Screen) -> Unit,
) {
    @Suppress("ktlint:standard:function-naming")
    @Composable
    fun colorForItem(item: Screen): Color =
        if (item == activeNavigationItem) {
            MaterialTheme.colorScheme.primary
        } else if (item.enabled) {
            MaterialTheme.colorScheme.secondary
        } else {
            MaterialTheme.colorScheme.tertiary
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
                    modifier =
                        Modifier
                            .weight(1f)
                            .size(24.dp),
                    enabled = item.enabled,
                ) {
                    Icon(
                        painter = painterResource(item.iconResourceId),
                        contentDescription = item.screen.route,
                        tint = colorForItem(item),
                    )
                }
            }
        },
    )
}

@Preview()
@Suppress("ktlint:standard:function-naming")
@Composable
fun BottomNavigationBarPreview() {
    val navigationItems = HabitHatchDevConfig.navigationItems

    val homeItem =
        Screen.findNavigationItemByRoute(
            route = Screen.HOME.route,
            navigationItems = navigationItems,
        )

    if (homeItem == null) {
        return
    }

    BottomNavigationBar(
        onNavigationItemClicked = {},
        activeNavigationItem = homeItem,
        navigationItems = navigationItems,
    )
}
