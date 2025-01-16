//[HabitHatch](../../index.md)/[com.habithatch.demo.data.models](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [ExampleGoalFactory](-example-goal-factory/index.md) | [app]<br>class [ExampleGoalFactory](-example-goal-factory/index.md)(priorityProvider: [GoalPriorityProvider](../com.habithatch.demo.core.config/-goal-priority-provider/index.md), statusProvider: [GoalStatusProvider](../com.habithatch.demo.core.config/-goal-status-provider/index.md), goalModelFactory: [GoalModel.Factory](-goal-model/-factory/index.md))<br>[ExampleGoalFactory](-example-goal-factory/index.md) is a factory that creates example goals for testing purposes. |
| [GoalModel](-goal-model/index.md) | [app]<br>@[Immutable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Immutable.html)<br>data class [GoalModel](-goal-model/index.md)<br>[GoalModel](-goal-model/index.md) represents a goal. |
| [UserModel](-user-model/index.md) | [app]<br>data class [UserModel](-user-model/index.md)(val uuid: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html), val pet: [Pet](../com.habithatch.demo.data.entities/-pet/index.md)) |