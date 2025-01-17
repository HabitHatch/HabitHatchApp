//[HabitHatch](../../../index.md)/[com.habithatch.demo.core.app](../index.md)/[AppBindingModule](index.md)

# AppBindingModule

[app]\
@Module

abstract class [AppBindingModule](index.md)

Configures Hilt DI bindings for the app.

## Constructors

| | |
|---|---|
| [AppBindingModule](-app-binding-module.md) | [app]<br>constructor() |

## Functions

| Name | Summary |
|---|---|
| [bindConfig](bind-config.md) | [app]<br>@Binds<br>@Singleton<br>abstract fun [bindConfig](bind-config.md)(devConfig: [HabitHatchDevConfig](../../com.habithatch.demo.core.config/-habit-hatch-dev-config/index.md)): [HabitHatchConfig](../../com.habithatch.demo.core.config/-habit-hatch-config/index.md) |
| [bindPrioritiesProvider](bind-priorities-provider.md) | [app]<br>@Binds<br>@Singleton<br>abstract fun [bindPrioritiesProvider](bind-priorities-provider.md)(devConfig: [HabitHatchDevConfig](../../com.habithatch.demo.core.config/-habit-hatch-dev-config/index.md)): [HabitPriorityProvider](../../com.habithatch.demo.core.config/-habit-priority-provider/index.md) |
| [bindStatusProvider](bind-status-provider.md) | [app]<br>@Binds<br>@Singleton<br>abstract fun [bindStatusProvider](bind-status-provider.md)(devConfig: [HabitHatchDevConfig](../../com.habithatch.demo.core.config/-habit-hatch-dev-config/index.md)): [HabitStatusProvider](../../com.habithatch.demo.core.config/-habit-status-provider/index.md) |
