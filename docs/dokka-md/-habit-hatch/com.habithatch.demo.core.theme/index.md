//[HabitHatch](../../index.md)/[com.habithatch.demo.core.theme](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [SchemeColor](-scheme-color/index.md) | [app]<br>@[Immutable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Immutable.html)<br>data class [SchemeColor](-scheme-color/index.md)(lightColor: [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html), darkColor: [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html))<br>A color scheme that provides a light and dark color. |
| [TypographyFactory](-typography-factory/index.md) | [app]<br>class [TypographyFactory](-typography-factory/index.md)@Injectconstructor(config: [HabitHatchConfig](../com.habithatch.demo.core.config/-habit-hatch-config/index.md))<br>Factory for creating [Typography](https://developer.android.com/reference/kotlin/androidx/compose/material3/Typography.html) instances. |

## Properties

| Name | Summary |
|---|---|
| [onSuccess](on-success.md) | [app]<br>@get:[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>val [ColorScheme](https://developer.android.com/reference/kotlin/androidx/compose/material3/ColorScheme.html).[onSuccess](on-success.md): [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html) |
| [onSuccessContainer](on-success-container.md) | [app]<br>@get:[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>val [ColorScheme](https://developer.android.com/reference/kotlin/androidx/compose/material3/ColorScheme.html).[onSuccessContainer](on-success-container.md): [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html) |
| [onSuccessContainerScheme](on-success-container-scheme.md) | [app]<br>val [onSuccessContainerScheme](on-success-container-scheme.md): [SchemeColor](-scheme-color/index.md) |
| [onSuccessScheme](on-success-scheme.md) | [app]<br>val [onSuccessScheme](on-success-scheme.md): [SchemeColor](-scheme-color/index.md) |
| [success](success.md) | [app]<br>@get:[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>val [ColorScheme](https://developer.android.com/reference/kotlin/androidx/compose/material3/ColorScheme.html).[success](success.md): [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html) |
| [successContainer](success-container.md) | [app]<br>@get:[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>val [ColorScheme](https://developer.android.com/reference/kotlin/androidx/compose/material3/ColorScheme.html).[successContainer](success-container.md): [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html) |
| [successContainerScheme](success-container-scheme.md) | [app]<br>val [successContainerScheme](success-container-scheme.md): [SchemeColor](-scheme-color/index.md) |
| [successScheme](success-scheme.md) | [app]<br>val [successScheme](success-scheme.md): [SchemeColor](-scheme-color/index.md) |

## Functions

| Name | Summary |
|---|---|
| [AppTheme](-app-theme.md) | [app]<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun [AppTheme](-app-theme.md)(typography: [Typography](https://developer.android.com/reference/kotlin/androidx/compose/material3/Typography.html), darkTheme: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = isSystemInDarkTheme(), content: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))<br>The [AppTheme](-app-theme.md) composable, which sets the color scheme and typography for the app. The Colors are dynamically set with Material You, depending one users wallpaper. |