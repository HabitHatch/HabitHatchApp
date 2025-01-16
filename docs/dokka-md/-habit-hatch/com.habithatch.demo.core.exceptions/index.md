//[HabitHatch](../../index.md)/[com.habithatch.demo.core.exceptions](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [InvalidUUIdException](-invalid-u-u-id-exception/index.md) | [app]<br>class [InvalidUUIdException](-invalid-u-u-id-exception/index.md)(uuid: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), causedBy: [Exception](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-exception/index.html)) : [IllegalArgumentException](https://developer.android.com/reference/kotlin/java/lang/IllegalArgumentException.html)<br>Exception thrown when a UUID is invalid. |
| [UserExistsException](-user-exists-exception/index.md) | [app]<br>class [UserExistsException](-user-exists-exception/index.md)(user: [UserEntity](../com.habithatch.demo.data.entities/-user-entity/index.md)) : [IllegalStateException](https://developer.android.com/reference/kotlin/java/lang/IllegalStateException.html)<br>Exception thrown when a user already exists in the database. Only one user is allowed in the local database. |