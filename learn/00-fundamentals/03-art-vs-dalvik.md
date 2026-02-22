# Lesson 00.03 — ART vs Dalvik

> **Difficulty:** 🟢 Beginner | **Time:** 25–35 min | **Prerequisites:** [02-jit-vs-aot-compilation.md](02-jit-vs-aot-compilation.md)

---

## 🧠 Why This Matters

You'll see "ART" and "Dalvik" mentioned everywhere in Android docs. They're the **runtimes** — the engine that actually executes your app's code. Dalvik is dead (since Android 5.0), but understanding it explains why ART exists and what problems it solved.

## 📚 Theory

### What Is a Runtime?

A runtime is the **execution environment** for your code. Just like a web browser is the runtime for JavaScript, ART/Dalvik is the runtime for Android apps. It:
- Loads your DEX bytecode
- Manages memory (allocating objects, garbage collection)
- Provides core libraries (java.lang, java.util, etc.)
- Handles threading

### Dalvik (2008–2014, Android 1.0 → 4.4)

**Named after:** A fishing village in Iceland 🇮🇸

Dalvik was the original Android runtime. Key characteristics:

| Feature | Dalvik |
|---------|--------|
| **Compilation** | Pure JIT (compile at runtime) |
| **Architecture** | Register-based virtual machine |
| **Garbage Collection** | Stop-the-world GC (pauses your app!) |
| **Memory model** | One DEX file per process |
| **Performance** | Slower — recompiled code every launch |

**The big problem:** Dalvik's garbage collector would **freeze your entire app** for 10–50ms while it cleaned up memory. This caused the infamous "Android jank" — visible stuttering in UI.

### ART — Android Runtime (2014–present, Android 5.0+)

**Introduced in:** Android 4.4 (KitKat) as experimental, **default since** Android 5.0 (Lollipop)

| Feature | ART |
|---------|-----|
| **Compilation** | Hybrid: Interpreter + JIT + AOT (profile-guided) |
| **Architecture** | Register-based (same as Dalvik) |
| **Garbage Collection** | Concurrent GC (runs alongside your app!) |
| **Memory model** | Compacting GC, better memory allocation |
| **Performance** | Significantly faster — pre-compiled code, less GC pause |

### Key Improvements ART Brought

#### 1. Concurrent Garbage Collection
```
DALVIK GC:
App running → GC STARTS → ❌ APP FROZEN (10-50ms) → GC ENDS → App resumes
                          ^ User sees jank/stutter

ART GC:
App running → GC runs in background → App keeps running smoothly ✅
             (only one tiny pause of ~1-2ms)
```

#### 2. Better Memory Compaction
Dalvik left memory fragmented (like a cluttered desk). ART **compacts** memory (tidies the desk), reducing out-of-memory crashes.

#### 3. AOT + Profile-Guided Compilation
As covered in the previous lesson — apps get faster over time.

#### 4. Better Debugging & Profiling
ART provides better stack traces, improved diagnostics, and support for tools like the Android Studio profiler.

### The Evolution Timeline

```
2008  Android 1.0      Dalvik with JIT
2010  Android 2.2      Dalvik gets JIT compiler (big speed boost)
2013  Android 4.4      ART available as experimental option
2014  Android 5.0      ART becomes DEFAULT, Dalvik removed
2016  Android 7.0      ART gets hybrid JIT + AOT (profile-guided)
2023+ Android 14+      ART updates can be delivered via Play Store (Project Mainline)
```

### Why Your minSdk Matters

In your `app/build.gradle.kts`, you have `minSdk = 24` (Android 7.0). This means:
- ✅ All your users have ART (guaranteed since Android 5.0)
- ✅ All your users have profile-guided compilation (since Android 7.0)
- ✅ You don't need to worry about Dalvik compatibility AT ALL

## 🏋️ Exercise

1. **Check your runtime:** Run on a connected emulator/device:
   ```bash
   adb shell getprop persist.sys.dalvik.vm.lib.2
   ```
   You should see `libart.so` — that's ART running!

2. **See GC in action:** Open Android Studio's Logcat and filter for `GC`:
   ```
   tag:art regex:GC
   ```
   Run WagwanWorld and interact with it. You'll see GC logs — note how short the pause times are (usually <5ms).

3. **Thought question:** Why do you think Google chose to deliver ART updates through the Play Store (Project Mainline) instead of requiring full OS updates?

<details>
<summary>💡 Answer</summary>
OS updates depend on phone manufacturers (Samsung, Xiaomi, etc.) who are slow to release them. By delivering ART updates through the Play Store, Google can improve performance and fix bugs for ALL Android devices quickly, regardless of the manufacturer.
</details>

## 📎 Resources

- [Android Runtime (ART) — Android Source](https://source.android.com/docs/core/runtime)
- [Debugging ART Garbage Collection](https://developer.android.com/studio/profile/memory-profiler)
- [Project Mainline](https://developer.android.com/about/versions/10/highlights#mainline)

---

⬅️ Previous: [JIT vs AOT Compilation](02-jit-vs-aot-compilation.md) | ➡️ Next: [HAL Explained](04-hal-explained.md)

