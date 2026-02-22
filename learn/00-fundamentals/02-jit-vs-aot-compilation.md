# Lesson 00.02 — JIT vs AOT Compilation

> **Difficulty:** 🟢 Beginner | **Time:** 30–40 min | **Prerequisites:** [01-android-os-architecture.md](01-android-os-architecture.md)

---

## 🧠 Why This Matters

When you write Kotlin code and hit "Run" in Android Studio, your code goes through a **compilation pipeline** before it runs on the phone. Understanding JIT and AOT compilation explains why:
- The first app launch can be slow (and how Android fixes it)
- Debug builds feel slower than release builds
- Your app's APK contains `.dex` files, not `.class` files
- Profile-Guided Optimization (PGO) exists

## 📚 Theory

### What Is Compilation?

Computers don't understand Kotlin. They understand **machine code** (binary instructions for the CPU). Compilation is the process of translating your human-readable code into something a machine can execute.

```
Kotlin Source (.kt) → Kotlin Compiler → JVM Bytecode (.class) → D8/R8 → DEX Bytecode (.dex) → ART → Machine Code
```

### Two Approaches to the Final Step

The last step — turning DEX bytecode into machine code — can happen at two different times:

#### JIT (Just-In-Time) Compilation
- **When:** At runtime, while the app is running
- **How:** The runtime compiles "hot" code paths (frequently executed code) on-the-fly
- **Pros:** Faster install, smaller storage, can optimize based on actual usage patterns
- **Cons:** Uses CPU/battery at runtime, app starts slower (cold start)
- **Used by:** Old Android (Dalvik) used pure JIT; Modern ART uses JIT for fresh installs

```
App Starts → ART interprets DEX bytecode
           → Notices a function is called 1000 times ("hot code")
           → JIT-compiles that function to native machine code
           → Next calls run at full native speed
```

#### AOT (Ahead-Of-Time) Compilation
- **When:** Before the app runs (at install time, or during idle/charging)
- **How:** The entire app (or commonly-used parts) are compiled to machine code during installation or maintenance
- **Pros:** Blazing fast execution from the first call, no runtime compilation overhead
- **Cons:** Slower install, more storage space, compiled code may not be optimal for all execution paths
- **Used by:** Modern ART uses AOT for mature apps (after profile collection)

```
App Installed → ART collects usage profiles over several days
             → During idle/charging, AOT-compiles hot paths
             → Next app launch: pre-compiled code runs instantly
```

### The Modern ART Approach (Hybrid)

Modern Android (since Android 7.0 / API 24 — which is your `minSdk`!) uses **BOTH**:

```
1. FRESH INSTALL
   → App runs with interpreter + JIT
   → ART collects a "profile" of hot code paths
   → Stored in: /data/misc/profiles/

2. IDLE + CHARGING (usually overnight)
   → Android's "bg-dexopt" job runs
   → AOT-compiles the profiled hot paths
   → Stored as .odex / .art files

3. SUBSEQUENT LAUNCHES
   → AOT-compiled code runs instantly (fast start)
   → Remaining cold paths still use interpreter + JIT
   → Profile continues to evolve
```

This hybrid approach is called **Profile-Guided Compilation** and it gives you the best of both worlds.

### Why Debug Builds Feel Slower

When you run your WagwanWorld app in debug mode:
- The compiler **skips optimizations** to preserve debugging info
- ART runs in **JIT-only mode** (no AOT optimization)
- **Debugger overhead** (breakpoints, variable inspection)
- **No R8 code shrinking** (more code to process)

That's why release builds feel noticeably snappier!

## 🔍 See It In Your Project

In `app/build.gradle.kts`, when you eventually add:

```kotlin
buildTypes {
    release {
        isMinifyEnabled = true  // ← Enables R8 (code shrinking + optimization)
    }
    debug {
        isMinifyEnabled = false  // ← No optimization, for fast builds + debugging
    }
}
```

The `release` build produces optimized DEX bytecode that ART can then AOT-compile efficiently. The `debug` build skips this for faster development cycles.

## 🏋️ Exercise

1. **Conceptual:** Draw (on paper or in a note) the complete compilation pipeline for your WagwanWorld app:
   `MainActivity.kt → ? → ? → ? → Phone CPU executes it`
   Fill in each step.

2. **Practical:** Run this in a terminal (with an emulator running):
   ```bash
   # See what compilation state your app is in
   adb shell dumpsys package com.example.wagwanworld | grep -i "dexopt\|compilation"
   ```

3. **Thought experiment:** If you had an app with 100,000 lines of code, would you prefer JIT or AOT at install time? Why? What about a tiny app like WagwanWorld?

<details>
<summary>💡 Hint for Exercise 1</summary>

```
MainActivity.kt → Kotlin Compiler → .class bytecode → D8 compiler → .dex bytecode
→ packaged into APK → installed on device → ART interprets + JIT compiles → 
overnight AOT compilation → native machine code → CPU executes
```
</details>

## 📎 Resources

- [ART and Dalvik — Android Source](https://source.android.com/docs/core/runtime)
- [Profile-Guided Optimization — Android Developers Blog](https://android-developers.googleblog.com/2016/11/art-and-profile-guided-compilation.html)
- [D8 and R8 — Android Developers](https://developer.android.com/build/shrink-code)
- [Configuring JIT Compilation — AOSP](https://source.android.com/docs/core/runtime/jit-compiler)

---

⬅️ Previous: [Android OS Architecture](01-android-os-architecture.md) | ➡️ Next: [ART vs Dalvik](03-art-vs-dalvik.md)

