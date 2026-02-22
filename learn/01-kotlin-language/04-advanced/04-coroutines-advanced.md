# Lesson 01.04.04 — Coroutines Advanced
> **Difficulty:** 🔴 Advanced | **Time:** 40 min | **Prerequisites:** [03-coroutines-basics.md](03-coroutines-basics.md)
---
## 📚 Theory
### Structured Concurrency & SupervisorJob
```kotlin
// If one child fails, ALL siblings are cancelled:
coroutineScope {
    launch { fetchUser() }    // If this fails →
    launch { fetchPosts() }   // ← this is cancelled too
}
// SupervisorJob: children are independent:
supervisorScope {
    launch { fetchUser() }    // If this fails →
    launch { fetchPosts() }   // ← this keeps running
}
```
### Exception Handling
```kotlin
viewModelScope.launch {
    try {
        val data = fetchData()
    } catch (e: IOException) {
        showError("Network error: ${e.message}")
    }
}
// Or with CoroutineExceptionHandler:
val handler = CoroutineExceptionHandler { _, exception ->
    Log.e("TAG", "Caught: $exception")
}
viewModelScope.launch(handler) { fetchData() }
```
### Cancellation
```kotlin
val job = viewModelScope.launch {
    repeat(1000) { i ->
        ensureActive()  // Check if cancelled — throws CancellationException
        delay(100)      // Also checks cancellation automatically
        println("Working $i")
    }
}
job.cancel()  // Cancel the coroutine
// isActive check in loops:
while (isActive) { doWork() }
```
### Parallel Decomposition
```kotlin
coroutineScope {
    val user = async { fetchUser() }
    val posts = async { fetchPosts() }
    // Both run in PARALLEL:
    displayProfile(user.await(), posts.await())
}
```
## 🏋️ Exercise
1. Create two suspend functions that simulate network calls with `delay()`.
2. Run them in parallel using `async` and measure the time difference vs sequential.
3. Implement proper error handling with try/catch in a coroutine.
## 📎 Resources
- [Structured Concurrency — Kotlin Docs](https://kotlinlang.org/docs/coroutines-basics.html#structured-concurrency)
- [Cancellation — Kotlin Docs](https://kotlinlang.org/docs/cancellation-and-timeouts.html)
- [Exception Handling — Kotlin Docs](https://kotlinlang.org/docs/exception-handling.html)
---
⬅️ Previous: [Coroutines Basics](03-coroutines-basics.md) | ➡️ Next: [Flow](05-flow.md)
