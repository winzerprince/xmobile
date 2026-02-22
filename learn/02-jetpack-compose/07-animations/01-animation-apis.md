# Lesson 02.07.01 — Animation APIs
> **Difficulty:** 🟡 Intermediate | **Time:** 40 min
## 📚 Theory
### animateXAsState — Simplest Animation
```kotlin
val alpha by animateFloatAsState(targetValue = if (visible) 1f else 0f, label = "alpha")
val color by animateColorAsState(targetValue = if (selected) Color.Red else Color.Gray, label = "color")
val size by animateDpAsState(targetValue = if (expanded) 200.dp else 100.dp, label = "size")
Box(Modifier.size(size).alpha(alpha).background(color))
```
### AnimatedVisibility
```kotlin
AnimatedVisibility(visible = showDetails, enter = fadeIn() + expandVertically(), exit = fadeOut() + shrinkVertically()) {
    Text("Details content here")
}
```
### AnimatedContent — Animate Between Different Content
```kotlin
AnimatedContent(targetState = count, label = "counter") { target ->
    Text("$target", fontSize = 24.sp)
}
```
### Crossfade
```kotlin
Crossfade(targetState = currentScreen, label = "screen") { screen ->
    when (screen) { "home" -> HomeScreen(); "settings" -> SettingsScreen() }
}
```
### AnimationSpec — Control Timing
```kotlin
animateDpAsState(target, animationSpec = tween(durationMillis = 300, easing = FastOutSlowInEasing))
animateDpAsState(target, animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy))
```
## 🏋️ Exercise
1. Animate PostCard expansion (click to show full body text).
2. Add AnimatedVisibility to the loading indicator.
3. Use Crossfade for screen transitions.
## 📎 Resources
- [Animations in Compose — Android Developers](https://developer.android.com/develop/ui/compose/animation/introduction)
---
➡️ [Transitions](02-transitions.md)
