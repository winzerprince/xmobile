# Lesson 02.08.01 — Side Effects in Compose
> **Difficulty:** 🔴 Advanced | **Time:** 45 min
## 📚 Theory
Composables should be pure. Side effects (launching coroutines, registering listeners, logging) need special APIs.
### LaunchedEffect — Run Coroutine on Composition
```kotlin
@Composable
fun Screen(userId: String) {
    LaunchedEffect(userId) {  // Re-launches when userId changes
        viewModel.loadUser(userId)
    }
}
```
### DisposableEffect — Register & Cleanup
```kotlin
DisposableEffect(lifecycleOwner) {
    val observer = LifecycleEventObserver { _, event -> ... }
    lifecycleOwner.lifecycle.addObserver(observer)
    onDispose { lifecycleOwner.lifecycle.removeObserver(observer) }
}
```
### rememberCoroutineScope — Launch from Callbacks
```kotlin
val scope = rememberCoroutineScope()
Button(onClick = { scope.launch { viewModel.save() } }) { Text("Save") }
```
### derivedStateOf — Computed State
```kotlin
val sortedList by remember { derivedStateOf { items.sortedBy { it.name } } }
// Only recomputes when items actually changes
```
### produceState — Convert Non-Compose State
```kotlin
val user by produceState<User?>(initialValue = null) {
    value = repository.fetchUser()
}
```
### snapshotFlow — Convert Compose State to Flow
```kotlin
LaunchedEffect(Unit) {
    snapshotFlow { listState.firstVisibleItemIndex }
        .collect { index -> analytics.trackScroll(index) }
}
```
## 🏋️ Exercise
1. Use `LaunchedEffect` to load data when a screen first appears.
2. Use `DisposableEffect` to register a lifecycle observer.
3. Use `derivedStateOf` to compute a filtered list without unnecessary recompositions.
## 📎 Resources
- [Side Effects — Android Developers](https://developer.android.com/develop/ui/compose/side-effects)
---
➡️ [Exercise](02-exercise-side-effects.md)
