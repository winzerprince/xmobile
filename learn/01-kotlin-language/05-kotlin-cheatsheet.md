# Kotlin Cheatsheet
> Quick reference for everything in Module 01. Bookmark this!
## Variables
```kotlin
val x = 10          // Immutable (prefer)
var y = 10          // Mutable
const val Z = 10    // Compile-time constant
```
## Null Safety
```kotlin
val a: String? = null   // Nullable
a?.length               // Safe call → null
a?.length ?: 0          // Elvis → 0
a!!.length              // Force (avoid!) → crash if null
a?.let { use(it) }      // Execute block if non-null
```
## Control Flow
```kotlin
val r = if (x > 0) "pos" else "neg"   // Expression
val g = when(x) { 1 -> "one"; else -> "other" }
for (i in 1..10) { }     // Range inclusive
for (i in 0 until n) { } // Range exclusive
```
## Functions
```kotlin
fun f(x: Int, y: Int = 0): Int = x + y   // Default params
f(1, y = 2)                                // Named args
val lambda = { x: Int -> x * 2 }          // Lambda
list.filter { it > 3 }                     // Trailing lambda
fun String.exclaim() = "$this!"            // Extension function
```
## Scope Functions
```kotlin
obj.let { it.doSomething() }      // Transform, null check
obj.apply { prop = value }        // Configure, returns obj
obj.run { compute() }             // Configure + result
obj.also { log(it) }              // Side effect, returns obj
with(obj) { doStuff() }           // Group calls
```
## Classes
```kotlin
data class User(val name: String)        // Auto: equals, hashCode, toString, copy
sealed class State { object Loading; data class Ok(val d: Any) : State() }
enum class Dir { N, S, E, W }
object Singleton { val x = 1 }           // Singleton
class C { companion object { fun f() {} } }  // "Static"
```
## Coroutines
```kotlin
suspend fun fetch(): Data               // Suspending function
scope.launch { }                         // Fire & forget
scope.async { }.await()                  // Returns result
withContext(Dispatchers.IO) { }          // Switch thread
```
## Flow
```kotlin
flow { emit(1); emit(2) }               // Cold stream
MutableStateFlow(initialValue)           // Hot state holder
flow.map { }.filter { }.collect { }     // Operators
stateFlow.collectAsState()               // In Compose
```
---
⬅️ Module: [01 — Kotlin Language](./) | ➡️ Next Module: [02 — Jetpack Compose](../02-jetpack-compose/)
