# Compose Cheatsheet
## State
```kotlin
var x by remember { mutableStateOf(0) }           // Survives recomposition
var x by rememberSaveable { mutableStateOf(0) }   // Survives rotation
val x by viewModel.state.collectAsState()          // From ViewModel
```
## Layouts
`Column` (vertical) | `Row` (horizontal) | `Box` (stack/overlap) | `LazyColumn` (scrollable list)
## Navigation
```kotlin
val nav = rememberNavController()
NavHost(nav, "home") { composable("home") { } ; composable("detail/{id}") { } }
nav.navigate("detail/123") ; nav.popBackStack()
```
## Animation
```kotlin
animateDpAsState(target) ; AnimatedVisibility(visible) { } ; AnimatedContent(state) { }
```
## Side Effects
`LaunchedEffect(key)` — coroutine on enter | `DisposableEffect` — register+cleanup | `derivedStateOf` — computed state
---
➡️ Next Module: [03 — Architecture](../03-architecture-patterns/)
