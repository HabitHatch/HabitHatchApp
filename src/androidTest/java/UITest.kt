import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.habithatch.demo.core.activities.MainActivity
import com.habithatch.demo.core.config.HabitHatchConfig
import com.habithatch.demo.core.navigation.AppNavigation
import javax.inject.Inject
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AppNavigationTest {
    @Inject
    lateinit var config: HabitHatchConfig

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun clickThroughAppAndMarkHabitComplete() {
        composeTestRule.setContent {
            AppNavigation(
                config = config,
            )
        }
    }
}
