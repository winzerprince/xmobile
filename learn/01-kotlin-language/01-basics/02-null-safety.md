# Lesson 01.01.02 — Null Safety
> **Difficulty:** 🟢 Beginner | **Time:** 35–45 min | **Prerequisites:** [01-variables-types.md](01-variables-types.md)
---
## 🧠 Why This Matters
`NullPointerException` (NPE) is the **#1 crash** in Java programs. Kotlin was designed to **eliminate** it at compile time. This is one of Kotlin's killer features.
## 📚 Theory
### The Billion Dollar Mistake
In Java, any variable can be `null`:
```java
String name = null;       // Java: totally fine
name.length();            // 💥 CRASH: NullPointerException at RUNTIME
```
In Kotlin, variables are **non-null by default**:
```kotlin
var name: String = "Wagwan"  // Cannot be null — guaranteed!
name = null                   // ❌ COMPILE ERROR — caught before your app ever runs
```
### Nullable Types (The `?` Operator)
If you NEED a variable to potentially be null, add `?`:
```kotlin
var name: String? = "Wagwan"  // The ? means "this CAN be null"
name = null                    // ✅ OK now
// But you can't use it freely:
name.length  // ❌ ERROR — name might be null!
```
### Safe Call Operator `?.`
```kotlin
val name: String? = getUserName()  // Might return null
// Safe call — returns null instead of crashing
val length: Int? = name?.length   // If name is null → length is null
                                   // If name is "Wagwan" → length is 6
```
### Elvis Operator `?:`
```kotlin
// Provide a default when something is null
val length = name?.length ?: 0     // If name is null → use 0
val displayName = name ?: "Anonymous"  // If name is null → use "Anonymous"
```
### Not-Null Assertion `!!`
```kotlin
val length = name!!.length  // "I GUARANTEE this is not null"
                             // If it IS null → 💥 CRASH (NPE)
                             // ⚠️ AVOID THIS — defeats the purpose of null safety
```
### Smart Casting
```kotlin
val name: String? = "Wagwan"
if (name != null) {
    // Kotlin KNOWS name is not null inside this block
    println(name.length)  // ✅ No ?. needed — Kotlin "smart casts" it
}
```
### Safe Calls Chain
```kotlin
// Old Java way:
// if (user != null && user.address != null && user.address.city != null) { ... }
// Kotlin:
val city = user?.address?.city ?: "Unknown"
// If ANY part is null, the whole chain returns null, then Elvis gives default
```
### `let` with Null Safety
```kotlin
val name: String? = getUserName()
name?.let { safeName ->       // Only executes if name is NOT null
    println("Name: $safeName")
    println("Length: ${safeName.length}")
}
// If name is null, the entire let block is skipped
```
## 🔍 In Your Project
In `MainActivity.kt`:
```kotlin
override fun onCreate(savedInstanceState: Bundle?) {
//                                        ↑ Bundle? — can be null!
// savedInstanceState is null on first launch, non-null on recreation (e.g., screen rotation)
    super.onCreate(savedInstanceState)
```
## 🏋️ Exercise
1. In `MainActivity.kt`, add this above `HelloScreen()` call:
   ```kotlin
   val userName: String? = null
   // Try to call userName.length — see the compile error
   // Fix it using: (a) safe call, (b) Elvis, (c) smart cast
   ```
2. Create a function in a new file:
   ```kotlin
   fun greetUser(name: String?): String {
       // Return "Hello, [name]!" if name is not null
       // Return "Hello, stranger!" if name is null
       // Use the Elvis operator
   }
   ```
3. **Thought question:** Why is `!!` considered bad practice? When (if ever) would you use it?
<details>
<summary>💡 Answer</summary>
`!!` is bad because it reintroduces the very crash Kotlin was designed to prevent. Use it ONLY when you're 100% certain a value is non-null but the compiler can't prove it (rare). Better alternatives: `?.`, `?:`, `let`, `require()`, `checkNotNull()`.
</details>
## 📎 Resources
- [Null Safety — Kotlin Docs](https://kotlinlang.org/docs/null-safety.html)
- [Idiomatic Kotlin: Null Safety](https://kotlinlang.org/docs/idioms.html#nullable-value)
---
⬅️ Previous: [Variables & Types](01-variables-types.md) | ➡️ Next: [Control Flow](03-control-flow.md)
