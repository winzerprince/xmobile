# Exercise 01.04.07 — Coroutines & Flow Practice
> **Type:** Hands-On Exercise | **Time:** 60 min
---
## 🎯 Goal
Add asynchronous data loading to WagwanWorld using coroutines and Flow.
## 📝 Tasks
### Task 1: Create a Fake Data Source
Create `app/src/main/java/com/example/wagwanworld/data/FakePostRepository.kt`:
- A `suspend fun fetchPosts(): List<Post>` that simulates a 2-second network call with `delay(2000)`
- A `fun observePosts(): Flow<List<Post>>` that emits updated lists every 5 seconds
### Task 2: Loading State
- Use `sealed class UiState` to represent Loading, Success(posts), and Error(message)
- In your Activity/ViewModel scope, launch a coroutine that:
  1. Sets state to Loading
  2. Calls `fetchPosts()`
  3. Sets state to Success
  4. Handles errors with try/catch → Error state
### Task 3: Display It
- Show a "Loading..." text while fetching
- Show the list of post titles when loaded
- Show error message if it fails
## ✅ Acceptance Criteria
- [ ] Uses `suspend` functions correctly
- [ ] Uses `Flow` for streaming data
- [ ] Uses `StateFlow` or `mutableStateOf` for UI state
- [ ] Handles loading, success, and error states
- [ ] No blocking calls on the main thread
---
⬅️ Previous: [DSL Builders](06-dsl-builders.md) | ➡️ Next: [Kotlin Cheatsheet](../05-kotlin-cheatsheet.md)
