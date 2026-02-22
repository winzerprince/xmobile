# Lesson 02.05.02 — Nested Navigation & Deep Links
> **Difficulty:** 🟡 Intermediate | **Time:** 30 min
## 📚 Theory
### Nested Nav Graphs
```kotlin
NavHost(navController, startDestination = "main") {
    navigation(startDestination = "home", route = "main") {
        composable("home") { ... }
        composable("profile") { ... }
    }
    navigation(startDestination = "login", route = "auth") {
        composable("login") { ... }
        composable("register") { ... }
    }
}
```
### Deep Links
```kotlin
composable("post/{id}", deepLinks = listOf(navDeepLink { uriPattern = "wagwanworld://post/{id}" })) { ... }
```
## 🏋️ Exercise
1. Create a nested "auth" graph with login/register screens.
2. Add deep link support for post detail.
## 📎 Resources
- [Nested Navigation](https://developer.android.com/develop/ui/compose/navigation#nested-nav)
---
⬅️ [Navigation Compose](01-navigation-compose.md) | ➡️ [Exercise](03-exercise-multi-screen.md)
