//[HabitHatch](../../../index.md)/[com.habithatch.demo.core.config](../index.md)/[GoalPriorityProvider](index.md)

# GoalPriorityProvider

interface [GoalPriorityProvider](index.md)

Provides the priorities for goals.

#### Inheritors

| |
|---|
| [HabitHatchConfig](../-habit-hatch-config/index.md) |

## Properties

| Name | Summary |
|---|---|
| [defaultPriority](default-priority.md) | [app]<br>abstract val [defaultPriority](default-priority.md): [GoalModel.Priority](../../com.habithatch.demo.data.models/-goal-model/-priority/index.md) |
| [priorities](priorities.md) | [app]<br>abstract val [priorities](priorities.md): [Set](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-set/index.html)&lt;[GoalModel.Priority](../../com.habithatch.demo.data.models/-goal-model/-priority/index.md)&gt; |

## Functions

| Name | Summary |
|---|---|
| [getPriorityByLabel](get-priority-by-label.md) | [app]<br>open fun [getPriorityByLabel](get-priority-by-label.md)(priorityLabel: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)): [GoalModel.Priority](../../com.habithatch.demo.data.models/-goal-model/-priority/index.md) |