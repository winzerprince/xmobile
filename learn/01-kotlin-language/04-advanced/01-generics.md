# Lesson 01.04.01 — Generics
> **Difficulty:** 🟡 Intermediate | **Time:** 35 min | **Prerequisites:** [OOP](../03-oop/)
---
## 📚 Theory
### Why Generics?
Without generics: `List` holds `Any` → you'd need to cast everything. With generics: `List<String>` → type-safe at compile time.
### Generic Functions & Classes
```kotlin
fun <T> singletonList(item: T): List<T> = listOf(item)
class Box<T>(val value: T) {
    fun map<R>(transform: (T) -> R): Box<R> = Box(transform(value))
}
```
### Variance: `in` and `out`
```kotlin
// out = PRODUCER (covariant) — can only return T, not accept T
interface Source<out T> { fun next(): T }
// List<Dog> IS a List<Animal> ✅
// in = CONSUMER (contravariant) — can only accept T, not return T
interface Sink<in T> { fun put(item: T) }
// Sink<Animal> IS a Sink<Dog> ✅
```
### `reified` — Preserving Type at Runtime
```kotlin
inline fun <reified T> isType(value: Any): Boolean = value is T
// Without "reified", `T` is erased at runtime and `is T` wouldn't work
```
### Where Clauses (Constraints)
```kotlin
fun <T : Comparable<T>> sort(list: List<T>) { }  // T must be Comparable
fun <T> process(item: T) where T : Serializable, T : Comparable<T> { }
```
## 🏋️ Exercise
1. Create a generic `Result<T>` wrapper class with `map()` and `flatMap()` functions.
2. Create a generic `Repository<T>` interface with `getAll(): List<T>` and `getById(id: String): T?`.
## 📎 Resources
- [Generics — Kotlin Docs](https://kotlinlang.org/docs/generics.html)
---
⬅️ Previous: [OOP Exercise](../03-oop/06-exercise-oop.md) | ➡️ Next: [Delegation](02-delegation.md)
