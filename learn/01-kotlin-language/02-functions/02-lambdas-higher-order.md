# Lesson 01.02.02 — Lambdas & Higher-Order Functions
> **Difficulty:** 🟡 Intermediate | **Time:** 40 min | **Prerequisites:** [01-functions-parameters.md](01-functions-parameters.md)
---
## 🧠 Why This Matters
Compose is BUILT on lambdas. `Button(onClick = { })`, `Column { }`, `remember { }` — these are ALL lambdas. You must understand them.
## 📚 Theory
### Lambda = Anonymous Function
```kotlin
// Regular function:
fun double(x: Int): Int = x * 2
// Lambda (same thing, but anonymous):
val double = { x: Int -> x * 2 }
val result = double(5)  // 10
// Lambda syntax: { parameters -> body }
val greet = { name: String -> "Hello, $name!" }
```
### Higher-Order Functions = Functions That Take Functions
```kotlin
fun operateOnNumber(x: Int, operation: (Int) -> Int): Int {
    return operation(x)
}
operateOnNumber(5, { it * 2 })  // 10
operateOnNumber(5) { it * 2 }   // 10 — trailing lambda syntax!
operateOnNumber(5) { it + 3 }   // 8
```
### `it` — Implicit Single Parameter
```kotlin
listOf(1, 2, 3).map { it * 2 }    // "it" = each element
listOf("a", "bb").filter { it.length > 1 }
```
### Trailing Lambda Syntax
When the last parameter is a lambda, you can move it outside the parentheses:
```kotlin
// These are identical:
Button(onClick = { doSomething() })
Button(onClick = { doSomething() })  // Only param — no change needed
// Compose uses this everywhere:
Column(modifier = Modifier.padding(16.dp)) {  // ← trailing lambda = content
    Text("Hello")
    Text("World")
}
```
### Function References
```kotlin
fun isEven(n: Int) = n % 2 == 0
listOf(1, 2, 3, 4).filter(::isEven)  // [2, 4] — :: creates a function reference
```
## 🔍 In Your Project
```kotlin
Button(onClick = {                        // ← onClick is a lambda: () -> Unit
    message = if (message == "Hello from Kampala!") {
        "Kotlin + Compose is awesome! 🚀"
    } else {
        "Hello from Kampala!"
    }
}) {
    Text("Change Message")                 // ← This is also a lambda: @Composable () -> Unit
}
```
## 🏋️ Exercise
1. Create a higher-order function `fun <T> List<T>.customFilter(predicate: (T) -> Boolean): List<T>` that reimplements `filter`.
2. Create a function that takes a `transform: (String) -> String` parameter and applies it to the WagwanWorld greeting.
3. Identify all lambdas in your `MainActivity.kt` — how many are there?
## 📎 Resources
- [Lambdas — Kotlin Docs](https://kotlinlang.org/docs/lambdas.html)
- [Higher-Order Functions — Kotlin Docs](https://kotlinlang.org/docs/lambdas.html#higher-order-functions)
---
⬅️ Previous: [Functions & Parameters](01-functions-parameters.md) | ➡️ Next: [Extension Functions](03-extension-functions.md)
