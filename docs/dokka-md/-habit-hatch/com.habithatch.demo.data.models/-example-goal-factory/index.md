//[HabitHatch](../../../index.md)/[com.habithatch.demo.data.models](../index.md)/[ExampleHabitFactory](index.md)

# ExampleHabitFactory

[app]\
class [ExampleHabitFactory](index.md)(priorityProvider: [HabitPriorityProvider](../../com.habithatch.demo.core.config/-habit-priority-provider/index.md), statusProvider: [HabitStatusProvider](../../com.habithatch.demo.core.config/-habit-status-provider/index.md), habitModelFactory: [HabitModel.Factory](../-habit-model/-factory/index.md))

[ExampleHabitFactory](index.md) is a factory that creates example habits for testing purposes.

## Constructors

| | |
|---|---|
| [ExampleHabitFactory](-example-habit-factory.md) | [app]<br>constructor(priorityProvider: [HabitPriorityProvider](../../com.habithatch.demo.core.config/-habit-priority-provider/index.md), statusProvider: [HabitStatusProvider](../../com.habithatch.demo.core.config/-habit-status-provider/index.md), habitModelFactory: [HabitModel.Factory](../-habit-model/-factory/index.md)) |

## Functions

| Name | Summary |
|---|---|
| [createExampleHabit](create-example-habit.md) | [app]<br>fun [createExampleHabit](create-example-habit.md)(pastYears: [Long](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-long/index.html) = 1): [HabitModel](../-habit-model/index.md) |
| [createExampleHabits](create-example-habits.md) | [app]<br>fun [createExampleHabits](create-example-habits.md)(count: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), pastYears: [Long](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-long/index.html) = 1, uniqueTitles: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = false): [Collection](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-collection/index.html)&lt;[HabitModel](../-habit-model/index.md)&gt; |
| [randomPriority](random-priority.md) | [app]<br>fun [randomPriority](random-priority.md)(): [HabitModel.Priority](../-habit-model/-priority/index.md) |
| [randomStatus](random-status.md) | [app]<br>fun [randomStatus](random-status.md)(): [HabitModel.Status](../-habit-model/-status/index.md) |
