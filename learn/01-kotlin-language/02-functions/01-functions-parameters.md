# Lesson 01.02.01 — Functions & Parameters
> **Difficulty:** 🟢 Beginner | **Time:** 30 min | **Prerequisites:** [Basics](../01-basics/)
---
## 📚 Theory
### Function Syntax
```kotlin
fun greet(name: String, greeting: String = "Hello"): String {
    return "$greeting, $name!"
}
// Single-expression function (shorthand):
fun greet(name: String) = "Hello, $name!"
// Unit return type (void equivalent — can be omitted):
fun log(message: String): Unit { println(message) }
fun log(message: String) { println(message) }  // Same thing
```
### Named Arguments
```kotlin
fun createUser(name: String, age: Int, city: String = "Kampala") = "$name ($age) from $city"
// Positional:
createUser("Alice", 25, "Nairobi")
// Named (more readable, especially with many parameters):
createUser(name = "Alice", age = 25, city = "Nairobi")
// Named lets you skip default params:
createUser(name = "Bob", age = 30)  // city defaults to "Kampala"
```
### Vararg — Variable Number of Arguments
```kotlin
fun printAll(vararg messages: String) {
    for (msg in messages) println(msg)
}
printAll("Hello", "World", "Wagwan")
// Spread operator (*) to pass an array as vararg:
val words = arrayOf("Hello", "World")
printAll(*words)
```
## 🔍 In Your Project
```kotlin
// Compose functions use named arguments HEAVILY:
Column(
    modifier = Modifier.fillMaxSize(),        // named arg
    horizontalAlignment = Alignment.CenterHorizontally,  // named arg
    verticalArrangement = Arrangement.Center   // named arg
)
```
## 🏋️ Exercise
1. Create a function `fun buildWelcomeMessage(name: String, emoji: String = "👋", repeat: Int = 1): String` that returns the greeting repeated N times.
2. Call it using: (a) positional args, (b) named args, (c) skipping defaults.
3. Refactor `HelloScreen()` to extract the message logic into a separate function.
## 📎 Resources
- [Functions — Kotlin Docs](https://kotlinlang.org/docs/functions.html)
---
⬅️ Previous: [Basics Exercise](../01-basics/05-exercise-basics.md) | ➡️ Next: [Lambdas & Higher-Order Functions](02-lambdas-higher-order.md)
