# Lesson 02.03.01 — Column, Row & Box
> **Difficulty:** 🟢 Beginner | **Time:** 35 min | **Prerequisites:** [Composable Basics](../01-composable-basics/)
## 📚 Theory
### Column — Vertical Stack
```kotlin
Column(
    modifier = Modifier.fillMaxSize().padding(16.dp),
    verticalArrangement = Arrangement.SpaceBetween,
    horizontalAlignment = Alignment.CenterHorizontally
) { Text("Top"); Text("Middle"); Text("Bottom") }
```
### Row — Horizontal Stack
```kotlin
Row(horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically) {
    Icon(Icons.Default.Star, contentDescription = null); Text("Rating: 4.5")
}
```
### Box — Overlap/Stack
```kotlin
Box(modifier = Modifier.size(200.dp)) {
    Image(painter = ..., modifier = Modifier.fillMaxSize())
    Text("Overlay", modifier = Modifier.align(Alignment.BottomCenter))
}
```
### Weight & Spacer
```kotlin
Row(Modifier.fillMaxWidth()) {
    Text("1/3", Modifier.weight(1f)); Text("2/3", Modifier.weight(2f))
}
Spacer(modifier = Modifier.height(16.dp))
```
## 🏋️ Exercise
1. Create a profile header: Row with avatar (Box) + Column of name/bio.
2. Create a toolbar: Row with back button + centered title + settings icon using weight.
## 📎 Resources
- [Layouts in Compose — Android Developers](https://developer.android.com/develop/ui/compose/layouts/basics)
---
⬅️ Previous: [Counter Exercise](../02-state-management/03-exercise-counter-app.md) | ➡️ Next: [Lazy Layouts](02-lazy-layouts.md)
