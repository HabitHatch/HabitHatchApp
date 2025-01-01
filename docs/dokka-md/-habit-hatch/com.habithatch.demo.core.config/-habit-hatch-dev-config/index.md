//[HabitHatch](../../../index.md)/[com.habithatch.demo.core.config](../index.md)/[HabitHatchDevConfig](index.md)

# HabitHatchDevConfig

[app]\
class [HabitHatchDevConfig](index.md)@Injectconstructor(googleFontProvider: [GoogleFont.Provider](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/googlefonts/GoogleFont.Provider.html), goalModelFactory: [GoalModel.Factory](../../com.habithatch.demo.data.models/-goal-model/-factory/index.md)) : [HabitHatchConfig](../-habit-hatch-config/index.md)

The main application configuration for the development environment.

## Constructors

| | |
|---|---|
| [HabitHatchDevConfig](-habit-hatch-dev-config.md) | [app]<br>@Inject<br>constructor(googleFontProvider: [GoogleFont.Provider](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/googlefonts/GoogleFont.Provider.html), goalModelFactory: [GoalModel.Factory](../../com.habithatch.demo.data.models/-goal-model/-factory/index.md)) |

## Properties

| Name | Summary |
|---|---|
| [aiNavItem](ai-nav-item.md) | [app]<br>open override val [aiNavItem](ai-nav-item.md): [Screen](../../com.habithatch.demo.core.navigation/-screen/index.md) |
| [bodyFontFamily](body-font-family.md) | [app]<br>open override val [bodyFontFamily](body-font-family.md): [FontFamily](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/font/FontFamily.html) |
| [defaultGoalQuery](default-goal-query.md) | [app]<br>open override var [defaultGoalQuery](default-goal-query.md): [GoalQuery](../../com.habithatch.demo.core.query/-goal-query/index.md) |
| [defaultPriority](default-priority.md) | [app]<br>open override val [defaultPriority](default-priority.md): [GoalModel.Priority](../../com.habithatch.demo.data.models/-goal-model/-priority/index.md) |
| [defaultStatus](default-status.md) | [app]<br>open override val [defaultStatus](default-status.md): [GoalModel.Status](../../com.habithatch.demo.data.models/-goal-model/-status/index.md) |
| [displayFontFamily](display-font-family.md) | [app]<br>open override val [displayFontFamily](display-font-family.md): [FontFamily](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/font/FontFamily.html) |
| [exampleGoals](example-goals.md) | [app]<br>open override val [exampleGoals](example-goals.md): [Collection](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-collection/index.html)&lt;[GoalModel](../../com.habithatch.demo.data.models/-goal-model/index.md)&gt; |
| [homeNavigationItem](home-navigation-item.md) | [app]<br>open override val [homeNavigationItem](home-navigation-item.md): [Screen](../../com.habithatch.demo.core.navigation/-screen/index.md) |
| [navigationItems](navigation-items.md) | [app]<br>open override val [navigationItems](navigation-items.md): [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[Screen](../../com.habithatch.demo.core.navigation/-screen/index.md)&gt; |
| [numberExampleGoals](number-example-goals.md) | [app]<br>val [numberExampleGoals](number-example-goals.md): [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) = 12 |
| [pets](pets.md) | [app]<br>open override val [pets](pets.md): [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[Pet](../../com.habithatch.demo.data.entities/-pet/index.md)&gt; |
| [priorities](priorities.md) | [app]<br>open override val [priorities](priorities.md): [Set](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-set/index.html)&lt;[GoalModel.Priority](../../com.habithatch.demo.data.models/-goal-model/-priority/index.md)&gt; |
| [settingsNavigationItem](settings-navigation-item.md) | [app]<br>open override val [settingsNavigationItem](settings-navigation-item.md): [Screen](../../com.habithatch.demo.core.navigation/-screen/index.md) |
| [signUpNavigationItem](sign-up-navigation-item.md) | [app]<br>open override val [signUpNavigationItem](sign-up-navigation-item.md): [Screen](../../com.habithatch.demo.core.navigation/-screen/index.md) |
| [statuses](statuses.md) | [app]<br>open override val [statuses](statuses.md): [Set](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-set/index.html)&lt;[GoalModel.Status](../../com.habithatch.demo.data.models/-goal-model/-status/index.md)&gt; |
| [topLeftNavItem](top-left-nav-item.md) | [app]<br>open override val [topLeftNavItem](top-left-nav-item.md): [Screen](../../com.habithatch.demo.core.navigation/-screen/index.md) |
| [topRightNavItem](top-right-nav-item.md) | [app]<br>open override val [topRightNavItem](top-right-nav-item.md): [Screen](../../com.habithatch.demo.core.navigation/-screen/index.md) |