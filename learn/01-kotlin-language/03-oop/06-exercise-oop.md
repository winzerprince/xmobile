# Exercise 01.03.06 — OOP Practice: Model WagwanWorld's Domain
> **Type:** Hands-On Exercise | **Time:** 60 min
---
## 🎯 Goal
Create a complete domain model for WagwanWorld using all OOP concepts.
## 📝 Tasks
1. Create `app/src/main/java/com/example/wagwanworld/model/` package with:
   - `data class User(val id: String, val name: String, val bio: String?)`
   - `data class Post(val id: String, val title: String, val content: String, val author: User)`
   - `sealed class FeedState` with Loading, Content(posts), Error(message)
   - `enum class Category { NEWS, TECH, CULTURE, SPORTS }`
   - `interface Searchable { fun matches(query: String): Boolean }` — implement in User and Post
2. Create an `object SampleData` with factory methods that return sample instances.
3. Use `SampleData` in `HelloScreen()` to display a post title and author.
## ✅ Acceptance Criteria
- [ ] Uses data classes for models
- [ ] Uses sealed class for state
- [ ] Uses enum for categories
- [ ] Uses interface for shared behavior
- [ ] Uses object for sample data
- [ ] Models are used in UI
---
⬅️ Previous: [Objects & Companions](05-objects-companions.md) | ➡️ Next: [Generics](../04-advanced/01-generics.md)
