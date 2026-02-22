# Lesson 01.04.03 — Coroutines Basics
> **Difficulty:** 🟡 Intermediate | **Time:** 45 min | **Prerequisites:** [Lambdas](../02-functions/02-lambdas-higher-order.md)
---
## 🧠 Why This Matters
Network calls, database queries, file I/O — these are slow. If you run them on the main thread, your UI freezes. Coroutines let you write async code that LOOKS synchronous.
## 📚 Theory
### The Problem: Blocking the Main Thread
```kotlin
// ❌ BAD — blocks UI for 3 seconds:
fun loadData() {
    val data = networkCall()  // Takes 3 seconds — UI FROZEN
    updateUI(data)
}
// ✅ GOOD — coroutine, non-blocking:
fun loadData() {
    viewModelScope.launch {
        val data = networkCall()  // Suspends, UI keeps running
        updateUI(data)            // Resumes here when data arrives
    }
}
```
### `suspend` Functions
```kotlin
suspend fun fetchUser(): User {
    delay(1000)  // Suspends for 1 second WITHOUT blocking the thread
    return User("Alice", 25)
}
// Can ONLY be called from another suspend function or a coroutine
```
### Coroutine Builders
```kotlin
// launch — fire and forget (returns Job)
viewModelScope.launch {
    val user = fetchUser()
    updateUI(user)
}
// async — returns a Deferred (future value)
val deferred: Deferred<User> = viewModelScope.async {
    fetchUser()
}
val user = deferred.await()  // Suspends until result is ready
```
### Dispatchers — Where Coroutines Run
```kotlin
Dispatchers.Main    // UI thread — update UI here
Dispatchers.IO      // Optimized for disk/network I/O
Dispatchers.Default // Optimized for CPU-heavy work (sorting, parsing)
viewModelScope.launch(Dispatchers.IO) {
    val data = fetchFromNetwork()       // Runs on IO thread
    withContext(Dispatchers.Main) {
        updateUI(data)                   // Switches to main thread
    }
}
```
### Structured Concurrency
```kotlin
viewModelScope.launch {
    // If viewModelScope is cancelled (ViewModel destroyed),
    // ALL coroutines inside are cancelled automatically!
    val user = fetchUser()     // Cancelled if scope dies
    val posts = fetchPosts()   // Cancelled if scope dies
}
```
## 🔍 In Your Project
Your `lifecycle-runtime-ktx` dependency provides `lifecycleScope` (for Activities) and your future ViewModel will provide `viewModelScope`.
## 🏋️ Exercise
1. Add `kotlinx-coroutines-android` to your dependencies (it may already be transitive).
2. In `MainActivity.kt`, use `lifecycleScope.launch` to simulate a delayed greeting.
3. Use `withContext(Dispatchers.Default)` to do a "heavy computation" (e.g., sorting a large list).
## 📎 Resources
- [Coroutines Guide — Kotlin Docs](https://kotlinlang.org/docs/coroutines-guide.html)
- [Coroutines on Android — Android Developers](https://developer.android.com/kotlin/coroutines)
- [suspend Functions — Kotlin Docs](https://kotlinlang.org/docs/composing-suspending-functions.html)
---
⬅️ Previous: [Delegation](02-delegation.md) | ➡️ Next: [Coroutines Advanced](04-coroutines-advanced.md)
