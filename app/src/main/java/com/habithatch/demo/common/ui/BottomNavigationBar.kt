import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.habithatch.demo.core.config.HabitHatchDevConfig
import com.habithatch.demo.core.navigation.NavigationItem
import com.habithatch.demo.core.navigation.Screen

@Composable
fun BottomNavigationBar(
    onItemSelected: (NavigationItem) -> Unit,
    selectedItem: NavigationItem,
    navigationItems: List<NavigationItem>
) {
    BottomAppBar(
            modifier = Modifier.fillMaxWidth(),
            actions = {
                navigationItems.forEach { item ->
                    IconButton(
                            onClick = { if (item.enabled) onItemSelected(item) },
                            modifier = Modifier
                                .weight(1f)
                                .size(24.dp),
                            enabled = item.enabled
                    ) {
                        Icon(
                                painter = painterResource(item.iconResourceId),
                                contentDescription = item.screen.route,
                                tint =
                                if (item == selectedItem) MaterialTheme.colorScheme.primary
                                else if (item.enabled) MaterialTheme.colorScheme.secondary
                                else MaterialTheme.colorScheme.tertiary,
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

    val homeItem = navigationItems.filter {
        it.screen == Screen.Home
    }.firstOrNull()

    if (homeItem == null) {
        return
    }

    BottomNavigationBar(
            onItemSelected = {},
            selectedItem = homeItem,
            navigationItems = navigationItems
    )
}