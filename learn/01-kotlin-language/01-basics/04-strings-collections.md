# Lesson 01.01.04 — Strings & Collections
> **Difficulty:** 🟢 Beginner | **Time:** 35 min | **Prerequisites:** [03-control-flow.md](03-control-flow.md)
---
## 📚 Theory
### String Templates
```kotlin
val name = "WagwanWorld"
val version = 1
// String templates with $:
println("App: $name")              // → "App: WagwanWorld"
println("Version: ${version + 1}") // → "Version: 2" (use {} for expressions)
// Multi-line strings:
val json = """
    {
        "app": "$name",
        "version": $version
    }
""".trimIndent()
```
### Collections — Lists, Sets, Maps
```kotlin
// IMMUTABLE (read-only) — PREFER THESE
val names = listOf("Alice", "Bob", "Charlie")    // List (ordered, duplicates OK)
val ids = setOf(1, 2, 3)                          // Set (no duplicates)
val users = mapOf("id1" to "Alice", "id2" to "Bob") // Map (key-value pairs)
// MUTABLE (can add/remove)
val mutableNames = mutableListOf("Alice")
mutableNames.add("Bob")
mutableNames.removeAt(0)
val mutableMap = mutableMapOf<String, Int>()
mutableMap["score"] = 100
```
### Collection Operations (Functional Style)
```kotlin
val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
numbers.filter { it % 2 == 0 }     // [2, 4, 6, 8, 10]
numbers.map { it * 2 }             // [2, 4, 6, 8, 10, 12, 14, 16, 18, 20]
numbers.first { it > 5 }           // 6
numbers.any { it > 9 }             // true
numbers.sum()                       // 55
numbers.sorted()                    // Already sorted
numbers.take(3)                     // [1, 2, 3]
numbers.groupBy { if (it % 2 == 0) "even" else "odd" }
// {odd=[1, 3, 5, 7, 9], even=[2, 4, 6, 8, 10]}
```
### Destructuring
```kotlin
val (first, second, third) = listOf("A", "B", "C")
val (key, value) = Pair("name", "WagwanWorld")
for ((index, item) in names.withIndex()) {
    println("$index: $item")
}
```
## 🏋️ Exercise
1. Create a `listOf` with 5 city names. Use `.filter`, `.map`, `.sorted()` to: get cities starting with "K", convert to uppercase, and sort.
2. Create a `mapOf` representing your app's config (name, version, minSdk). Iterate with a `for` loop.
3. Use string templates to print a formatted "About" section for WagwanWorld using data from your map.
## 📎 Resources
- [Strings — Kotlin Docs](https://kotlinlang.org/docs/strings.html)
- [Collections Overview — Kotlin Docs](https://kotlinlang.org/docs/collections-overview.html)
- [Collection Operations — Kotlin Docs](https://kotlinlang.org/docs/collection-operations.html)
---
⬅️ Previous: [Control Flow](03-control-flow.md) | ➡️ Next: [Exercise: Basics](05-exercise-basics.md)
