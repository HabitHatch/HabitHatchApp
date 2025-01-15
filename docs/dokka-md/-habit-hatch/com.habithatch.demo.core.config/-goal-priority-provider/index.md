//[HabitHatch](../../../index.md)/[com.habithatch.demo.core.config](../index.md)/[HabitPriorityProvider](index.md)

# HabitPriorityProvider

interface [HabitPriorityProvider](index.md)

Provides the priorities for habits.

#### Inheritors

| |
|---|
| [HabitHatchConfig](../-habit-hatch-config/index.md) |

## Properties

| Name | Summary |
|---|---|
| [defaultPriority](default-priority.md) | [app]<br>abstract val [defaultPriority](default-priority.md): [HabitModel.Priority](../../com.habithatch.demo.data.models/-habit-model/-priority/index.md) |
| [priorities](priorities.md) | [app]<br>abstract val [priorities](priorities.md): [Set](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-set/index.html)&lt;[HabitModel.Priority](../../com.habithatch.demo.data.models/-habit-model/-priority/index.md)&gt; |

## Functions

| Name | Summary |
|---|---|
| [getPriorityByLabel](get-priority-by-label.md) | [app]<br>open fun [getPriorityByLabel](get-priority-by-label.md)(priorityLabel: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)): [HabitModel.Priority](../../com.habithatch.demo.data.models/-habit-model/-priority/index.md) |
