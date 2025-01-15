//[HabitHatch](../../../index.md)/[com.habithatch.demo.data.mappers](../index.md)/[HabitMapper](index.md)/[asEntity](as-entity.md)

# asEntity

[app]\
fun [asEntity](as-entity.md)(habit: [HabitModel](../../com.habithatch.demo.data.models/-habit-model/index.md), userId: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html)): [HabitEntity](../../com.habithatch.demo.data.entities/-habit-entity/index.md)

Maps a [HabitModel](../../com.habithatch.demo.data.models/-habit-model/index.md) to a [HabitEntity](../../com.habithatch.demo.data.entities/-habit-entity/index.md). Every Habit in the Database needs to have a createdAt date. If the habit is a draft, the createdAt date is set to the current date.
