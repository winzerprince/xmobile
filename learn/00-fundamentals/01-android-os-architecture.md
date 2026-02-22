# Lesson 00.01 — Android OS Architecture

> **Difficulty:** 🟢 Beginner | **Time:** 30–45 min | **Prerequisites:** None

---

## 🧠 Why This Matters

Before you write a single line of Kotlin, you should understand what Android IS. When you tap an app icon, dozens of layers work together to make it happen. Understanding these layers will make debugging, performance issues, and architecture decisions make sense later.

## 📚 Theory — The Android Stack

Android is built in **layers**, like a cake. Each layer talks only to the layer directly above or below it.

```
┌─────────────────────────────────────────┐
│           YOUR APPS (WagwanWorld)        │  ← You write code here
├─────────────────────────────────────────┤
│         JAVA/KOTLIN API FRAMEWORK       │  ← Android APIs you call
│  (Activity, View, Content Providers,    │     (e.g., setContent {}, Toast)
│   Notification Manager, etc.)           │
├─────────────────────────────────────────┤
│     NATIVE C/C++ LIBRARIES + ART        │  ← Runtime & core libraries
│  (libc, OpenGL ES, SQLite, WebKit,      │     compiled to native code
│   Android Runtime)                       │
├─────────────────────────────────────────┤
│   HARDWARE ABSTRACTION LAYER (HAL)      │  ← Standardized interface to
│  (Camera HAL, Audio HAL, Bluetooth HAL) │     hardware — see lesson 04
├─────────────────────────────────────────┤
│           LINUX KERNEL                   │  ← The foundation: memory mgmt,
│  (Drivers, Power Mgmt, Binder IPC,      │     process mgmt, security
│   File System, Networking)              │
└─────────────────────────────────────────┘
```

### Layer-by-Layer Breakdown

#### 1. Linux Kernel (Bottom)
Android runs on a **modified Linux kernel**. Yes, your phone runs Linux! The kernel handles:
- **Process management** — each app runs in its own process (sandboxed)
- **Memory management** — allocating/freeing RAM
- **Security** — each app gets its own Linux user ID (UID)
- **Drivers** — camera, display, WiFi, Bluetooth
- **Binder IPC** — Android's custom inter-process communication system (how apps talk to system services)

**Why Linux?** It was battle-tested, open source, and had great hardware driver support.

#### 2. Hardware Abstraction Layer (HAL)
Covered in depth in [Lesson 04](04-hal-explained.md). In short: HAL provides a standard interface so Android doesn't need to know the specifics of your phone's camera chip or GPS module.

#### 3. Native Libraries + Android Runtime (ART)
This layer contains:
- **ART (Android Runtime)** — executes your app's compiled code (see [Lessons 02–03](02-jit-vs-aot-compilation.md))
- **Native libraries** written in C/C++: SQLite (database), OpenGL ES (graphics), WebKit (web rendering), libc (standard C library)

#### 4. Java/Kotlin API Framework
This is the **Android SDK** — the APIs you call in your code:
- `Activity`, `Service`, `BroadcastReceiver`, `ContentProvider` — the 4 fundamental app components
- `View` system (old UI) / Compose (new UI)
- `NotificationManager`, `LocationManager`, `PackageManager` — system services
- `Resources` — access to your strings, images, layouts

When you write `setContent { }` in your `MainActivity.kt`, you're calling into this layer.

#### 5. Applications (Top)
This is where **WagwanWorld** lives! Along with the Phone app, Messages, Chrome, etc. Your app has no special privileges — it uses the same APIs as every other app.

## 🔍 See It In Your Project

Open `app/src/main/java/com/example/wagwanworld/MainActivity.kt`:

```kotlin
class MainActivity : ComponentActivity() {  // ← Framework layer (Activity)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {                          // ← Framework layer (Compose integration)
            WagwanWorldTheme {
                Surface(                      // ← Compose UI (Material 3 library)
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HelloScreen()             // ← YOUR code!
                }
            }
        }
    }
}
```

Every line here touches the API Framework layer. `ComponentActivity` is part of AndroidX (a library built on top of the framework). `Surface` and `MaterialTheme` are Compose/Material libraries that eventually call into the graphics system (native layer) to draw pixels.

## 🏋️ Exercise

1. Open your `AndroidManifest.xml` and identify which **Android framework components** are declared (hint: look for `<activity>`)
2. In Android Studio, hold `Ctrl` (or `Cmd` on Mac) and click on `ComponentActivity` in `MainActivity.kt` — explore how deep the inheritance goes. Write down the chain (e.g., `ComponentActivity → FragmentActivity → ... → Context`)
3. Open a terminal and run: `adb shell cat /proc/version` (if you have an emulator running) — this shows the Linux kernel version your Android device is running!

## 📎 Resources

- [Android Platform Architecture — Official Docs](https://developer.android.com/guide/platform)
- [Android Source — Kernel](https://source.android.com/docs/core/architecture/kernel)
- [Binder IPC Explained](https://developer.android.com/reference/android/os/Binder)

---

⬅️ Previous: None | ➡️ Next: [JIT vs AOT Compilation](02-jit-vs-aot-compilation.md)

