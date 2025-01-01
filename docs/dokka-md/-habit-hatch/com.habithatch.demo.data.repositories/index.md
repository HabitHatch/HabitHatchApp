//[HabitHatch](../../index.md)/[com.habithatch.demo.data.repositories](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [GoalRepository](-goal-repository/index.md) | [app]<br>class [GoalRepository](-goal-repository/index.md)@Injectconstructor(goalDao: [GoalDao](../com.habithatch.demo.data.daos/-goal-dao/index.md), goalMapper: [GoalMapper](../com.habithatch.demo.data.mappers/-goal-mapper/index.md), userRepository: [UserRepository](-user-repository/index.md))<br>[GoalRepository](-goal-repository/index.md) is a repository that provides access to goals in the database. |
| [UserRepository](-user-repository/index.md) | [app]<br>class [UserRepository](-user-repository/index.md)@Injectconstructor(userDao: [UserDao](../com.habithatch.demo.data.daos/-user-dao/index.md))<br>[UserRepository](-user-repository/index.md) is a repository that provides access to the user in the database. Since there is only one user, the repository provides methods to create, read, update and delete the user. |