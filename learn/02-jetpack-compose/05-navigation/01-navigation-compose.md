# Lesson 02.05.01 — Navigation in Compose
> **Difficulty:** 🟡 Intermediate | **Time:** 45 min
## 📚 Theory
### Setup
```kotlin
// Add: implementation("androidx.navigation:navigation-compose:2.7.7")
val navController = rememberNavController()
NavHost(navController = navController, startDestination = "home") {
    composable("home") { HomeScreen(onPostClick = { id -> navController.navigate("post/$id") }) }
    composable("post/{postId}", arguments = listOf(navArgument("postId") { type = NavType.StringType })) {
        val postId = it.arguments?.getString("postId") ?: ""
        PostDetailScreen(postId, onBack = { navController.popBackStack() })
    }
    composable("settings") { SettingsScreen() }
}
```
### Key Concepts
- **Routes** are strings (like URLs): `"home"`, `"post/{id}"`, `"settings"`
- **NavController** manages the back stack
- **Arguments** pass data between screens: `navController.navigate("post/123")`
- **popBackStack()** goes back
### Bottom Navigation
```kotlin
Scaffold(bottomBar = {
    NavigationBar {
        NavigationBarItem(selected = currentRoute == "home", onClick = { navController.navigate("home") }, icon = { Icon(Icons.Default.Home, null) }, label = { Text("Home") })
        NavigationBarItem(selected = currentRoute == "settings", onClick = { navController.navigate("settings") }, icon = { Icon(Icons.Default.Settings, null) }, label = { Text("Settings") })
    }
}) { padding -> NavHost(modifier = Modifier.padding(padding), ...) }
```
## 🏋️ Exercise
1. Add navigation-compose dependency to WagwanWorld.
2. Create 3 routes: Home (feed), PostDetail, Settings.
3. Navigate from feed PostCard click → PostDetail with post ID.
## 📎 Resources
- [Navigation Compose — Android Developers](https://developer.android.com/develop/ui/compose/navigation)
---
➡️ [Nested Navigation](02-nested-navigation.md)
