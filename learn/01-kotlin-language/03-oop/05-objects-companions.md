# Lesson 01.03.05 — Objects & Companion Objects
> **Difficulty:** 🟡 Intermediate | **Time:** 25 min | **Prerequisites:** [01-classes-constructors.md](01-classes-constructors.md)
---
## 📚 Theory
### `object` Declaration — Singleton
```kotlin
object AppConfig {
    const val APP_NAME = "WagwanWorld"
    var isDebug = true
    fun getBaseUrl() = if (isDebug) "https://dev.api.com" else "https://api.com"
}
// Usage — no instantiation needed:
AppConfig.APP_NAME
AppConfig.getBaseUrl()
```
### `companion object` — Static-like Members
```kotlin
class User(val name: String) {
    companion object {
        const val MAX_NAME_LENGTH = 50
        fun create(name: String): User {
            require(name.length <= MAX_NAME_LENGTH)
            return User(name)
        }
    }
}
// Usage:
User.MAX_NAME_LENGTH
User.create("Alice")
```
### `object` Expression — Anonymous Objects
```kotlin
val comparator = object : Comparator<String> {
    override fun compare(a: String, b: String) = a.length - b.length
}
```
## 🏋️ Exercise
1. Create an `object Analytics` singleton for tracking events.
2. Add a `companion object` to your `Post` data class with a `fun sample(): Post` factory method.
3. Think: When to use `object` vs `companion object` vs top-level function?
## 📎 Resources
- [Object Declarations — Kotlin Docs](https://kotlinlang.org/docs/object-declarations.html)
---
⬅️ Previous: [Sealed Classes](04-sealed-classes-enums.md) | ➡️ Next: [OOP Exercise](06-exercise-oop.md)
