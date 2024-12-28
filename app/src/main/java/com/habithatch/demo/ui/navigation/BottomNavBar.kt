import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.habithatch.demo.core.app.AppModule
import com.habithatch.demo.core.config.HabitHatchDevConfig
import com.habithatch.demo.core.navigation.Screen
import com.habithatch.demo.ui.navigation.NavItem

@Suppress("ktlint:standard:function-naming", "FunctionNaming")
@Composable
fun BottomNavBar(
    navigationItems: List<Screen>,
    activeNavScreen: Screen?,
    onNavigationItemClicked: (Screen) -> Unit,
) {
    @Suppress("ktlint:standard:function-naming", "FunctionNaming")
    @Composable
    fun colorForItem(item: Screen): Color =
        if (item == activeNavScreen) {
            MaterialTheme.colorScheme.primary
        } else if (item.enabled) {
            MaterialTheme.colorScheme.secondary
        } else {
            MaterialTheme.colorScheme.tertiary
        }

    BottomAppBar(
        modifier = Modifier.fillMaxWidth().height(64.dp),
        actions = {
            navigationItems.forEach { navScreen ->
                NavItem(
                    modifier = Modifier.size(24.dp).weight(1f),
                    navScreen = navScreen,
                    isActive = navScreen == activeNavScreen,
                    iconColor = colorForItem(navScreen),
                    onNavigationItemClicked = {
                        onNavigationItemClicked(navScreen)
                    },
                )
            }
        },
    )
}

@Preview()
@Suppress("ktlint:standard:function-naming", "FunctionNaming")
@Composable
fun BottomNavigationBarPreview() {
    val config = HabitHatchDevConfig(AppModule.provideGoogleFontProvider())
    val navigationItems = config.navigationItems

    val homeItem =
        config.homeNavigationItem

    BottomNavBar(
        onNavigationItemClicked = {},
        activeNavScreen = homeItem,
        navigationItems = navigationItems,
    )
}
