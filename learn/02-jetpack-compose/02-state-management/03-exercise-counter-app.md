# Exercise 02.02.03 — Build a Stateful Counter with ViewModel
> **Type:** Hands-On Exercise | **Time:** 50 min
---
## 🎯 Goal
Implement proper state management in WagwanWorld using ViewModel + StateFlow.
## 📝 Tasks
1. Create `HomeViewModel` with `MutableStateFlow<HomeUiState>`
2. `HomeUiState` has: `isLoading`, `greeting`, `clickCount`
3. ViewModel has: `onGreetingToggle()`, `onCountIncrement()`, `loadData()` (with simulated delay)
4. `HelloScreen` becomes stateless — receives state + callbacks
5. Show a `CircularProgressIndicator` during loading
## ✅ Acceptance Criteria
- [ ] ViewModel holds all state
- [ ] UI is stateless (state hoisted)
- [ ] Uses StateFlow + collectAsState
- [ ] Loading state shown during fake data fetch
- [ ] Click counter persists across recompositions
---
⬅️ Previous: [ViewModel & State](02-viewmodel-state.md) | ➡️ Next: [Layouts: Column, Row, Box](../03-layouts/01-column-row-box.md)
