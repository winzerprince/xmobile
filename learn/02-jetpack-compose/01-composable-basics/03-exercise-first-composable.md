# Exercise 02.01.03 — Build Your First Custom Composable
> **Type:** Hands-On Exercise | **Time:** 45 min
---
## 🎯 Goal
Create a reusable `GreetingCard` composable for WagwanWorld with proper previews.
## 📝 Tasks
1. Create `app/src/main/java/com/example/wagwanworld/ui/components/GreetingCard.kt`
2. Build a `@Composable fun GreetingCard(name: String, message: String, onDismiss: () -> Unit)`:
   - Card with rounded corners and elevation
   - Name in bold, message below, dismiss button
   - Use `MaterialTheme.colorScheme` for colors
3. Add @Preview with multiple configurations (light, dark, long text)
4. Use it in `HelloScreen()` replacing the current simple Text
## ✅ Acceptance Criteria
- [ ] Custom composable in its own file
- [ ] Uses Material 3 components (Card, Text, Button)
- [ ] Has @Preview annotations
- [ ] Parameters are plain data (not ViewModel)
- [ ] Integrated into HelloScreen
---
⬅️ Previous: [Previews](02-previews.md) | ➡️ Next: [State: remember & mutableStateOf](../02-state-management/01-remember-mutablestateof.md)
