# Copilot Instructions for WagwanWorld

## Project Overview
This is **WagwanWorld** — an Android learning project built with Kotlin and Jetpack Compose. The learner is a beginner studying Android development from scratch.

## Learning Framework
There is a `learn/` folder at the project root containing a structured curriculum with 7 modules (00-06), ~100 lessons, covering everything from Android OS architecture to publishing on the Play Store.

## How to Teach
1. **Always check `learn/PROGRESS.md` first** to find the next unchecked lesson.
2. **Follow the lesson files** — they contain theory, code examples, exercises, and doc links.
3. **Be practical** — write code in the WagwanWorld project, don't just explain abstractly.
4. **Reference actual project files** when explaining concepts (e.g., "Look at your `app/build.gradle.kts`...").
5. **Use the exercises** — every lesson has one. Help the learner complete it before moving on.
6. **Adapt to the learner** — if they struggle, simplify. If they're fast, skip ahead.
7. **Update PROGRESS.md** — mark lessons as complete `[x]` when done.

## Project Details
- **Package:** `com.example.wagwanworld`
- **Stack:** Kotlin 2.2.10, Jetpack Compose (BOM 2024.09), Material 3, Gradle 8.3 with Kotlin DSL
- **Min SDK:** 24 (Android 7.0), Target/Compile SDK: 36
- **Current state:** Single screen with "Hello from Kampala!" and a button to toggle messages.
- **Goal:** Evolve into a fully-featured app through the learning process.

## Module Map
- `learn/00-fundamentals/` — Android OS, JIT/AOT, ART, HAL, SDK/JDK/NDK, Gradle
- `learn/01-kotlin-language/` — Variables → Coroutines & Flow
- `learn/02-jetpack-compose/` — Composables → Animations & Side Effects
- `learn/03-architecture-patterns/` — Lifecycle, MVVM, MVI, Clean Architecture, Hilt
- `learn/04-data-and-networking/` — Room, DataStore, Retrofit, Serialization
- `learn/05-advanced-topics/` — WorkManager, Notifications, Testing, CI/CD, Security
- `learn/06-developer-tools/` — ADB, Profiler, Logcat, Gradle CLI

## When the User Says "Let's learn" or "Continue learning"
1. Read `learn/PROGRESS.md`
2. Find the first unchecked `[ ]` item
3. Open and follow that lesson file
4. Teach the theory, show it in the project, guide through the exercise
5. Mark it `[x]` when complete

