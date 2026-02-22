# Lesson 01.04.02 — Delegation
> **Difficulty:** 🟡 Intermediate | **Time:** 25 min | **Prerequisites:** [01-generics.md](01-generics.md)
---
## 📚 Theory
### Class Delegation — Composition over Inheritance
```kotlin
interface Logger { fun log(msg: String) }
class ConsoleLogger : Logger { override fun log(msg: String) = println(msg) }
// Instead of inheriting, DELEGATE:
class App(logger: Logger) : Logger by logger {
    fun run() { log("App started") }  // Delegates to the logger instance
}
```
### Property Delegation
```kotlin
// lazy — computed only on first access:
val expensiveData: List<String> by lazy {
    println("Computing...")
    loadFromDatabase()
}
// observable — react to changes:
var name: String by Delegates.observable("Initial") { prop, old, new ->
    println("Changed from $old to $new")
}
// map — store properties in a map:
class Config(map: Map<String, Any?>) {
    val name: String by map
    val version: Int by map
}
val config = Config(mapOf("name" to "WagwanWorld", "version" to 1))
```
### In Compose — `by remember` IS Delegation!
```kotlin
var message by remember { mutableStateOf("Hello!") }
// "by" delegates get/set to the MutableState object
// Without "by": val message = remember { mutableStateOf("Hello!") }
//               message.value = "New"  // Need .value!
```
## 🏋️ Exercise
1. Use `by lazy` to lazily initialize sample data in your app.
2. Create a `Loggable` interface and use class delegation to add logging to any class.
## 📎 Resources
- [Delegation — Kotlin Docs](https://kotlinlang.org/docs/delegation.html)
- [Delegated Properties — Kotlin Docs](https://kotlinlang.org/docs/delegated-properties.html)
---
⬅️ Previous: [Generics](01-generics.md) | ➡️ Next: [Coroutines Basics](03-coroutines-basics.md)
