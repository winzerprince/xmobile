# Exercise 00.08 — Fundamentals Quiz

> **Type:** Comprehension Check | **Time:** 15–20 min

---

## 🎯 Goal

Test your understanding of Module 00. Answer these without looking back at the lessons. Then check your answers.

## 📝 Questions

### Android Architecture
1. Name the 5 layers of the Android OS architecture, from bottom to top.
2. What is the Binder IPC and what problem does it solve?
3. Why does Android use a modified Linux kernel instead of creating a new OS from scratch?

### Compilation
4. What's the difference between JIT and AOT compilation?
5. Modern ART uses a hybrid approach. Describe the three phases: fresh install → idle → subsequent launches.
6. Why do debug builds feel slower than release builds? (Give at least 3 reasons)

### Runtimes
7. What was the main problem with Dalvik's garbage collector?
8. How does ART's concurrent GC improve the user experience?
9. What does "Profile-Guided Compilation" mean?

### HAL
10. What problem does the HAL layer solve?
11. Who writes HAL implementations — Google or phone manufacturers?

### Toolkits
12. What are the three main Android toolkits (SDK, JDK, NDK) and when do you use each?
13. What tool converts .class files to .dex files?
14. What is `adb` and name 3 things you can do with it.

### APK & Build
15. What's inside an APK file? Name at least 5 components.
16. What is R8 and what three things does it do?
17. What's the 64K method limit and why doesn't it affect your project?

### Gradle
18. What's the difference between `./gradlew` and `gradle`?
19. Explain `implementation` vs `testImplementation` vs `debugImplementation`.
20. What does `apply false` mean in the root `build.gradle.kts`?

---

<details>
<summary>📋 Answer Key</summary>

1. Linux Kernel → HAL → Native Libraries + ART → Java/Kotlin API Framework → Applications
2. Binder is Android's inter-process communication mechanism. It lets apps communicate with system services (each running in different processes) securely.
3. Linux was battle-tested, open source, had hardware driver support, and solid security/process management.
4. JIT compiles at runtime (while app runs), AOT compiles before runtime (at install or during idle).
5. Fresh install: interpreter + JIT → Idle/charging: AOT-compile hot paths from profiles → Subsequent: pre-compiled code runs instantly.
6. No R8 optimization, JIT-only (no AOT), debugger overhead, no code shrinking, build skips optimization passes.
7. Stop-the-world GC: it froze the entire app for 10-50ms, causing visible UI stutter (jank).
8. ART's GC runs concurrently (in background) with only ~1-2ms pauses, so the UI stays smooth.
9. ART tracks which code paths are "hot" (frequently executed) and only AOT-compiles those, balancing speed vs storage.
10. HAL provides a standard interface between Android framework and hardware-specific drivers, so apps don't need device-specific code.
11. Phone manufacturers (Samsung, Qualcomm, MediaTek, etc.) write HAL implementations for their hardware.
12. JDK = Java tools (compiler, JVM) for compiling Kotlin/Java. SDK = Android-specific tools (adb, aapt2, d8, emulator). NDK = C/C++ cross-compilation for native performance code.
13. D8 (or R8 for release builds with optimization).
14. `adb install` (install APK), `adb shell` (command line on device), `adb logcat` (view logs), `adb devices` (list devices), `adb push/pull` (transfer files).
15. AndroidManifest.xml, classes.dex, resources.arsc, res/ folder, META-INF/ (signing), lib/ (native libs), assets/, kotlin/ metadata.
16. R8 does: (1) Code shrinking (remove unused code), (2) Optimization (inline, remove dead branches), (3) Obfuscation (rename to a/b/c).
17. Single DEX limit is ~65K methods. With minSdk 24+ (Android 5.0+), multidex is automatic.
18. `./gradlew` uses the wrapper (guaranteed version). `gradle` uses system-installed version (might be wrong).
19. `implementation` = in your app, `testImplementation` = only for JVM unit tests, `debugImplementation` = only in debug builds.
20. "Declare this plugin exists but don't activate it here — let modules apply it themselves."

</details>

---

## 🎉 Module 00 Complete!

Congratulations! You now understand the foundations of Android development. You know what happens from your Kotlin source code all the way down to machine instructions on the phone.

**Update your progress:** Mark all Module 00 items as `[x]` in `learn/PROGRESS.md`.

➡️ Next Module: [01 — Kotlin Language](../01-kotlin-language/)

