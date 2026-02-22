# Lesson 02.02.02 — ViewModel & State in Compose
> **Difficulty:** 🟡 Intermediate | **Time:** 40 min | **Prerequisites:** [01-remember-mutablestateof.md](01-remember-mutablestateof.md), [Coroutines](../../01-kotlin-language/04-advanced/03-coroutines-basics.md)
---
## 📚 Theory
### Why ViewModel?
`remember` survives recomposition. `rememberSaveable` survives rotation. But **ViewModel** survives both AND is the proper place for business logic.
```kotlin
class CounterViewModel : ViewModel() {
    private val _count = MutableStateFlow(0)
    val count: StateFlow<Int> = _count
    fun increment() { _count.value++ }
    fun decrement() { _count.value-- }
}
@Composable
fun CounterScreen(viewModel: CounterViewModel = viewModel()) {
    val count by viewModel.count.collectAsState()
    Column {
        Text("Count: $count")
        Row {
            Button(onClick = { viewModel.decrement() }) { Text("-") }
            Button(onClick = { viewModel.increment() }) { Text("+") }
        }
    }
}
```
### State Holder Pattern
```kotlin
data class HomeUiState(
    val isLoading: Boolean = false,
    val posts: List<Post> = emptyList(),
    val error: String? = null
)
class HomeViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()
    fun loadPosts() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            try {
                val posts = repository.fetchPosts()
                _uiState.update { it.copy(isLoading = false, posts = posts) }
            } catch (e: Exception) {
                _uiState.update { it.copy(isLoading = false, error = e.message) }
            }
        }
    }
}
```
### Adding ViewModel Dependency
Add to `libs.versions.toml` and `build.gradle.kts`:
```toml
# libs.versions.toml [libraries]
androidx-lifecycle-viewmodel-compose = { group = "androidx.lifecycle", name = "lifecycle-viewmodel-compose", version.ref = "lifecycleRuntimeKtx" }
```
```kotlin
// app/build.gradle.kts
implementation(libs.androidx.lifecycle.viewmodel.compose)
```
## 🏋️ Exercise
1. Add the ViewModel Compose dependency to WagwanWorld.
2. Create `HomeViewModel` with a `UiState` and fake data loading.
3. Connect it to `HelloScreen` using `collectAsState()`.
4. Show loading, content, and error states.
## 📎 Resources
- [ViewModel in Compose — Android Developers](https://developer.android.com/develop/ui/compose/state#viewmodel-state)
- [State Holders — Android Developers](https://developer.android.com/develop/ui/compose/state-hoisting#state-holders)
---
⬅️ Previous: [remember & mutableStateOf](01-remember-mutablestateof.md) | ➡️ Next: [Exercise: Counter App](03-exercise-counter-app.md)
