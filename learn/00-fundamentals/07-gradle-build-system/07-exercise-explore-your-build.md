# Exercise 00.07.07 — Explore Your Build

> **Difficulty:** 🟢 Beginner | **Time:** 30–40 min | **Type:** Hands-On Exercise

---

## 🎯 Goal

Apply everything you've learned about Gradle by exploring the WagwanWorld build system hands-on.

## 📝 Tasks

### Task 1: Build & Inspect the APK
1. Run `./gradlew clean assembleDebug` from the terminal
2. Find the APK file and note its size
3. Unzip the APK and list the contents
4. Find your `classes.dex` — how many DEX files are there?

### Task 2: Explore the Dependency Tree
1. Run `./gradlew :app:dependencies --configuration debugRuntimeClasspath`
2. Find the Compose BOM and list all libraries it controls
3. How many transitive dependencies does `androidx-activity-compose` bring in?

### Task 3: Modify and Rebuild
1. Change `versionName` in `app/build.gradle.kts` to `"1.1-beta"`
2. Rebuild with `./gradlew assembleDebug --console=plain`
3. Notice which tasks re-ran vs stayed UP-TO-DATE
4. Change it back to `"1.0"`

### Task 4: Gradle Performance
1. Run `./gradlew clean assembleDebug --profile`
2. Open the generated HTML report in `build/reports/profile/`
3. What was the slowest task? How long did the total build take?

### Task 5: Create a Custom Task
Add this to the BOTTOM of `app/build.gradle.kts`:
```kotlin
tasks.register("wagwanInfo") {
    doLast {
        println("========================================")
        println("🇺🇬 WagwanWorld Build Info")
        println("App ID: com.example.wagwanworld")
        println("Min SDK: 24 (Android 7.0)")
        println("Compile SDK: 36")
        println("Kotlin: ${project.properties["kotlin.version"] ?: "check libs.versions.toml"}")
        println("========================================")
    }
}
```
Run it: `./gradlew :app:wagwanInfo`

## ✅ Acceptance Criteria
- [ ] Successfully built the debug APK
- [ ] Listed the APK contents
- [ ] Explored the dependency tree
- [ ] Observed incremental build behavior
- [ ] Generated and viewed a build profile
- [ ] Created and ran a custom Gradle task

---

⬅️ Previous: [Gradle Commands & Flags](06-gradle-commands-flags.md) | ➡️ Next: [Fundamentals Quiz](../08-exercise-fundamentals-quiz.md)

