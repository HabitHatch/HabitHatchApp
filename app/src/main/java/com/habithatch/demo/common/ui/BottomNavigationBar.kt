import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.habithatch.demo.core.navigation.NavigationItem

@Composable
fun BottomNavigationBar(
    onItemSelected: (NavigationItem) -> Unit,
    selectedItem: NavigationItem,
    navigationItems: List<NavigationItem>
) {
    BottomAppBar(
            modifier = Modifier.fillMaxWidth(),
            containerColor = MaterialTheme.colorScheme.primary
    ) {
        navigationItems.forEach { item ->
            IconButton(
                    onClick = { if (item.enabled) onItemSelected(item) },
                    modifier = Modifier.weight(1f),
                    enabled = item.enabled
            ) {
                Icon(
                        imageVector = item.icon,
                        contentDescription = item.screen.route,
                        tint =
                        if (item == selectedItem) MaterialTheme.colorScheme.onPrimary
                        else if (item.enabled) Color.Gray
                        else Color.LightGray,
                        modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}