# Lesson 01.02.03 — Extension Functions & Scope Functions
> **Difficulty:** 🟡 Intermediate | **Time:** 35 min | **Prerequisites:** [02-lambdas-higher-order.md](02-lambdas-higher-order.md)
---
## 📚 Theory
### Extension Functions — Add Methods to Existing Classes
```kotlin
// Add a function to String without modifying the String class!
fun String.addExclamation() = "$this!"
"Hello".addExclamation()  // "Hello!"
// Add a function to Int:
fun Int.isEven() = this % 2 == 0
42.isEven()  // true
```
### Scope Functions — `let`, `apply`, `run`, `with`, `also`
| Function | Object ref | Return value | Use case |
|----------|-----------|-------------|----------|
| `let` | `it` | Lambda result | Null checks, transformations |
| `apply` | `this` | Object itself | Object configuration |
| `run` | `this` | Lambda result | Object config + compute result |
| `with` | `this` | Lambda result | Grouping calls on an object |
| `also` | `it` | Object itself | Side effects (logging) |
```kotlin
// let — great with null safety:
val name: String? = "Wagwan"
name?.let { println("Name is $it") }
// apply — configure an object:
val intent = Intent().apply {
    action = "com.example.ACTION"
    putExtra("key", "value")
}
// also — side effects (debugging):
val users = fetchUsers().also { println("Fetched ${it.size} users") }
```
### Modifier Chain Is Extension Functions!
```kotlin
Modifier
    .fillMaxSize()      // Extension function on Modifier
    .padding(24.dp)     // Extension function on Modifier
    .background(Color.Red) // Extension function on Modifier
```
## 🏋️ Exercise
1. Create extension functions: `String.toTitleCase()`, `Int.toDp()`, `List<String>.joinWithCommas()`.
2. Refactor any object creation in your code to use `apply`.
3. Use `also` to add debug logging somewhere in `MainActivity.kt`.
## 📎 Resources
- [Extension Functions — Kotlin Docs](https://kotlinlang.org/docs/extensions.html)
- [Scope Functions — Kotlin Docs](https://kotlinlang.org/docs/scope-functions.html)
---
⬅️ Previous: [Lambdas](02-lambdas-higher-order.md) | ➡️ Next: [Exercise: Functions](04-exercise-functions.md)
