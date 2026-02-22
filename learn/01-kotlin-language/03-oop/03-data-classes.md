# Lesson 01.03.03 — Data Classes
> **Difficulty:** 🟢 Beginner | **Time:** 20 min | **Prerequisites:** [01-classes-constructors.md](01-classes-constructors.md)
---
## 📚 Theory
### The Problem
In Java, a simple "hold some data" class needs: constructor, getters, setters, equals(), hashCode(), toString(), copy(). That's ~50 lines for 3 fields.
### `data class` — Kotlin's Solution
```kotlin
data class User(val name: String, val age: Int, val email: String)
// That's it! Kotlin auto-generates: equals(), hashCode(), toString(), copy(), componentN()
```
### Auto-Generated Methods
```kotlin
val user = User("Alice", 25, "alice@mail.com")
println(user)           // "User(name=Alice, age=25, email=alice@mail.com)" — toString()
user == User("Alice", 25, "alice@mail.com")  // true — equals() compares all fields
user.copy(age = 26)     // User(name=Alice, age=26, email=alice@mail.com) — immutable update!
val (name, age, email) = user  // Destructuring — componentN() functions
```
### Why This Matters for Android
Data classes are EVERYWHERE:
- API response models
- UI state holders
- Database entities (Room)
- Navigation arguments
```kotlin
// Your future code will be full of these:
data class UiState(
    val isLoading: Boolean = false,
    val posts: List<Post> = emptyList(),
    val error: String? = null
)
```
## 🏋️ Exercise
1. Create `data class Post(val id: Int, val title: String, val body: String, val author: String)`.
2. Create two identical posts — verify `==` returns true.
3. Use `.copy()` to create a modified version.
4. Destructure a Post and print each component.
## 📎 Resources
- [Data Classes — Kotlin Docs](https://kotlinlang.org/docs/data-classes.html)
---
⬅️ Previous: [Inheritance](02-inheritance-interfaces.md) | ➡️ Next: [Sealed Classes & Enums](04-sealed-classes-enums.md)
