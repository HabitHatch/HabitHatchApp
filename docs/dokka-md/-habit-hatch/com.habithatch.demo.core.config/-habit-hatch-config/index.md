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
| [aiNavItem](ai-nav-item.md) | [app]<br>abstract val [aiNavItem](ai-nav-item.md): [Screen](../../com.habithatch.demo.core.navigation/-screen/index.md) |
| [bodyFontFamily](body-font-family.md) | [app]<br>abstract val [bodyFontFamily](body-font-family.md): [FontFamily](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/font/FontFamily.html) |
| [defaultGoalQuery](default-goal-query.md) | [app]<br>abstract val [defaultGoalQuery](default-goal-query.md): [GoalQuery](../../com.habithatch.demo.core.query/-goal-query/index.md) |
| [displayFontFamily](display-font-family.md) | [app]<br>abstract val [displayFontFamily](display-font-family.md): [FontFamily](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/font/FontFamily.html) |
| [exampleGoals](example-goals.md) | [app]<br>abstract val [exampleGoals](example-goals.md): [Collection](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-collection/index.html)&lt;[GoalModel](../../com.habithatch.demo.data.models/-goal-model/index.md)&gt; |
| [homeNavigationItem](home-navigation-item.md) | [app]<br>abstract val [homeNavigationItem](home-navigation-item.md): [Screen](../../com.habithatch.demo.core.navigation/-screen/index.md) |
| [navigationItems](navigation-items.md) | [app]<br>abstract val [navigationItems](navigation-items.md): [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[Screen](../../com.habithatch.demo.core.navigation/-screen/index.md)&gt; |
| [pets](pets.md) | [app]<br>abstract val [pets](pets.md): [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[Pet](../../com.habithatch.demo.data.entities/-pet/index.md)&gt; |
| [settingsNavigationItem](settings-navigation-item.md) | [app]<br>abstract val [settingsNavigationItem](settings-navigation-item.md): [Screen](../../com.habithatch.demo.core.navigation/-screen/index.md) |
| [signUpNavigationItem](sign-up-navigation-item.md) | [app]<br>abstract val [signUpNavigationItem](sign-up-navigation-item.md): [Screen](../../com.habithatch.demo.core.navigation/-screen/index.md) |
| [topLeftNavItem](top-left-nav-item.md) | [app]<br>abstract val [topLeftNavItem](top-left-nav-item.md): [Screen](../../com.habithatch.demo.core.navigation/-screen/index.md) |
| [topRightNavItem](top-right-nav-item.md) | [app]<br>abstract val [topRightNavItem](top-right-nav-item.md): [Screen](../../com.habithatch.demo.core.navigation/-screen/index.md) |