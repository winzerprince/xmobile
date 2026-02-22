# Exercise 01.02.04 — Functions Practice
> **Type:** Hands-On Exercise | **Time:** 45 min
---
## 🎯 Goal
Create a `StringUtils.kt` file with extension functions and use them in WagwanWorld.
## 📝 Tasks
1. Create `app/src/main/java/com/example/wagwanworld/StringUtils.kt`:
   - `fun String.capitalize()` — capitalize first letter
   - `fun String.truncate(maxLength: Int, ellipsis: String = "...")` — truncate with ellipsis
   - `fun String.wordCount(): Int` — count words
   - `fun String?.orDefault(default: String = "N/A"): String` — null-safe default
2. Create `app/src/main/java/com/example/wagwanworld/MessageProvider.kt`:
   - A higher-order function that takes a `formatter: (String) -> String` and applies it to a list of messages
   - Use it with lambda, function reference, and named function
3. Use these in `HelloScreen()` to format the displayed message.
## ✅ Acceptance Criteria
- [ ] At least 3 extension functions created
- [ ] At least 1 higher-order function used
- [ ] Functions tested by calling them from UI
- [ ] Code compiles and runs
---
⬅️ Previous: [Extension Functions](03-extension-functions.md) | ➡️ Next: [Classes & Constructors](../03-oop/01-classes-constructors.md)
