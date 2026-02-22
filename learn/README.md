# 🎓 WagwanWorld — Android + Kotlin Learning Framework

> **For AI Assistants (GitHub Copilot):** This folder is a structured teaching curriculum. When the learner opens a conversation, read this README first, then check `PROGRESS.md` to see where they left off. Follow the module order unless the learner requests a specific topic. Always reference the actual WagwanWorld project code when explaining concepts. Use the exercises in each lesson — don't just explain, make the learner BUILD.

---

## 🤖 Copilot Instructions

1. **Start each session** by reading `learn/PROGRESS.md` to find the next unchecked lesson.
2. **Teach in this order:** Theory (why it exists, what problem it solves) → Show it in WagwanWorld's code → Hands-on exercise → Verify understanding.
3. **Reference project files** directly (e.g., "Open `app/build.gradle.kts` — see line 5...").
4. **Be practical** — write code WITH the learner, don't just lecture.
5. **Adapt difficulty** — if the learner struggles, break it down further. If they're breezing through, skip ahead.
6. **Use the exercises** — every lesson has one. The learner should complete it before moving on.
7. **Link to docs** — always point to official documentation for deeper reading.
8. **Celebrate progress** — learning Android is a marathon. Acknowledge milestones.

### Prompt Templates (for the learner to use)

```
"Let's continue my Android learning from where I left off."
"Teach me the next lesson in the learn/ folder."
"I'm stuck on [topic] — help me understand it with my WagwanWorld project."
"Let's do the exercise for [lesson name]."
"Quiz me on what I've learned in module [number]."
"Explain [concept] like I'm 5, then show me in my code."
"I finished the exercise — review my code and give feedback."
```

---

## 📚 Learning Path Overview

| Module | Topic | Lessons | Estimated Time | Difficulty |
|--------|-------|---------|----------------|------------|
| **00** | [Fundamentals & Under the Hood](00-fundamentals/) | 12 | 8–10 hours | 🟢 Beginner |
| **01** | [Kotlin Language](01-kotlin-language/) | 18 | 15–20 hours | 🟢→🟡 Beginner→Intermediate |
| **02** | [Jetpack Compose](02-jetpack-compose/) | 17 | 20–25 hours | 🟡 Intermediate |
| **03** | [Architecture & Patterns](03-architecture-patterns/) | 14 | 15–20 hours | 🟡→🔴 Intermediate→Advanced |
| **04** | [Data & Networking](04-data-and-networking/) | 11 | 12–15 hours | 🟡 Intermediate |
| **05** | [Advanced Topics](05-advanced-topics/) | 18 | 20–25 hours | 🔴 Advanced |
| **06** | [Developer Tools Deep Dive](06-developer-tools/) | 10 | 8–10 hours | 🟢→🟡 All Levels |

**Total: ~100 lessons | ~100–125 hours**

---

## 🗺️ Dependency Map

```
00-Fundamentals ──→ 01-Kotlin ──→ 02-Compose ──→ 03-Architecture ──→ 05-Advanced
                                      │                │
                                      ▼                ▼
                                 04-Data & Net    06-Dev Tools
```

- **Module 00** has no prerequisites — start here.
- **Module 06** (Dev Tools) can be done alongside any module.
- **Modules 03, 04, 05** require 01 + 02 first.

---

## 📂 Project Context

This framework teaches using the **WagwanWorld** project as the base:

- **App name:** WagwanWorld
- **Package:** `com.example.wagwanworld`
- **Stack:** Kotlin 2.2.10, Jetpack Compose (BOM 2024.09), Material 3
- **Min SDK:** 24 (Android 7.0), Target SDK: 36
- **Build system:** Gradle 8.3.0 with Kotlin DSL + Version Catalog
- **Architecture:** Starting simple, will evolve to MVVM → Clean Architecture through lessons

---

## 🚀 How to Start

1. Open this project in Android Studio
2. Tell Copilot: *"Let's start my Android learning journey. Check the learn/ folder."*
3. Copilot will find your progress and begin the next lesson
4. Complete each exercise before marking it done in `PROGRESS.md`
5. Have fun building WagwanWorld into a real app as you learn! 🇺🇬

