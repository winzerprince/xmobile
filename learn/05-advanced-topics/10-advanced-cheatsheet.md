# Advanced Topics Cheatsheet
## WorkManager
```kotlin
val work = OneTimeWorkRequestBuilder<SyncWorker>().setConstraints(Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()).build()
WorkManager.getInstance(context).enqueue(work)
```
## Testing
```kotlin
@Test fun `load posts updates state`() = runTest { viewModel.loadPosts(); assertEquals(3, viewModel.uiState.value.posts.size) }
@Test fun `home screen shows posts`() { composeTestRule.onNodeWithText("Post Title").assertIsDisplayed() }
```
## Permissions
```kotlin
val launcher = rememberLauncherForActivityResult(RequestPermission()) { granted -> if (granted) openCamera() }
launcher.launch(Manifest.permission.CAMERA)
```
---
➡️ [06 — Developer Tools](../06-developer-tools/)
