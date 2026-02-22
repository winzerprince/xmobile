# Lesson 01.04.06 — DSL Builders
> **Difficulty:** 🔴 Advanced | **Time:** 30 min | **Prerequisites:** [Lambdas](../02-functions/02-lambdas-higher-order.md), [Extension Functions](../02-functions/03-extension-functions.md)
---
## 🧠 Why This Matters
Compose IS a DSL. `Column { Text("Hello") }` is a Domain-Specific Language built with Kotlin's builder pattern. Understanding DSLs helps you read Compose code and build your own.
## 📚 Theory
### What's a DSL?
A Domain-Specific Language — code that reads like a mini-language for a specific purpose:
```kotlin
// Compose UI is a DSL:
Column {
    Text("Hello")
    Button(onClick = { }) { Text("Click") }
}
// Gradle build files are a DSL:
dependencies {
    implementation(libs.core.ktx)
}
// Ktor routing is a DSL:
routing {
    get("/users") { call.respond(users) }
}
```
### How DSLs Work — Lambda with Receiver
```kotlin
// The magic ingredient: lambda with receiver (T.() -> Unit)
fun buildString(action: StringBuilder.() -> Unit): String {
    val sb = StringBuilder()
    sb.action()  // "action" runs with "sb" as "this"
    return sb.toString()
}
val result = buildString {
    append("Hello, ")  // "this" is the StringBuilder
    append("World!")
}
// result = "Hello, World!"
```
### Building a Mini DSL
```kotlin
class HtmlBuilder {
    private val elements = mutableListOf<String>()
    fun h1(text: String) { elements.add("<h1>$text</h1>") }
    fun p(text: String) { elements.add("<p>$text</p>") }
    fun build() = elements.joinToString("\n")
}
fun html(init: HtmlBuilder.() -> Unit): String {
    return HtmlBuilder().apply(init).build()
}
// Usage — looks like HTML!
val page = html {
    h1("WagwanWorld")
    p("Welcome to the app!")
}
```
### @DslMarker — Preventing Scope Leaking
```kotlin
@DslMarker
annotation class HtmlDsl
@HtmlDsl
class TableBuilder { ... }
@HtmlDsl
class RowBuilder { ... }
// Now you can't accidentally call TableBuilder methods inside RowBuilder
```
## 🏋️ Exercise
1. Study Compose's `Column { }` — it uses `@Composable ColumnScope.() -> Unit` (lambda with receiver!).
2. Build a mini DSL for creating `Post` objects: `post { title("Hello") author("Alice") body("...") }`.
3. Identify 3 DSLs you've already used in your project (hint: Gradle, Compose, Modifier).
## 📎 Resources
- [Type-Safe Builders — Kotlin Docs](https://kotlinlang.org/docs/type-safe-builders.html)
- [Lambda with Receiver — Kotlin Docs](https://kotlinlang.org/docs/lambdas.html#function-literals-with-receiver)
---
⬅️ Previous: [Flow](05-flow.md) | ➡️ Next: [Exercise: Coroutines & Flow](07-exercise-coroutines-flow.md)
