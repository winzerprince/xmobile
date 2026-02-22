# Lesson 01.03.02 — Inheritance & Interfaces
> **Difficulty:** 🟡 Intermediate | **Time:** 30 min | **Prerequisites:** [01-classes-constructors.md](01-classes-constructors.md)
---
## 📚 Theory
### Inheritance (Classes are `final` by default!)
```kotlin
open class Animal(val name: String) {    // "open" = can be inherited
    open fun sound() = "..."              // "open" = can be overridden
}
class Dog(name: String) : Animal(name) {
    override fun sound() = "Woof!"        // MUST use "override"
}
```
### Interfaces
```kotlin
interface Clickable {
    fun onClick()                         // Abstract — must implement
    fun description() = "Clickable item"  // Default implementation — optional to override
}
interface Draggable {
    fun onDrag()
}
// A class can implement MULTIPLE interfaces:
class Button : Clickable, Draggable {
    override fun onClick() { println("Clicked!") }
    override fun onDrag() { println("Dragged!") }
}
```
### Abstract Classes
```kotlin
abstract class Screen {
    abstract fun render()      // Must be implemented
    fun navigate() { }        // Concrete — inherited as-is
}
```
### In Compose Context
```kotlin
// ComponentActivity is an open class you extend:
class MainActivity : ComponentActivity() { // Inheritance
    override fun onCreate(savedInstanceState: Bundle?) { // Override
        super.onCreate(savedInstanceState) // Call parent
    }
}
```
## 🏋️ Exercise
1. Create an interface `Displayable` with `fun display(): String`.
2. Create `Post` and `Comment` classes implementing `Displayable`.
3. Create a function `fun renderAll(items: List<Displayable>)` that works with both.
4. Think: When to use interface vs abstract class vs open class?
## 📎 Resources
- [Inheritance — Kotlin Docs](https://kotlinlang.org/docs/inheritance.html)
- [Interfaces — Kotlin Docs](https://kotlinlang.org/docs/interfaces.html)
---
⬅️ Previous: [Classes](01-classes-constructors.md) | ➡️ Next: [Data Classes](03-data-classes.md)
