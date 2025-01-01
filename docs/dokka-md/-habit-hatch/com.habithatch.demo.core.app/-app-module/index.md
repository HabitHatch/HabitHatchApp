//[HabitHatch](../../../index.md)/[com.habithatch.demo.core.app](../index.md)/[AppModule](index.md)

# AppModule

[app]\
@Module

class [AppModule](index.md)

Configures Hilt DI providers for the app.

## Constructors

| | |
|---|---|
| [AppModule](-app-module.md) | [app]<br>constructor() |

## Functions

| Name | Summary |
|---|---|
| [provideDatabase](provide-database.md) | [app]<br>@Provides<br>@Singleton<br>fun [provideDatabase](provide-database.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)): [AppDatabase](../../com.habithatch.demo.data.db/-app-database/index.md) |
| [provideGoalDao](provide-goal-dao.md) | [app]<br>@Provides<br>@Singleton<br>fun [provideGoalDao](provide-goal-dao.md)(database: [AppDatabase](../../com.habithatch.demo.data.db/-app-database/index.md)): [GoalDao](../../com.habithatch.demo.data.daos/-goal-dao/index.md) |
| [provideGoogleFontProvider](provide-google-font-provider.md) | [app]<br>@Provides<br>@Singleton<br>fun [provideGoogleFontProvider](provide-google-font-provider.md)(): [GoogleFont.Provider](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/googlefonts/GoogleFont.Provider.html) |
| [provideUserDao](provide-user-dao.md) | [app]<br>@Provides<br>@Singleton<br>fun [provideUserDao](provide-user-dao.md)(database: [AppDatabase](../../com.habithatch.demo.data.db/-app-database/index.md)): [UserDao](../../com.habithatch.demo.data.daos/-user-dao/index.md) |