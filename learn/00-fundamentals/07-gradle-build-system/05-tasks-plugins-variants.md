# Lesson 00.07.05 — Tasks, Plugins & Build Variants

> **Difficulty:** 🟡 Intermediate | **Time:** 30–40 min | **Prerequisites:** [03-build-gradle-files.md](03-build-gradle-files.md)

---

## 📚 Theory

### Build Types
Your app can be built in different **build types**:

```kotlin
buildTypes {
    debug {        // ← For development: debuggable, not optimized
        isDebuggable = true
        isMinifyEnabled = false
    }
    release {      // ← For production: optimized, signed, obfuscated
        isMinifyEnabled = true
        proguardFiles(...)
    }
}
```

You can also create custom build types (e.g., `staging` for QA testing).

### Product Flavors
Flavors let you build **different versions** of your app from the same codebase:

```kotlin
flavorDimensions += "version"
productFlavors {
    create("free") {
        applicationIdSuffix = ".free"
        versionNameSuffix = "-free"
    }
    create("paid") {
        applicationIdSuffix = ".paid"
        versionNameSuffix = "-paid"
    }
}
```

This creates FOUR variants: `freeDebug`, `freeRelease`, `paidDebug`, `paidRelease`.

### Build Variants = Build Type × Product Flavors

```
              debug     release
free          ✅         ✅
paid          ✅         ✅
```

Each variant can have its own source code, resources, and dependencies!

### Custom Tasks

You can define your own Gradle tasks:

```kotlin
tasks.register("printVersionInfo") {
    doLast {
        println("App: ${android.defaultConfig.applicationId}")
        println("Version: ${android.defaultConfig.versionName}")
        println("Min SDK: ${android.defaultConfig.minSdk}")
    }
}
```

Run it: `./gradlew printVersionInfo`

### Common Android Gradle Plugin Tasks

| Task | What It Does |
|------|-------------|
| `assembleDebug` | Builds debug APK |
| `assembleRelease` | Builds release APK |
| `installDebug` | Builds + installs on connected device |
| `uninstallDebug` | Removes app from device |
| `clean` | Deletes all build outputs |
| `lintDebug` | Runs code quality checks |
| `testDebugUnitTest` | Runs unit tests |
| `connectedDebugAndroidTest` | Runs instrumented tests on device |
| `dependencies` | Shows dependency tree |
| `signingReport` | Shows signing key info |

## 🏋️ Exercise

1. **See all variants:**
   ```bash
   ./gradlew :app:printVariantNames 2>&1 || ./gradlew tasks --group="build" 2>&1 | head -20
   ```

2. **Build both types:**
   ```bash
   ./gradlew assembleDebug
   ls -lh app/build/outputs/apk/debug/

   ./gradlew assembleRelease 2>&1 | tail -5
   # This may fail (no signing config for release) — that's expected!
   ```

3. **Run lint:**
   ```bash
   ./gradlew lintDebug 2>&1 | tail -10
   # Check the HTML report at: app/build/reports/lint-results-debug.html
   ```

## 📎 Resources

- [Build Variants — Android Developers](https://developer.android.com/build/build-variants)
- [Custom Gradle Tasks — Gradle Docs](https://docs.gradle.org/current/userguide/tutorial_using_tasks.html)

---

⬅️ Previous: [Version Catalogs](04-version-catalogs.md) | ➡️ Next: [Gradle Commands & Flags](06-gradle-commands-flags.md)

