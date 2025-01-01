//[HabitHatch](../../index.md)/[com.habithatch.demo.features.settings](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [SettingsScreenState](-settings-screen-state/index.md) | [app]<br>data class [SettingsScreenState](-settings-screen-state/index.md)(val onDeleteAccount: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))<br>Represents the state of the settings screen. |
| [SettingsViewModel](-settings-view-model/index.md) | [app]<br>class [SettingsViewModel](-settings-view-model/index.md)@Injectconstructor(userRepository: [UserRepository](../com.habithatch.demo.data.repositories/-user-repository/index.md), goalRepository: [GoalRepository](../com.habithatch.demo.data.repositories/-goal-repository/index.md)) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)<br>[SettingsViewModel](-settings-view-model/index.md) is a ViewModel that provides the settings screen with the necessary data. |

## Functions

| Name | Summary |
|---|---|
| [rememberSettingsScreenState](remember-settings-screen-state.md) | [app]<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun [rememberSettingsScreenState](remember-settings-screen-state.md)(viewModel: [SettingsViewModel](-settings-view-model/index.md) = hiltViewModel()): [SettingsScreenState](-settings-screen-state/index.md) |
| [SettingsScreen](-settings-screen.md) | [app]<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun [SettingsScreen](-settings-screen.md)(topNavBar: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html), bottomNavBar: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html), state: [SettingsScreenState](-settings-screen-state/index.md) = rememberSettingsScreenState())<br>The settings screen composable. Shows the UI for the user to change their settings. |