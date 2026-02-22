# Lesson 02.07.02 — Transitions & Infinite Animations
> **Difficulty:** 🔴 Advanced | **Time:** 30 min
## 📚 Theory
### updateTransition — Coordinated Animations
```kotlin
val transition = updateTransition(targetState = selected, label = "card")
val borderColor by transition.animateColor(label = "border") { if (it) Color.Blue else Color.Gray }
val elevation by transition.animateDp(label = "elevation") { if (it) 8.dp else 2.dp }
```
### InfiniteTransition — Repeating Animations
```kotlin
val infiniteTransition = rememberInfiniteTransition(label = "pulse")
val alpha by infiniteTransition.animateFloat(initialValue = 0.3f, targetValue = 1f,
    animationSpec = infiniteRepeatable(animation = tween(1000), repeatMode = RepeatMode.Reverse), label = "alpha")
```
## 🏋️ Exercise
1. Create a pulsing "loading" indicator with InfiniteTransition.
2. Coordinate multiple animations on a card selection using updateTransition.
## 📎 Resources
- [Advanced Animations](https://developer.android.com/develop/ui/compose/animation/composables-modifiers)
---
⬅️ [Animation APIs](01-animation-apis.md) | ➡️ [Exercise](03-exercise-animations.md)
