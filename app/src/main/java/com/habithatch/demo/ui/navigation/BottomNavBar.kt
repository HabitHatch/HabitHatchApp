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
import com.habithatch.demo.core.app.AppModule
import com.habithatch.demo.core.config.HabitHatchDevConfig
import com.habithatch.demo.core.navigation.Screen

@Suppress("ktlint:standard:function-naming","FunctionNaming")
@Composable
fun BottomNavBar(
    navigationItems: List<Screen>,
    activeNavigationItem: Screen?,
    onNavigationItemClicked: (Screen) -> Unit,
) {
    @Suppress("ktlint:standard:function-naming","FunctionNaming")
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
                    modifier = Modifier.size(24.dp).weight(1f),
                    enabled = item.enabled,
                ) {
                    Icon(
                        painter = painterResource(item.iconResourceId),
                        contentDescription = item.route,
                        tint = colorForItem(item),
                    )
                }
            }
        },
    )
}

@Preview()
@Suppress("ktlint:standard:function-naming","FunctionNaming")
@Composable
fun BottomNavigationBarPreview() {
    val config = HabitHatchDevConfig(AppModule.provideGoogleFontProvider())
    val navigationItems = config.navigationItems

    val homeItem =
        config.homeNavigationItem

    BottomNavBar(
        onNavigationItemClicked = {},
        activeNavigationItem = homeItem,
        navigationItems = navigationItems,
    )
}
