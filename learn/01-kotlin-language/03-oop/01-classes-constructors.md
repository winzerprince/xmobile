# Lesson 01.03.01 — Classes & Constructors
> **Difficulty:** 🟢 Beginner | **Time:** 30 min | **Prerequisites:** [Functions](../02-functions/)
---
## 📚 Theory
### Basic Class
```kotlin
class User(val name: String, var age: Int) {  // Primary constructor with properties
    // Properties declared in constructor — no boilerplate!
    // init block runs when object is created:
    init {
        require(age >= 0) { "Age must be non-negative" }
    }
    // Member functions:
    fun greet() = "Hi, I'm $name and I'm $age years old"
    // Secondary constructor:
    constructor(name: String) : this(name, 0)  // Delegates to primary
}
val user = User("Alice", 25)
println(user.name)    // "Alice" — direct property access (no getters needed!)
println(user.greet()) // "Hi, I'm Alice and I'm 25 years old"
```
### `val` vs `var` in Constructors
```kotlin
class Point(val x: Int, val y: Int)     // Both read-only
class MutablePoint(var x: Int, var y: Int) // Both mutable
class Config(
    val name: String,        // Public read-only
    private val apiKey: String,  // Private — not accessible outside
    var isDebug: Boolean = false  // Public mutable with default
)
```
### Visibility Modifiers
| Modifier | Visible to |
|----------|-----------|
| `public` (default) | Everything |
| `private` | Same class only |
| `protected` | Same class + subclasses |
| `internal` | Same module |
### Properties with Custom Getters/Setters
```kotlin
class Temperature(celsius: Double) {
    var celsius = celsius
        set(value) {
            require(value >= -273.15) { "Below absolute zero!" }
            field = value  // "field" is the backing field
        }
    val fahrenheit: Double        // Computed property — no backing field
        get() = celsius * 9/5 + 32
}
```
## 🏋️ Exercise
1. Create a `UserProfile` class with: `name`, `email`, `bio` (nullable with default null), `joinDate`.
2. Add a computed property `displayName` that returns the name or email if name is blank.
3. Add an `init` block that validates email contains `@`.
4. Create instances and use them.
## 📎 Resources
- [Classes — Kotlin Docs](https://kotlinlang.org/docs/classes.html)
- [Properties — Kotlin Docs](https://kotlinlang.org/docs/properties.html)
---
⬅️ Previous: [Functions Exercise](../02-functions/04-exercise-functions.md) | ➡️ Next: [Inheritance & Interfaces](02-inheritance-interfaces.md)
