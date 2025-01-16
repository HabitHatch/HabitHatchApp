//[HabitHatch](../../../index.md)/[com.habithatch.demo.core.config](../index.md)/[HabitHatchConfig](index.md)

# HabitHatchConfig

interface [HabitHatchConfig](index.md) : [GoalStatusProvider](../-goal-status-provider/index.md), [GoalPriorityProvider](../-goal-priority-provider/index.md)

The main application configuration.

#### Inheritors

| |
|---|
| [HabitHatchDevConfig](../-habit-hatch-dev-config/index.md) |

## Properties

| Name | Summary |
|---|---|
| [bodyFontFamily](body-font-family.md) | [app]<br>abstract val [bodyFontFamily](body-font-family.md): [FontFamily](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/font/FontFamily.html) |
| [defaultGoalQuery](default-goal-query.md) | [app]<br>abstract val [defaultGoalQuery](default-goal-query.md): [GoalQuery](../../com.habithatch.demo.core.query/-goal-query/index.md) |
| [displayFontFamily](display-font-family.md) | [app]<br>abstract val [displayFontFamily](display-font-family.md): [FontFamily](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/font/FontFamily.html) |
| [homeNavItem](home-nav-item.md) | [app]<br>abstract val [homeNavItem](home-nav-item.md): [Screen](../../com.habithatch.demo.core.navigation/-screen/index.md) |
| [navItems](nav-items.md) | [app]<br>abstract val [navItems](nav-items.md): [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[Screen](../../com.habithatch.demo.core.navigation/-screen/index.md)&gt; |
| [numberExampleGoals](number-example-goals.md) | [app]<br>abstract val [numberExampleGoals](number-example-goals.md): [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) |
| [pets](pets.md) | [app]<br>abstract val [pets](pets.md): [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[Pet](../../com.habithatch.demo.data.entities/-pet/index.md)&gt; |
| [settingsNavigationItem](settings-navigation-item.md) | [app]<br>abstract val [settingsNavigationItem](settings-navigation-item.md): [Screen](../../com.habithatch.demo.core.navigation/-screen/index.md) |
| [signUpNavItem](sign-up-nav-item.md) | [app]<br>abstract val [signUpNavItem](sign-up-nav-item.md): [Screen](../../com.habithatch.demo.core.navigation/-screen/index.md) |
| [topRightNavItem](top-right-nav-item.md) | [app]<br>abstract val [topRightNavItem](top-right-nav-item.md): [Screen](../../com.habithatch.demo.core.navigation/-screen/index.md) |

## Functions

| Name | Summary |
|---|---|
| [getActiveNavItem](get-active-nav-item.md) | [app]<br>open fun [getActiveNavItem](get-active-nav-item.md)(navController: [NavController](https://developer.android.com/reference/kotlin/androidx/navigation/NavController.html)): [Screen](../../com.habithatch.demo.core.navigation/-screen/index.md) |
| [getPetById](get-pet-by-id.md) | [app]<br>open fun [getPetById](get-pet-by-id.md)(id: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)): [Pet](../../com.habithatch.demo.data.entities/-pet/index.md) |