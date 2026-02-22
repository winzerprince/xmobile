# Lesson 02.04.01 — Modifiers Deep Dive
> **Difficulty:** 🟡 Intermediate | **Time:** 40 min
## 📚 Theory
### Order Matters!
```kotlin
// Padding THEN background = padding is outside the color
Modifier.padding(16.dp).background(Color.Red)
// Background THEN padding = padding is inside the color
Modifier.background(Color.Red).padding(16.dp)
```
### Common Modifiers
| Modifier | Purpose |
|----------|---------|
| `.fillMaxSize/Width/Height()` | Take all available space |
| `.size(w, h)` / `.width()` / `.height()` | Fixed dimensions |
| `.padding(all/horizontal/vertical)` | Inner spacing |
| `.background(color, shape)` | Background |
| `.border(width, color, shape)` | Border |
| `.clip(shape)` | Clip to shape |
| `.clickable { }` | Handle clicks |
| `.scrollable()` | Add scrolling |
| `.alpha(0.5f)` | Transparency |
| `.rotate(45f)` | Rotation |
| `.offset(x, y)` | Position offset |
| `.semantics { contentDescription = "..." }` | Accessibility |
| `.testTag("tag")` | For UI tests |
### Custom Modifiers
```kotlin
fun Modifier.cardStyle() = this.fillMaxWidth().padding(8.dp).clip(RoundedCornerShape(12.dp)).background(Color.White)
```
## 🏋️ Exercise
1. Experiment with modifier order: padding→background vs background→padding. Screenshot both.
2. Create a custom `Modifier.postCardStyle()` and apply it to all PostCards.
## 📎 Resources
- [Modifiers — Android Developers](https://developer.android.com/develop/ui/compose/modifiers)
---
⬅️ [Feed Screen](../03-layouts/04-exercise-feed-screen.md) | ➡️ [Exercise](02-exercise-custom-card.md)
