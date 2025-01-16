//[HabitHatch](../../../index.md)/[com.habithatch.demo.data.daos](../index.md)/[UserDao](index.md)

# UserDao

[app]\
interface [UserDao](index.md)

The Data Access Object for the [UserEntity](../../com.habithatch.demo.data.entities/-user-entity/index.md) class.

## Functions

| Name | Summary |
|---|---|
| [deleteAll](delete-all.md) | [app]<br>abstract suspend fun [deleteAll](delete-all.md)()<br>Deletes all users from the database. But there should only be one user in the database. |
| [getUser](get-user.md) | [app]<br>abstract fun [getUser](get-user.md)(): Flow&lt;[UserEntity](../../com.habithatch.demo.data.entities/-user-entity/index.md)?&gt; |
| [insert](insert.md) | [app]<br>abstract suspend fun [insert](insert.md)(user: [UserEntity](../../com.habithatch.demo.data.entities/-user-entity/index.md)) |