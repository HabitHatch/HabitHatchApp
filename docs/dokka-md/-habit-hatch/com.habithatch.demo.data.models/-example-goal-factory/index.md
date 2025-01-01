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
| [createExampleGoal](create-example-goal.md) | [app]<br>fun [createExampleGoal](create-example-goal.md)(pastYears: [Long](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-long/index.html) = 1): [GoalModel](../-goal-model/index.md) |
| [createExampleGoals](create-example-goals.md) | [app]<br>fun [createExampleGoals](create-example-goals.md)(count: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), pastYears: [Long](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-long/index.html) = 1, uniqueTitles: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = false): [Collection](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-collection/index.html)&lt;[GoalModel](../-goal-model/index.md)&gt; |
| [randomPriority](random-priority.md) | [app]<br>fun [randomPriority](random-priority.md)(): [GoalModel.Priority](../-goal-model/-priority/index.md) |
| [randomStatus](random-status.md) | [app]<br>fun [randomStatus](random-status.md)(): [GoalModel.Status](../-goal-model/-status/index.md) |