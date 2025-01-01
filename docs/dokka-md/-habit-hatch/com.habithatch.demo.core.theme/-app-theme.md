//[HabitHatch](../../index.md)/[com.habithatch.demo.core.theme](index.md)/[AppTheme](-app-theme.md)

# AppTheme

[app]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [AppTheme](-app-theme.md)(typography: [Typography](https://developer.android.com/reference/kotlin/androidx/compose/material3/Typography.html), darkTheme: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = isSystemInDarkTheme(), content: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))

The [AppTheme](-app-theme.md) composable, which sets the color scheme and typography for the app. The Colors are dynamically set with Material You, depending one users wallpaper.