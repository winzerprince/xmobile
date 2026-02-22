# Lesson 02.06.01 — Material 3 Theming
> **Difficulty:** 🟡 Intermediate | **Time:** 35 min
## 📚 Theory
### MaterialTheme Has 3 Pillars
```kotlin
MaterialTheme(
    colorScheme = lightColorScheme(...),  // Colors
    typography = Typography(...),          // Text styles
    shapes = Shapes(...)                   // Corner shapes
) { content() }
```
### Color Scheme — Primary, Secondary, Tertiary
```kotlin
MaterialTheme.colorScheme.primary        // Main brand color
MaterialTheme.colorScheme.onPrimary      // Text ON primary color
MaterialTheme.colorScheme.surface        // Background of cards
MaterialTheme.colorScheme.onSurface      // Text on surface
MaterialTheme.colorScheme.error          // Error states
```
### Dynamic Color (Android 12+)
```kotlin
val colorScheme = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
    if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
} else { if (darkTheme) DarkColorScheme else LightColorScheme }
```
Your `Theme.kt` already does this! Dynamic colors come from the user's wallpaper.
### Material Theme Builder
Use [Material Theme Builder](https://m3.material.io/theme-builder) to generate color schemes from a seed color.
## 🏋️ Exercise
1. Go to Material Theme Builder, pick a seed color for WagwanWorld.
2. Update `Color.kt` and `Theme.kt` with your custom colors.
3. Ensure all UI uses `MaterialTheme.colorScheme` (not hardcoded colors).
## 📎 Resources
- [Material 3 Theming — Android Developers](https://developer.android.com/develop/ui/compose/designsystems/material3)
- [Material Theme Builder](https://m3.material.io/theme-builder)
---
➡️ [Dark Mode](02-dark-mode.md)
