//[HabitHatch](../../../index.md)/[com.habithatch.demo.core.config](../index.md)/[HabitHatchDevConfig](index.md)

# HabitHatchDevConfig

[app]\
class [HabitHatchDevConfig](index.md)@Injectconstructor(googleFontProvider: [GoogleFont.Provider](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/googlefonts/GoogleFont.Provider.html), habitModelFactory: [HabitModel.Factory](../../com.habithatch.demo.data.models/-habit-model/-factory/index.md)) : [HabitHatchConfig](../-habit-hatch-config/index.md)

The main application configuration for the development environment.

## Constructors

| | |
|---|---|
| [HabitHatchDevConfig](-habit-hatch-dev-config.md) | [app]<br>@Inject<br>constructor(googleFontProvider: [GoogleFont.Provider](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/googlefonts/GoogleFont.Provider.html), habitModelFactory: [HabitModel.Factory](../../com.habithatch.demo.data.models/-habit-model/-factory/index.md)) |

## Properties

| Name | Summary |
|---|---|
| [aiNavItem](ai-nav-item.md) | [app]<br>open override val [aiNavItem](ai-nav-item.md): [Screen](../../com.habithatch.demo.core.navigation/-screen/index.md) |
| [bodyFontFamily](body-font-family.md) | [app]<br>open override val [bodyFontFamily](body-font-family.md): [FontFamily](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/font/FontFamily.html) |
| [defaultHabitQuery](default-habit-query.md) | [app]<br>open override var [defaultHabitQuery](default-habit-query.md): [HabitQuery](../../com.habithatch.demo.core.query/-habit-query/index.md) |
| [defaultPriority](default-priority.md) | [app]<br>open override val [defaultPriority](default-priority.md): [HabitModel.Priority](../../com.habithatch.demo.data.models/-habit-model/-priority/index.md) |
| [defaultStatus](default-status.md) | [app]<br>open override val [defaultStatus](default-status.md): [HabitModel.Status](../../com.habithatch.demo.data.models/-habit-model/-status/index.md) |
| [displayFontFamily](display-font-family.md) | [app]<br>open override val [displayFontFamily](display-font-family.md): [FontFamily](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/font/FontFamily.html) |
| [exampleHabits](example-habits.md) | [app]<br>open override val [exampleHabits](example-habits.md): [Collection](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-collection/index.html)&lt;[HabitModel](../../com.habithatch.demo.data.models/-habit-model/index.md)&gt; |
| [homeNavigationItem](home-navigation-item.md) | [app]<br>open override val [homeNavigationItem](home-navigation-item.md): [Screen](../../com.habithatch.demo.core.navigation/-screen/index.md) |
| [navigationItems](navigation-items.md) | [app]<br>open override val [navigationItems](navigation-items.md): [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[Screen](../../com.habithatch.demo.core.navigation/-screen/index.md)&gt; |
| [numberExampleHabits](number-example-habits.md) | [app]<br>val [numberExampleHabits](number-example-habits.md): [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) = 12 |
| [pets](pets.md) | [app]<br>open override val [pets](pets.md): [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[Pet](../../com.habithatch.demo.data.entities/-pet/index.md)&gt; |
| [priorities](priorities.md) | [app]<br>open override val [priorities](priorities.md): [Set](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-set/index.html)&lt;[HabitModel.Priority](../../com.habithatch.demo.data.models/-habit-model/-priority/index.md)&gt; |
| [settingsNavigationItem](settings-navigation-item.md) | [app]<br>open override val [settingsNavigationItem](settings-navigation-item.md): [Screen](../../com.habithatch.demo.core.navigation/-screen/index.md) |
| [signUpNavigationItem](sign-up-navigation-item.md) | [app]<br>open override val [signUpNavigationItem](sign-up-navigation-item.md): [Screen](../../com.habithatch.demo.core.navigation/-screen/index.md) |
| [statuses](statuses.md) | [app]<br>open override val [statuses](statuses.md): [Set](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-set/index.html)&lt;[HabitModel.Status](../../com.habithatch.demo.data.models/-habit-model/-status/index.md)&gt; |
| [topLeftNavItem](top-left-nav-item.md) | [app]<br>open override val [topLeftNavItem](top-left-nav-item.md): [Screen](../../com.habithatch.demo.core.navigation/-screen/index.md) |
| [topRightNavItem](top-right-nav-item.md) | [app]<br>open override val [topRightNavItem](top-right-nav-item.md): [Screen](../../com.habithatch.demo.core.navigation/-screen/index.md) |
