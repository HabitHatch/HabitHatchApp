//[HabitHatch](../../../index.md)/[com.habithatch.demo.data.models](../index.md)/[ExampleGoalFactory](index.md)

# ExampleGoalFactory

[app]\
class [ExampleGoalFactory](index.md)(priorityProvider: [GoalPriorityProvider](../../com.habithatch.demo.core.config/-goal-priority-provider/index.md), statusProvider: [GoalStatusProvider](../../com.habithatch.demo.core.config/-goal-status-provider/index.md), goalModelFactory: [GoalModel.Factory](../-goal-model/-factory/index.md))

[ExampleGoalFactory](index.md) is a factory that creates example goals for testing purposes.

## Constructors

| | |
|---|---|
| [ExampleGoalFactory](-example-goal-factory.md) | [app]<br>constructor(priorityProvider: [GoalPriorityProvider](../../com.habithatch.demo.core.config/-goal-priority-provider/index.md), statusProvider: [GoalStatusProvider](../../com.habithatch.demo.core.config/-goal-status-provider/index.md), goalModelFactory: [GoalModel.Factory](../-goal-model/-factory/index.md)) |

## Functions

| Name | Summary |
|---|---|
| [createExampleGoals](create-example-goals.md) | [app]<br>fun [createExampleGoals](create-example-goals.md)(count: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), userId: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html), pastYears: [Long](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-long/index.html) = 1, uniqueTitles: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = false): [Collection](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-collection/index.html)&lt;[GoalModel](../-goal-model/index.md)&gt; |