# Lesson 02.03.02 — LazyColumn, LazyRow & LazyGrid
> **Difficulty:** 🟡 Intermediate | **Time:** 40 min
## 📚 Theory
LazyColumn/LazyRow only compose visible items (like RecyclerView). Always use `key` for stable identity.
```kotlin
LazyColumn {
    items(posts, key = { it.id }) { post -> PostCard(post) }
}
LazyRow(contentPadding = PaddingValues(horizontal = 16.dp), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
    items(categories) { CategoryChip(it) }
}
LazyVerticalGrid(columns = GridCells.Fixed(2)) { items(photos) { PhotoCard(it) } }
```
## 🏋️ Exercise
1. Replace WagwanWorld's single greeting with a `LazyColumn` of 20 posts.
2. Add a `LazyRow` of categories above the list.
## 📎 Resources
- [Lists & Grids](https://developer.android.com/develop/ui/compose/lists)
---
⬅️ [Column/Row/Box](01-column-row-box.md) | ➡️ [ConstraintLayout](03-constraint-layout.md)
