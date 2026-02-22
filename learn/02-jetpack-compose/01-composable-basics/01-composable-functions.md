# Lesson 02.01.01 — Composable Functions & Recomposition
> **Difficulty:** 🟡 Intermediate | **Time:** 45 min | **Prerequisites:** Module 01 complete
---
## 🧠 Why This Matters
Compose is a **declarative UI framework**. Instead of telling Android HOW to update the UI step-by-step (imperative), you describe WHAT the UI should look like for a given state. Compose figures out the updates.
## 📚 Theory
### Imperative vs Declarative
```kotlin
// IMPERATIVE (old View system):
textView.text = "Hello"           // Step 1: find the view
textView.setTextColor(Color.RED)  // Step 2: change its color
button.setOnClickListener { ... } // Step 3: set listener
// You manage each mutation yourself
// DECLARATIVE (Compose):
@Composable
fun Greeting(name: String) {
    Text(text = "Hello, $name!", color = Color.Red)  // Describe the end state
}
// Compose handles creating, updating, and destroying views
```
### What @Composable Means
```kotlin
@Composable  // This annotation tells the Compose compiler to transform this function
fun HelloScreen() { ... }
```
The Compose compiler plugin (in your `build.gradle.kts`: `alias(libs.plugins.kotlin.compose)`) rewrites `@Composable` functions at compile time to:
- Track which state they read
- Know when to re-execute (recompose) when that state changes
- Efficiently update only the parts of the UI tree that changed
### Recomposition — The Core Concept
```kotlin
@Composable
fun Counter() {
    var count by remember { mutableStateOf(0) }
    // This entire function CAN be re-called when count changes
    // But Compose is SMART — it only re-executes what actually needs to change
    Column {
        Text("Count: $count")      // ← Recomposes when count changes
        Text("Static text")        // ← Compose SKIPS this (no state dependency)
        Button(onClick = { count++ }) {
            Text("Increment")
        }
    }
}
```
### Rules of Composable Functions
1. **Can only be called from other @Composable functions** (or `setContent {}`)
2. **Should be fast** — no heavy computation, no blocking I/O
3. **Should be idempotent** — same inputs → same UI
4. **Should be side-effect free** — no writing to external variables (use `LaunchedEffect` for that)
5. **Can be called in any order** — don't rely on execution order
6. **Can be called multiple times** — recomposition can happen frequently
### The Compose Compiler — What Happens Under the Hood
```
Your Kotlin code (.kt)
    ↓ Kotlin Compiler + Compose Compiler Plugin
Generates code that:
    1. Builds a "slot table" (internal UI tree representation)
    2. Tracks state reads per composable
    3. On state change → marks affected composables as "invalid"
    4. Re-executes only invalid composables (smart recomposition)
    5. Diffs the slot table → minimal UI updates
```
## 🔍 In Your Project
```kotlin
// In MainActivity.kt — your entire UI is composable:
setContent {                    // Entry point from Activity → Compose
    WagwanWorldTheme {          // @Composable function (theme provider)
        Surface(...) {          // @Composable function (background container)
            HelloScreen()       // @Composable function (your screen)
        }
    }
}
```
## 🏋️ Exercise
1. Add `println("HelloScreen recomposed!")` at the top of `HelloScreen()`. Click the button and watch Logcat — how many times does it recompose?
2. Create a new `@Composable fun AppHeader(title: String)` that displays a styled title. Call it from `HelloScreen()`.
3. Add a second `var` state. Notice that changing one state recomposes the composable, but Compose skips parts that don't depend on it.
## 📎 Resources
- [Thinking in Compose — Android Developers](https://developer.android.com/develop/ui/compose/mental-model)
- [Lifecycle of Composables — Android Developers](https://developer.android.com/develop/ui/compose/lifecycle)
- [Compose Compiler — Android Developers](https://developer.android.com/develop/ui/compose/compiler)
---
➡️ Next: [Previews](02-previews.md)
