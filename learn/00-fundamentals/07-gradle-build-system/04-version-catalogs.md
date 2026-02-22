# Lesson 00.07.04 — Version Catalogs (libs.versions.toml)

> **Difficulty:** 🟢 Beginner | **Time:** 20–25 min | **Prerequisites:** [03-build-gradle-files.md](03-build-gradle-files.md)

---

## 📚 Theory

### The Problem
Before version catalogs, dependency versions were scattered across multiple `build.gradle.kts` files. Updating a library meant hunting through files. If two modules used different versions of the same library — bugs.

### The Solution: `libs.versions.toml`

A **single file** (`gradle/libs.versions.toml`) defines all versions, libraries, and plugins. TOML = Tom's Obvious, Minimal Language (a config file format).

Open your `gradle/libs.versions.toml` — it has three sections:

```toml
[versions]           # ← Version numbers
agp = "8.3.0"
kotlin = "2.2.10"
composeBom = "2024.09.00"

[libraries]          # ← Library coordinates + version references
androidx-core-ktx = { group = "androidx.core", name = "core-ktx", version.ref = "coreKtx" }

[plugins]            # ← Gradle plugin coordinates
android-application = { id = "com.android.application", version.ref = "agp" }
```

### How It Maps to build.gradle.kts

```
libs.versions.toml                →  build.gradle.kts
──────────────────                   ─────────────────
[libraries]                          dependencies {
  androidx-core-ktx = { ... }    →     implementation(libs.androidx.core.ktx)
                                     }

[plugins]                            plugins {
  android-application = { ... } →      alias(libs.plugins.android.application)
                                     }
```

The naming convention: dashes in TOML become dots in Kotlin:
`androidx-core-ktx` → `libs.androidx.core.ktx`

### Adding a New Dependency

To add a library (e.g., navigation-compose):

1. Add version to `[versions]`: `navCompose = "2.7.7"`
2. Add library to `[libraries]`: `androidx-navigation-compose = { group = "androidx.navigation", name = "navigation-compose", version.ref = "navCompose" }`
3. Use in `build.gradle.kts`: `implementation(libs.androidx.navigation.compose)`
4. Sync Gradle!

## 🏋️ Exercise

1. Read through your `gradle/libs.versions.toml` and map each `[libraries]` entry to its usage in `app/build.gradle.kts`.
2. Look up the latest version of `androidx-activity-compose` at [Google's Maven Repository](https://maven.google.com/) and compare with your project's version.

## 📎 Resources

- [Version Catalogs — Gradle Docs](https://docs.gradle.org/current/userguide/platforms.html)
- [Migrate to Version Catalogs — Android Developers](https://developer.android.com/build/migrate-to-catalogs)

---

⬅️ Previous: [Build.gradle Files](03-build-gradle-files.md) | ➡️ Next: [Tasks, Plugins & Variants](05-tasks-plugins-variants.md)

