//[HabitHatch](../../../index.md)/[com.habithatch.demo.data.db](../index.md)/[AppDatabase](index.md)

# AppDatabase

[app]\
abstract class [AppDatabase](index.md) : [RoomDatabase](https://developer.android.com/reference/kotlin/androidx/room/RoomDatabase.html)

The Room database for this app.

## Constructors

| | |
|---|---|
| [AppDatabase](-app-database.md) | [app]<br>constructor() |

## Functions

| Name | Summary |
|---|---|
| [goalDao](goal-dao.md) | [app]<br>abstract fun [goalDao](goal-dao.md)(): [GoalDao](../../com.habithatch.demo.data.daos/-goal-dao/index.md) |
| [userDao](user-dao.md) | [app]<br>abstract fun [userDao](user-dao.md)(): [UserDao](../../com.habithatch.demo.data.daos/-user-dao/index.md) |