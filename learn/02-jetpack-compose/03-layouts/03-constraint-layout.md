# Lesson 02.03.03 — ConstraintLayout in Compose
> **Difficulty:** 🟡 Intermediate | **Time:** 30 min
## 📚 Theory
Use when Column/Row nesting gets too deep. Dependency: `constraintlayout-compose`.
```kotlin
ConstraintLayout(modifier = Modifier.fillMaxSize()) {
    val (title, subtitle, button) = createRefs()
    Text("Title", Modifier.constrainAs(title) { top.linkTo(parent.top, 16.dp) })
    Text("Sub", Modifier.constrainAs(subtitle) { top.linkTo(title.bottom, 8.dp) })
}
```
## 📎 Resources
- [ConstraintLayout in Compose](https://developer.android.com/develop/ui/compose/layouts/constraintlayout)
---
⬅️ [Lazy Layouts](02-lazy-layouts.md) | ➡️ [Exercise](04-exercise-feed-screen.md)
