//[HabitHatch](../../index.md)/[com.habithatch.demo.ui.navigation](index.md)/[TopNavBar](-top-nav-bar.md)

# TopNavBar

[app]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [TopNavBar](-top-nav-bar.md)(title: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), rightNavItem: [Screen](../com.habithatch.demo.core.navigation/-screen/index.md)? = null, leftNavItem: [Screen](../com.habithatch.demo.core.navigation/-screen/index.md)? = null, modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier, onRightNavItemClicked: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = {}, onLeftNavItemClicked: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = {})

A top navigation bar that displays the title and navigation items.