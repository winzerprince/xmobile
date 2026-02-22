# Exercise 01.01.05 — Kotlin Basics
> **Type:** Hands-On Exercise | **Time:** 40–50 min
---
## 🎯 Goal
Create a utility file for WagwanWorld that uses all the Kotlin basics you've learned.
## 📝 Tasks
### Task 1: Create `AppInfo.kt`
Create `app/src/main/java/com/example/wagwanworld/AppInfo.kt` with:
- A `const val APP_NAME`
- A `val` for a list of supported languages
- A function `getAppDescription(): String` using string templates
- A function `isLanguageSupported(lang: String?): Boolean` using null safety
### Task 2: Create `Utils.kt`
Create `app/src/main/java/com/example/wagwanworld/Utils.kt` with:
- A function `formatGreeting(name: String?, timeOfDay: Int): String` that:
  - Uses Elvis operator for null name
  - Uses `when` expression for time-based greeting
  - Returns something like "Good morning, Alice!"
### Task 3: Use It in Your UI
- Import and call `formatGreeting` from `HelloScreen()`
- Display the result in a `Text()` composable
## ✅ Acceptance Criteria
- [ ] No nullable type warnings (proper null handling)
- [ ] Uses `val` everywhere possible (only `var` where state changes)
- [ ] Uses `when` expressions (not if-else chains)
- [ ] Uses string templates (not concatenation)
- [ ] App builds and runs
---
⬅️ Previous: [Strings & Collections](04-strings-collections.md) | ➡️ Next: [Functions & Parameters](../02-functions/01-functions-parameters.md)
