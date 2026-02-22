# Lesson 01.04.05 — Kotlin Flow
> **Difficulty:** 🟡 Intermediate | **Time:** 45 min | **Prerequisites:** [03-coroutines-basics.md](03-coroutines-basics.md)
---
## 🧠 Why This Matters
A coroutine returns ONE value. But what about streams of data? A search bar emitting queries, a database returning live updates, a sensor emitting readings? That's what **Flow** is for.
## 📚 Theory
### Flow = Asynchronous Stream of Values
```kotlin
// A flow that emits 1, 2, 3 with a delay:
fun countFlow(): Flow<Int> = flow {
    for (i in 1..3) {
        delay(1000)
        emit(i)  // Send a value downstream
    }
}
// Collecting (consuming) the flow:
lifecycleScope.launch {
    countFlow().collect { value ->
        println("Received: $value")  // Prints 1, 2, 3 (one per second)
    }
}
```
### Cold vs Hot Flows
- **Cold Flow** (`flow { }`) — doesn't produce values until someone collects. Each collector gets its own emission. Like a vending machine — only works when you press the button.
- **Hot Flow** (`StateFlow`, `SharedFlow`) — produces values regardless of collectors. Like a radio station — broadcasting whether anyone is listening or not.
### Flow Operators (like collection operations, but async)
```kotlin
flowOf(1, 2, 3, 4, 5)
    .filter { it % 2 == 0 }     // [2, 4]
    .map { it * 10 }             // [20, 40]
    .onEach { println(it) }      // Side effect: prints each
    .catch { e -> emit(-1) }     // Error handling
    .collect { updateUI(it) }    // Terminal operator
```
### StateFlow — The ViewModel's Best Friend
```kotlin
class MyViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(UiState())  // Mutable internally
    val uiState: StateFlow<UiState> = _uiState           // Immutable externally
    fun loadData() {
        viewModelScope.launch {
            _uiState.value = UiState(isLoading = true)
            val data = repository.fetchData()
            _uiState.value = UiState(data = data)
        }
    }
}
// In Compose:
@Composable
fun MyScreen(viewModel: MyViewModel) {
    val state by viewModel.uiState.collectAsState()
    // UI automatically updates when state changes!
}
```
### SharedFlow — For Events (One-Shot)
```kotlin
private val _events = MutableSharedFlow<UiEvent>()
val events: SharedFlow<UiEvent> = _events
// Emit an event:
viewModelScope.launch { _events.emit(UiEvent.ShowToast("Saved!")) }
```
### Key Differences
| | StateFlow | SharedFlow |
|---|-----------|------------|
| Has current value | ✅ Yes (`.value`) | ❌ No |
| Replays last value | ✅ Always | Configurable |
| Use case | UI State | One-shot events |
## 🏋️ Exercise
1. Create a `flow { }` that emits countdown numbers from 10 to 0 with 1-second delays.
2. Use `.map`, `.filter`, and `.onEach` operators on it.
3. Create a `MutableStateFlow<String>` for a search query and simulate debouncing with `debounce(300)`.
## 📎 Resources
- [Kotlin Flow — Official Docs](https://kotlinlang.org/docs/flow.html)
- [StateFlow & SharedFlow — Android Developers](https://developer.android.com/kotlin/flow/stateflow-and-sharedflow)
- [Flow on Android — Android Developers](https://developer.android.com/kotlin/flow)
---
⬅️ Previous: [Coroutines Advanced](04-coroutines-advanced.md) | ➡️ Next: [DSL Builders](06-dsl-builders.md)
