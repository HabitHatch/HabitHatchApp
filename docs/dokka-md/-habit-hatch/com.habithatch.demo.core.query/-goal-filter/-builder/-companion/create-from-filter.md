//[HabitHatch](../../../../../index.md)/[com.habithatch.demo.core.query](../../../index.md)/[HabitFilter](../../index.md)/[Builder](../index.md)/[Companion](index.md)/[createFromFilter](create-from-filter.md)

# createFromFilter

[app]\
fun [createFromFilter](create-from-filter.md)(habitFilter: [HabitFilter](../../index.md), priorityProvider: [HabitPriorityProvider](../../../../com.habithatch.demo.core.config/-habit-priority-provider/index.md), statusProvider: [HabitStatusProvider](../../../../com.habithatch.demo.core.config/-habit-status-provider/index.md)): [HabitFilter.Builder](../index.md)

Creates a [HabitFilter.Builder](../index.md) from a [HabitFilter](../../index.md).

#### Parameters

app

| | |
|---|---|
| habitFilter | The [HabitFilter](../../index.md) to copy. |
| priorityProvider | Provides the priorities for habits. |
| statusProvider | Provides the statuses for habits. |
