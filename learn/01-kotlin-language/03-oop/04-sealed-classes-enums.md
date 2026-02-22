# Lesson 01.03.04 — Sealed Classes & Enums
> **Difficulty:** 🟡 Intermediate | **Time:** 30 min | **Prerequisites:** [03-data-classes.md](03-data-classes.md)
---
## 📚 Theory
### Enum Classes
```kotlin
enum class Priority { LOW, MEDIUM, HIGH, CRITICAL }
enum class HttpStatus(val code: Int) {
    OK(200), NOT_FOUND(404), ERROR(500);
    fun isSuccess() = code in 200..299
}
```
### Sealed Classes — The Star of Android Development
```kotlin
sealed class Result<out T> {
    data class Success<T>(val data: T) : Result<T>()
    data class Error(val message: String, val cause: Throwable? = null) : Result<Nothing>()
    object Loading : Result<Nothing>()
}
// Compiler ensures you handle ALL cases:
fun handleResult(result: Result<String>) = when (result) {
    is Result.Success -> showData(result.data)     // Smart cast!
    is Result.Error -> showError(result.message)   // Smart cast!
    Result.Loading -> showSpinner()
    // No "else" needed — sealed = all subtypes known at compile time
}
```
### Why Sealed Classes Are Essential
They model **state** perfectly for UI:
```kotlin
sealed class ScreenState {
    object Loading : ScreenState()
    data class Content(val items: List<String>) : ScreenState()
    data class Error(val message: String) : ScreenState()
}
// Your ViewModel emits these → your UI handles each case
```
### Sealed Interface (Kotlin 1.5+)
```kotlin
sealed interface UiEvent {
    data class ShowToast(val message: String) : UiEvent
    data class Navigate(val route: String) : UiEvent
    object GoBack : UiEvent
}
```
## 🏋️ Exercise
1. Create a `sealed class NetworkResult<out T>` with Success, Error, and Loading.
2. Write a `when` expression that handles all cases — notice the compiler enforces exhaustiveness.
3. Create an enum `Screen` with HOME, PROFILE, SETTINGS — you'll use this for navigation later.
## 📎 Resources
- [Sealed Classes — Kotlin Docs](https://kotlinlang.org/docs/sealed-classes.html)
- [Enum Classes — Kotlin Docs](https://kotlinlang.org/docs/enum-classes.html)
---
⬅️ Previous: [Data Classes](03-data-classes.md) | ➡️ Next: [Objects & Companions](05-objects-companions.md)
