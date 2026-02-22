# Lesson 02.06.02 — Dark Mode
> **Difficulty:** 🟢 Beginner | **Time:** 20 min
## 📚 Theory
```kotlin
@Composable
fun WagwanWorldTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme
    MaterialTheme(colorScheme = colorScheme, content = content)
}
```
Preview both:
```kotlin
@Preview(name = "Light") @Preview(name = "Dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable fun ThemePreview() { WagwanWorldTheme { Surface { Text("Hello") } } }
```
## 🏋️ Exercise: Update all screens to look good in both light and dark mode. Add a theme toggle in Settings.
## 📎 Resources
- [Dark Theme — Android Developers](https://developer.android.com/develop/ui/views/theming/darktheme)
---
⬅️ [Material 3](01-material3-theming.md) | ➡️ [Exercise](03-exercise-theming.md)
