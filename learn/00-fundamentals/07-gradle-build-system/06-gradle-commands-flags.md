# Lesson 00.07.06 — Gradle Commands & Flags Reference

> **Difficulty:** 🟢 Beginner | **Time:** 25–30 min | **Prerequisites:** [01-what-is-gradle.md](01-what-is-gradle.md)

---

## 📚 Command Reference

### Build Commands

```bash
# Build debug APK (most common)
./gradlew assembleDebug

# Build release APK
./gradlew assembleRelease

# Build + install on connected device in one step
./gradlew installDebug

# Build both debug and release
./gradlew assemble

# Remove app from device
./gradlew uninstallDebug

# Delete ALL build outputs (start fresh)
./gradlew clean

# Clean + rebuild from scratch
./gradlew clean assembleDebug
```

### Information Commands

```bash
# Show all available tasks
./gradlew tasks

# Show ALL tasks (including hidden ones)
./gradlew tasks --all

# Show dependency tree for debug runtime
./gradlew :app:dependencies --configuration debugRuntimeClasspath

# Show signing certificate info
./gradlew signingReport

# Show project structure
./gradlew projects

# Show Gradle/JVM version
./gradlew --version
```

### Testing Commands

```bash
# Run unit tests
./gradlew testDebugUnitTest

# Run instrumented tests (needs emulator/device)
./gradlew connectedDebugAndroidTest

# Run lint (code quality)
./gradlew lintDebug
```

### Debugging Flags

```bash
# Show detailed build output
./gradlew assembleDebug --info

# Show stack trace on errors (ESSENTIAL for debugging)
./gradlew assembleDebug --stacktrace

# Full stack trace (even more detail)
./gradlew assembleDebug --full-stacktrace

# Generate a web-based build scan (shareable!)
./gradlew assembleDebug --scan

# Show why a task ran / was skipped
./gradlew assembleDebug --info | grep -E "UP-TO-DATE|EXECUTED|SKIPPED"

# Run without build cache (force everything from scratch)
./gradlew assembleDebug --no-build-cache

# Run without daemon
./gradlew assembleDebug --no-daemon

# Show Gradle daemon status
./gradlew --status

# Stop all daemons
./gradlew --stop

# Parallel execution (faster on multi-module projects)
./gradlew assembleDebug --parallel

# Refresh dependencies (force re-download)
./gradlew assembleDebug --refresh-dependencies

# Dry run — show what WOULD execute without doing it
./gradlew assembleDebug --dry-run
```

### Performance Commands

```bash
# Profile build performance (creates HTML report)
./gradlew assembleDebug --profile
# Report at: build/reports/profile/

# Build scan (detailed online report)
./gradlew assembleDebug --scan
```

### Combining Flags

```bash
# Common debugging combo: clean build with stack trace and info
./gradlew clean assembleDebug --stacktrace --info 2>&1 | tail -50

# My Gradle is broken, nuke everything:
./gradlew --stop
./gradlew clean --no-build-cache --refresh-dependencies assembleDebug
```

## 🏋️ Exercise

Run each of these and observe the output:
1. `./gradlew --version`
2. `./gradlew tasks --group="build" 2>&1 | head -30`
3. `./gradlew assembleDebug --dry-run 2>&1 | head -30`
4. `./gradlew assembleDebug --profile` — then open the HTML report
5. `./gradlew :app:dependencies --configuration debugRuntimeClasspath 2>&1 | head -40`

## 📎 Resources

- [Command-Line Interface — Gradle Docs](https://docs.gradle.org/current/userguide/command_line_interface.html)
- [Build Performance — Android Developers](https://developer.android.com/build/optimize-your-build)

---

⬅️ Previous: [Tasks, Plugins & Variants](05-tasks-plugins-variants.md) | ➡️ Next: [Exercise: Explore Your Build](07-exercise-explore-your-build.md)

