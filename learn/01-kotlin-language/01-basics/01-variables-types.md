# Lesson 01.01.01 — Variables & Types

> **Difficulty:** 🟢 Beginner | **Time:** 30–40 min | **Prerequisites:** Module 00 complete

---

## 📚 Theory

### `val` vs `var` — The Most Important Distinction in Kotlin

```kotlin
val name = "WagwanWorld"  // val = VALUE → immutable (cannot change) — PREFER THIS
var count = 0             // var = VARIABLE → mutable (can change)

name = "NewName"  // ❌ COMPILE ERROR — val cannot be reassigned
count = 5         // ✅ OK — var can be reassigned
```

**Rule of thumb:** Always use `val` unless you absolutely need `var`. Immutability prevents bugs.

### Basic Types

| Type | Example | Size | Notes |
|------|---------|------|-------|
| `Int` | `42` | 32-bit | Most common number type |
| `Long` | `42L` | 64-bit | For big numbers, timestamps |
| `Float` | `3.14f` | 32-bit | Single precision decimal |
| `Double` | `3.14` | 64-bit | Double precision (default for decimals) |
| `Boolean` | `true` / `false` | — | Logic |
| `Char` | `'A'` | 16-bit | Single character |
| `String` | `"Hello"` | — | Text (immutable!) |
| `Byte` | `127` | 8-bit | Raw data |
| `Short` | `32767` | 16-bit | Rarely used |

### Type Inference — Kotlin Is Smart

```kotlin
val message = "Hello from Kampala!"  // Kotlin KNOWS this is a String
val count = 42                        // Kotlin KNOWS this is an Int
val pi = 3.14                         // Kotlin KNOWS this is a Double

// You CAN specify the type explicitly:
val message: String = "Hello from Kampala!"
val count: Int = 42
```

### `const val` vs `val`

```kotlin
const val APP_NAME = "WagwanWorld"  // Compile-time constant — must be a primitive or String
val appName = "WagwanWorld"         // Runtime value — determined when code runs

// const val MUST be at the top level or in an object/companion object
// const val CANNOT be a computed value
const val X = 5 + 3      // ✅ OK — computed at compile time
const val Y = someFunc()  // ❌ ERROR — can't call functions at compile time
```

### Numbers — Underscores for Readability

```kotlin
val million = 1_000_000      // Same as 1000000, but readable!
val hexColor = 0xFF6200EE    // Hex literal
val binary = 0b11010010      // Binary literal
```

## 🔍 In Your Project

Open `app/src/main/java/com/example/wagwanworld/MainActivity.kt`:
```kotlin
var message by remember { mutableStateOf("Hello from Kampala!") }
//  ↑ var because the message CHANGES when the button is clicked
```

Open `app/src/main/java/com/example/wagwanworld/ui/theme/Color.kt`:
```kotlin
val Purple80 = Color(0xFFD0BCFF)   // val because colors never change
val Purple40 = Color(0xFF6650a4)
```

## 🏋️ Exercise

1. Create a new file `app/src/main/java/com/example/wagwanworld/Constants.kt` with:
   - A `const val` for the app name
   - A `val` for the current version (String)
   - Think about: which should be `const val` and which should be `val`?

2. In `HelloScreen()`, add a `val clickCount: Int = 0` — then try to change it. What happens?

3. Change it to `var` — now it compiles. But does the UI update when you change it? (Spoiler: No! You need `remember` + `mutableStateOf` — we'll learn why in the Compose module.)

## 📎 Resources

- [Kotlin Basic Types — Official Docs](https://kotlinlang.org/docs/basic-types.html)
- [Variables — Kotlin Docs](https://kotlinlang.org/docs/basic-syntax.html#variables)

---

⬅️ Previous: None | ➡️ Next: [Null Safety](02-null-safety.md)

