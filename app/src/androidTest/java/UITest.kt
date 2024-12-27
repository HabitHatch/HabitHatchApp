
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.captureToImage
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.dropbox.dropshots.Dropshots
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.io.File

@RunWith(AndroidJUnit4::class)
class HomeScreenScreenshotTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @get:Rule
    val dropshots = Dropshots()

    @Test
    fun captureHomeScreenWithDynamicColors() {
        composeTestRule.setContent {
            AppTheme(darkTheme = true) {
                HomeScreenPreview()
            }
        }

        val bitmap = composeTestRule.onRoot().captureToImage()
        dropshots.assertSnapshot(bitmap, "home_screen_dynamic_colors")
    }
}
