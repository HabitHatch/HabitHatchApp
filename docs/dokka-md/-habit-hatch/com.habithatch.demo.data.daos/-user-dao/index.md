//[HabitHatch](../../../index.md)/[com.habithatch.demo.data.daos](../index.md)/[UserDao](index.md)

# UserDao

[app]\
interface [UserDao](index.md)

The Data Access Object for the [User](../../com.habithatch.demo.data.entities/-user/index.md) class.

## Functions

| Name | Summary |
|---|---|
| [deleteAll](delete-all.md) | [app]<br>abstract suspend fun [deleteAll](delete-all.md)() |
| [getUser](get-user.md) | [app]<br>abstract fun [getUser](get-user.md)(): Flow&lt;[User](../../com.habithatch.demo.data.entities/-user/index.md)?&gt; |
| [insert](insert.md) | [app]<br>abstract suspend fun [insert](insert.md)(user: [User](../../com.habithatch.demo.data.entities/-user/index.md)) |