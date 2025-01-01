//[HabitHatch](../../../index.md)/[com.habithatch.demo.data.mappers](../index.md)/[GoalMapper](index.md)/[asEntity](as-entity.md)

# asEntity

[app]\
fun [asEntity](as-entity.md)(goal: [GoalModel](../../com.habithatch.demo.data.models/-goal-model/index.md), userId: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html)): [GoalEntity](../../com.habithatch.demo.data.entities/-goal-entity/index.md)

Maps a [GoalModel](../../com.habithatch.demo.data.models/-goal-model/index.md) to a [GoalEntity](../../com.habithatch.demo.data.entities/-goal-entity/index.md). Every Goal in the Database needs to have a createdAt date. If the goal is a draft, the createdAt date is set to the current date.