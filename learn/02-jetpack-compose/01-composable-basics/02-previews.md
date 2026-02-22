# Lesson 02.01.02 — @Preview
> **Difficulty:** 🟢 Beginner | **Time:** 20 min | **Prerequisites:** [01-composable-functions.md](01-composable-functions.md)
---
## 📚 Theory
### @Preview — See UI Without Running the App
```kotlin
@Preview(showBackground = true)
@Composable
fun HelloScreenPreview() {
    WagwanWorldTheme {
        HelloScreen()
    }
}
```
### Preview Parameters
```kotlin
@Preview(name = "Light Mode", showBackground = true)
@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Preview(name = "Large Font", fontScale = 2f)
@Preview(name = "Tablet", widthDp = 800, heightDp = 1280)
@Composable
fun Previews() { ... }
```
### @PreviewParameter — Data-Driven Previews
```kotlin
class UserProvider : PreviewParameterProvider<String> {
    override val values = sequenceOf("Alice", "Bob", "A very long name that might overflow")
}
@Preview
@Composable
fun UserCard(@PreviewParameter(UserProvider::class) name: String) {
    Text(name)
}
```
### Best Practice: Preview-Friendly Composables
```kotlin
// ❌ BAD — takes ViewModel (can't preview)
@Composable
fun ProfileScreen(viewModel: ProfileViewModel) { ... }
// ✅ GOOD — takes plain data (easy to preview)
@Composable
fun ProfileScreen(name: String, bio: String, onEditClick: () -> Unit) { ... }
```
## 🏋️ Exercise
1. Add `@Preview` to your `HelloScreen` (wrap it in theme).
2. Create multi-previews: light mode, dark mode, large font.
3. Create a `@Composable fun PostCard(title: String, body: String)` with its own preview.
## 📎 Resources
- [Composable Previews — Android Developers](https://developer.android.com/develop/ui/compose/tooling/previews)
---
⬅️ Previous: [Composable Functions](01-composable-functions.md) | ➡️ Next: [Exercise](03-exercise-first-composable.md)
