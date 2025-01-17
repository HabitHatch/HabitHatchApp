//[HabitHatch](../../index.md)/[com.habithatch.demo.data.models](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [ExampleHabitFactory](-example-habit-factory/index.md) | [app]<br>class [ExampleHabitFactory](-example-habit-factory/index.md)(priorityProvider: [HabitPriorityProvider](../com.habithatch.demo.core.config/-habit-priority-provider/index.md), statusProvider: [HabitStatusProvider](../com.habithatch.demo.core.config/-habit-status-provider/index.md), habitModelFactory: [HabitModel.Factory](-habit-model/-factory/index.md))<br>[ExampleHabitFactory](-example-habit-factory/index.md) is a factory that creates example habits for testing purposes. |
| [HabitModel](-habit-model/index.md) | [app]<br>@[Immutable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Immutable.html)<br>data class [HabitModel](-habit-model/index.md)<br>[HabitModel](-habit-model/index.md) represents a habit. |
| [UserModel](-user-model/index.md) | [app]<br>data class [UserModel](-user-model/index.md)(val uuid: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html), val pet: [Pet](../com.habithatch.demo.data.entities/-pet/index.md)) |