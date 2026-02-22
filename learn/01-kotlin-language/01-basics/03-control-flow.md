# Lesson 01.01.03 — Control Flow
> **Difficulty:** 🟢 Beginner | **Time:** 30 min | **Prerequisites:** [02-null-safety.md](02-null-safety.md)
---
## 📚 Theory
### `if` as an Expression (Not Just a Statement!)
In Java, `if` is a statement. In Kotlin, it **returns a value**:
```kotlin
// Java way:
var result: String
if (score > 90) { result = "A" } else { result = "B" }
// Kotlin way — if IS an expression:
val result = if (score > 90) "A" else "B"
```
### `when` — Kotlin's Super-Powered Switch
```kotlin
val grade = when (score) {
    in 90..100 -> "A"
    in 80..89  -> "B"
    in 70..79  -> "C"
    in 60..69  -> "D"
    else       -> "F"
}
// when with no argument (replaces if-else chains):
val description = when {
    temperature > 35 -> "Hot 🔥"
    temperature > 20 -> "Nice 😎"
    else             -> "Cold 🥶"
}
```
### `when` with Sealed Classes (Preview — You'll Master This Later)
```kotlin
sealed class Result {
    data class Success(val data: String) : Result()
    data class Error(val message: String) : Result()
    object Loading : Result()
}
// The compiler forces you to handle ALL cases:
when (result) {
    is Result.Success -> showData(result.data)
    is Result.Error -> showError(result.message)
    Result.Loading -> showSpinner()
    // No "else" needed — all cases covered!
}
```
### Ranges & Loops
```kotlin
for (i in 1..10) { }        // 1, 2, 3, ..., 10 (inclusive)
for (i in 1 until 10) { }   // 1, 2, 3, ..., 9 (exclusive end)
for (i in 10 downTo 1) { }  // 10, 9, 8, ..., 1
for (i in 0..100 step 10) { } // 0, 10, 20, ..., 100
// while / do-while — same as Java
while (condition) { }
do { } while (condition)
```
## 🔍 In Your Project
In `MainActivity.kt`:
```kotlin
message = if (message == "Hello from Kampala!") {  // if as expression!
    "Kotlin + Compose is awesome! 🚀"
} else {
    "Hello from Kampala!"
}
```
## 🏋️ Exercise
1. Replace the `if/else` in `HelloScreen()`'s button click with a `when` expression that cycles through 3 messages.
2. Create a function `fun getGreeting(hour: Int): String` that uses `when` to return "Good morning", "Good afternoon", or "Good evening" based on the hour.
3. Write a `for` loop that prints the first 10 Fibonacci numbers using `repeat(10)` or a range.
## 📎 Resources
- [Control Flow — Kotlin Docs](https://kotlinlang.org/docs/control-flow.html)
- [Ranges — Kotlin Docs](https://kotlinlang.org/docs/ranges.html)
---
⬅️ Previous: [Null Safety](02-null-safety.md) | ➡️ Next: [Strings & Collections](04-strings-collections.md)
