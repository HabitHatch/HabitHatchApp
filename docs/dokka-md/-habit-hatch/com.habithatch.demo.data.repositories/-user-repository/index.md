//[HabitHatch](../../../index.md)/[com.habithatch.demo.data.repositories](../index.md)/[UserRepository](index.md)

# UserRepository

[app]\
class [UserRepository](index.md)@Injectconstructor(userDao: [UserDao](../../com.habithatch.demo.data.daos/-user-dao/index.md))

[UserRepository](index.md) is a repository that provides access to the user in the database. Since there is only one user, the repository provides methods to create, read, update and delete the user.

## Constructors

| | |
|---|---|
| [UserRepository](-user-repository.md) | [app]<br>@Inject<br>constructor(userDao: [UserDao](../../com.habithatch.demo.data.daos/-user-dao/index.md)) |

## Functions

| Name | Summary |
|---|---|
| [createUser](create-user.md) | [app]<br>suspend fun [createUser](create-user.md)(user: [User](../../com.habithatch.demo.data.entities/-user/index.md)) |
| [deleteUser](delete-user.md) | [app]<br>suspend fun [deleteUser](delete-user.md)() |
| [getUser](get-user.md) | [app]<br>fun [getUser](get-user.md)(): Flow&lt;[User](../../com.habithatch.demo.data.entities/-user/index.md)?&gt; |
| [hasUser](has-user.md) | [app]<br>suspend fun [hasUser](has-user.md)(): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |