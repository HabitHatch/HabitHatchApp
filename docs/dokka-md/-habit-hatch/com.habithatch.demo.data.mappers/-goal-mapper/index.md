//[HabitHatch](../../../index.md)/[com.habithatch.demo.data.mappers](../index.md)/[HabitMapper](index.md)

# HabitMapper

[app]\
class [HabitMapper](index.md)@Injectconstructor(statusProvider: [HabitStatusProvider](../../com.habithatch.demo.core.config/-habit-status-provider/index.md), priorityProvider: [HabitPriorityProvider](../../com.habithatch.demo.core.config/-habit-priority-provider/index.md), habitModelFactory: [HabitModel.Factory](../../com.habithatch.demo.data.models/-habit-model/-factory/index.md))

[HabitMapper](index.md) is a mapper that maps [HabitModel](../../com.habithatch.demo.data.models/-habit-model/index.md) to [HabitEntity](../../com.habithatch.demo.data.entities/-habit-entity/index.md) and vice versa. [HabitEntity](../../com.habithatch.demo.data.entities/-habit-entity/index.md) is a RoomEntity, used for storing habits in the database. [HabitModel](../../com.habithatch.demo.data.models/-habit-model/index.md) is a model used for creating and displaying habits.

## Constructors

| | |
|---|---|
| [HabitMapper](-habit-mapper.md) | [app]<br>@Inject<br>constructor(statusProvider: [HabitStatusProvider](../../com.habithatch.demo.core.config/-habit-status-provider/index.md), priorityProvider: [HabitPriorityProvider](../../com.habithatch.demo.core.config/-habit-priority-provider/index.md), habitModelFactory: [HabitModel.Factory](../../com.habithatch.demo.data.models/-habit-model/-factory/index.md)) |

## Functions

| Name | Summary |
|---|---|
| [asEntity](as-entity.md) | [app]<br>fun [asEntity](as-entity.md)(habit: [HabitModel](../../com.habithatch.demo.data.models/-habit-model/index.md), userId: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html)): [HabitEntity](../../com.habithatch.demo.data.entities/-habit-entity/index.md)<br>Maps a [HabitModel](../../com.habithatch.demo.data.models/-habit-model/index.md) to a [HabitEntity](../../com.habithatch.demo.data.entities/-habit-entity/index.md). Every Habit in the Database needs to have a createdAt date. If the habit is a draft, the createdAt date is set to the current date. |
| [asModel](as-model.md) | [app]<br>fun [asModel](as-model.md)(entity: [HabitEntity](../../com.habithatch.demo.data.entities/-habit-entity/index.md)): [HabitModel](../../com.habithatch.demo.data.models/-habit-model/index.md) |
