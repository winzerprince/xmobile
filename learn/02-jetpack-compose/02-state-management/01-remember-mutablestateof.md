# Lesson 02.02.01 — remember, mutableStateOf & State Hoisting
> **Difficulty:** 🟡 Intermediate | **Time:** 45 min | **Prerequisites:** [Composable Functions](../01-composable-basics/01-composable-functions.md)
---
## 📚 Theory
### The State Problem
Compose functions can be called many times (recomposition). Local variables reset each time:
```kotlin
@Composable
fun BrokenCounter() {
    var count = 0  // ❌ Resets to 0 on every recomposition!
    Button(onClick = { count++ }) { Text("Count: $count") }
}
```
### `remember` — Survive Recomposition
```kotlin
@Composable
fun WorkingCounter() {
    var count by remember { mutableStateOf(0) }  // ✅ Survives recomposition
    Button(onClick = { count++ }) { Text("Count: $count") }
}
```
**`remember`** = "Keep this value across recompositions"
**`mutableStateOf`** = "When this value changes, trigger recomposition"
### `rememberSaveable` — Survive Configuration Changes
```kotlin
var count by rememberSaveable { mutableStateOf(0) }
// Survives screen rotation, process death! (saved to Bundle)
```
### State Hoisting — The Most Important Compose Pattern
```kotlin
// ❌ Stateful composable — hard to test, hard to reuse
@Composable
fun Counter() {
    var count by remember { mutableStateOf(0) }
    Text("$count")
    Button(onClick = { count++ }) { Text("+") }
}
// ✅ Stateless composable — state is "hoisted" to the caller
@Composable
fun Counter(count: Int, onIncrement: () -> Unit) {
    Text("$count")
    Button(onClick = onIncrement) { Text("+") }
}
// Parent manages state:
@Composable
fun ParentScreen() {
    var count by remember { mutableStateOf(0) }
    Counter(count = count, onIncrement = { count++ })
}
```
**Rule:** State goes DOWN (as parameters), Events go UP (as callbacks). This is **Unidirectional Data Flow (UDF)**.
```
ParentScreen (owns state)
    ↓ count (state goes down)
Counter (displays state)
    ↑ onIncrement (event goes up)
```
## 🔍 In Your Project
```kotlin
// HelloScreen currently uses internal state:
var message by remember { mutableStateOf("Hello from Kampala!") }
// This could be hoisted: HelloScreen(message, onToggle)
```
## 🏋️ Exercise
1. Refactor `HelloScreen` to be stateless: extract state to a wrapper composable.
2. Add `rememberSaveable` — rotate the device and verify state survives.
3. Create a `TextField` + `Text` pair where typing updates the text display (two-way state).
## 📎 Resources
- [State in Compose — Android Developers](https://developer.android.com/develop/ui/compose/state)
- [State Hoisting — Android Developers](https://developer.android.com/develop/ui/compose/state-hoisting)
---
➡️ Next: [ViewModel & State](02-viewmodel-state.md)
