//[HabitHatch](../../../index.md)/[com.habithatch.demo.core.config](../index.md)/[HabitHatchDevConfig](index.md)

# HabitHatchDevConfig

[app]\
class [HabitHatchDevConfig](index.md)@Injectconstructor(googleFontProvider: [GoogleFont.Provider](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/googlefonts/GoogleFont.Provider.html), petMoodAnimationsBuilder: [PetMoodAnimationsFactory](../../com.habithatch.demo.data.entities/-pet-mood-animations-factory/index.md)) : [HabitHatchConfig](../-habit-hatch-config/index.md)

The main application configuration for the development environment.

## Constructors

| | |
|---|---|
| [HabitHatchDevConfig](-habit-hatch-dev-config.md) | [app]<br>@Inject<br>constructor(googleFontProvider: [GoogleFont.Provider](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/googlefonts/GoogleFont.Provider.html), petMoodAnimationsBuilder: [PetMoodAnimationsFactory](../../com.habithatch.demo.data.entities/-pet-mood-animations-factory/index.md)) |

## Properties

| Name | Summary |
|---|---|
| [bodyFontFamily](body-font-family.md) | [app]<br>open override val [bodyFontFamily](body-font-family.md): [FontFamily](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/font/FontFamily.html) |
| [catAnimation](cat-animation.md) | [app]<br>val [catAnimation](cat-animation.md): [PetMoodAnimations](../../com.habithatch.demo.data.entities/-pet-mood-animations/index.md) |
| [defaultHabitQuery](default-habit-query.md) | [app]<br>open override var [defaultHabitQuery](default-habit-query.md): [HabitQuery](../../com.habithatch.demo.core.query/-habit-query/index.md) |
| [defaultPriority](default-priority.md) | [app]<br>open override val [defaultPriority](default-priority.md): [HabitModel.Priority](../../com.habithatch.demo.data.models/-habit-model/-priority/index.md) |
| [defaultStatus](default-status.md) | [app]<br>open override val [defaultStatus](default-status.md): [HabitModel.Status](../../com.habithatch.demo.data.models/-habit-model/-status/index.md) |
| [displayFontFamily](display-font-family.md) | [app]<br>open override val [displayFontFamily](display-font-family.md): [FontFamily](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/font/FontFamily.html) |
| [happyCatAnimation](happy-cat-animation.md) | [app]<br>val [happyCatAnimation](happy-cat-animation.md): [FrameStateAnimation](../../com.habithatch.demo.core.animation/-frame-state-animation/index.md) |
| [homeNavItem](home-nav-item.md) | [app]<br>open override val [homeNavItem](home-nav-item.md): [Screen](../../com.habithatch.demo.core.navigation/-screen/index.md) |
| [navItems](nav-items.md) | [app]<br>open override val [navItems](nav-items.md): [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[Screen](../../com.habithatch.demo.core.navigation/-screen/index.md)&gt; |
| [numberExampleHabits](number-example-habits.md) | [app]<br>open override val [numberExampleHabits](number-example-habits.md): [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) = 12 |
| [pets](pets.md) | [app]<br>open override val [pets](pets.md): [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[Pet](../../com.habithatch.demo.data.entities/-pet/index.md)&gt; |
| [priorities](priorities.md) | [app]<br>open override val [priorities](priorities.md): [Set](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-set/index.html)&lt;[HabitModel.Priority](../../com.habithatch.demo.data.models/-habit-model/-priority/index.md)&gt; |
| [sadCatAnimation](sad-cat-animation.md) | [app]<br>val [sadCatAnimation](sad-cat-animation.md): [FrameStateAnimation](../../com.habithatch.demo.core.animation/-frame-state-animation/index.md) |
| [settingsNavigationItem](settings-navigation-item.md) | [app]<br>open override val [settingsNavigationItem](settings-navigation-item.md): [Screen](../../com.habithatch.demo.core.navigation/-screen/index.md) |
| [signUpNavItem](sign-up-nav-item.md) | [app]<br>open override val [signUpNavItem](sign-up-nav-item.md): [Screen](../../com.habithatch.demo.core.navigation/-screen/index.md) |
| [statuses](statuses.md) | [app]<br>open override val [statuses](statuses.md): [Set](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-set/index.html)&lt;[HabitModel.Status](../../com.habithatch.demo.data.models/-habit-model/-status/index.md)&gt; |
| [topRightNavItem](top-right-nav-item.md) | [app]<br>open override val [topRightNavItem](top-right-nav-item.md): [Screen](../../com.habithatch.demo.core.navigation/-screen/index.md) |