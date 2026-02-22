# Lesson 00.05 — SDK, JDK, NDK

> **Difficulty:** 🟢 Beginner | **Time:** 35–45 min | **Prerequisites:** [01-android-os-architecture.md](01-android-os-architecture.md)

---

## 🧠 Why This Matters

You'll hear "SDK", "JDK", and "NDK" constantly. They're **toolkits** — collections of tools, libraries, and APIs that you use to build apps. Mixing them up causes confusion, and understanding them explains many Gradle/build errors.

## 📚 Theory

### JDK — Java Development Kit

**What it is:** The toolkit for compiling and running Java/Kotlin code.

**What's inside:**
| Tool | Purpose |
|------|---------|
| `javac` | Java compiler (source → bytecode) |
| `java` | JVM — runs Java bytecode |
| `jar` | Packages .class files into .jar archives |
| `jdb` | Java debugger |
| `keytool` | Manages cryptographic keys (used for APK signing!) |
| Standard Library | `java.lang`, `java.util`, `java.io`, etc. |

**Why you need it:** Kotlin compiles to JVM bytecode. Even though you write Kotlin (not Java), the Kotlin compiler produces `.class` files that are compatible with the JVM. The JDK provides the JVM and core libraries.

**Which JDK?** Android uses a specific JDK version. Check your project:
- Open `gradle/gradle-daemon-jvm.properties` — specifies the JVM for Gradle itself
- Your `app/build.gradle.kts` uses `jvmTarget` to set the bytecode version

**Key distinction:**
- **JRE** (Java Runtime Environment) = just enough to RUN Java programs
- **JDK** (Java Development Kit) = JRE + compiler + tools (everything to BUILD programs)
- You need the JDK (you're building, not just running)

```
JDK
├── JRE
│   ├── JVM (java)
│   └── Standard Library (rt.jar)
├── Compiler (javac)
├── Debugger (jdb)
├── Keytool
└── Other tools (jar, javadoc, jlink, ...)
```

### Android SDK — Software Development Kit

**What it is:** Everything you need to build Android apps, ON TOP of the JDK.

**Where it lives:** Usually at `~/Android/Sdk` (Linux) or `~/Library/Android/sdk` (Mac). Check your `local.properties`:
```properties
sdk.dir=/home/winzer/Android/Sdk
```

**What's inside:**

```
Android SDK/
├── platforms/              ← Android API libraries for each version
│   ├── android-36/         ← Your compileSdk = 36
│   ├── android-35/
│   └── ...
├── build-tools/            ← Compilation tools
│   └── 36.0.0/
│       ├── aapt2           ← Android Asset Packaging Tool (processes resources)
│       ├── d8              ← DEX compiler (.class → .dex)
│       ├── zipalign        ← Optimizes APK alignment
│       └── apksigner       ← Signs APKs
├── platform-tools/         ← Device communication
│   ├── adb                 ← Android Debug Bridge (THE most useful tool)
│   ├── fastboot            ← Low-level device flashing
│   └── systrace            ← System tracing
├── emulator/               ← Android Emulator
├── sources/                ← Android source code (for reading framework code)
├── cmdline-tools/          ← sdkmanager, avdmanager (CLI tools)
└── system-images/          ← Emulator OS images
```

**Key tools explained:**

| Tool | What It Does | When You Use It |
|------|-------------|-----------------|
| `adb` | Communicates with connected devices/emulators | Installing APKs, debugging, shell access |
| `aapt2` | Compiles resources (XML, images) into binary format | Gradle calls it automatically |
| `d8` | Compiles .class → .dex bytecode | Gradle calls it automatically |
| `r8` | d8 + code shrinking + obfuscation (release builds) | Gradle calls it when `isMinifyEnabled = true` |
| `apksigner` | Signs APKs with your keystore | Gradle calls it, or you use it manually |
| `sdkmanager` | Install/update SDK components | Setting up or updating your SDK |
| `avdmanager` | Create/manage Android Virtual Devices (emulators) | Creating a new emulator |

### NDK — Native Development Kit

**What it is:** Toolkit for writing **C/C++ code** that runs on Android.

**Why it exists:** Sometimes you need:
- Maximum performance (game engines, video processing, ML inference)
- Reuse existing C/C++ libraries (OpenCV, FFmpeg, TensorFlow Lite)
- Low-level hardware access

**What's inside:**
- Cross-compilers (compile C/C++ for ARM, x86 processors)
- CMake / ndk-build (build systems for native code)
- Debugging tools (ndk-gdb, ndk-stack)

**Do you need it?** **No, not now.** 99% of apps don't need the NDK. You'd only use it for:
- Games (using game engines like Unity, which use NDK internally)
- Heavy computation (video encoding, image processing)
- Wrapping existing C libraries

The NDK compiles to `.so` (shared library) files that get packaged inside your APK.

### How They All Connect

```
YOU WRITE: Kotlin code (.kt files)
    │
    ▼
JDK's kotlinc: Compiles to .class bytecode
    │
    ▼
Android SDK's D8/R8: Converts .class → .dex (Android bytecode)
    │
    ▼ (if using NDK)
NDK's clang: Compiles C/C++ → .so native libraries
    │
    ▼
Android SDK's aapt2: Packages resources (XML, images)
    │
    ▼
All combined into: APK file (your installable app)
    │
    ▼
Android SDK's adb: Installs APK on device/emulator
    │
    ▼
Device's ART: Executes .dex bytecode (using JIT + AOT)
```

## 🔍 See It In Your Project

Open `local.properties`:
```properties
sdk.dir=/home/winzer/Android/Sdk  # ← Your Android SDK location
```

In `app/build.gradle.kts`:
```kotlin
android {
    compileSdk = 36  // ← Uses platforms/android-36/ from your SDK
    defaultConfig {
        minSdk = 24  // ← Minimum API level supported
    }
}
```

In `gradle/libs.versions.toml`:
```toml
agp = "8.3.0"  // ← Android Gradle Plugin — orchestrates all these SDK tools
```

## 🏋️ Exercise

1. **Find your SDK:** Run in terminal:
   ```bash
   cat /home/winzer/AndroidStudioProjects/WagwanWorld/local.properties
   ```
   Then explore what's inside:
   ```bash
   ls $(grep sdk.dir local.properties | cut -d= -f2)
   ```

2. **Check installed SDK versions:**
   ```bash
   ~/Android/Sdk/cmdline-tools/latest/bin/sdkmanager --list_installed 2>/dev/null || \
   ls ~/Android/Sdk/platforms/
   ```

3. **Find your JDK:**
   ```bash
   ./gradlew --version  # Shows JVM version used by Gradle
   java -version        # Shows system JDK
   ```

4. **Use a SDK tool directly:**
   ```bash
   # See ADB version
   ~/Android/Sdk/platform-tools/adb version

   # If emulator is running, list devices:
   ~/Android/Sdk/platform-tools/adb devices
   ```

5. **Thought question:** Why does Android use DEX bytecode instead of regular JVM bytecode (.class files)?

<details>
<summary>💡 Answer</summary>
DEX (Dalvik Executable) bytecode is optimized for mobile devices:
- **Smaller size**: DEX files combine multiple .class files, eliminating duplication
- **Register-based**: DEX uses a register-based VM (like a real CPU) vs JVM's stack-based design, which means fewer instructions needed
- **Memory efficient**: Designed for devices with limited RAM
- **Shared constant pool**: Multiple classes share one pool of constants (strings, type references)

A typical app's .class files might be 5MB, but the equivalent .dex file could be 2MB.
</details>

## 📎 Resources

- [Android SDK Overview — Developer Docs](https://developer.android.com/studio/intro)
- [SDK Manager — Developer Docs](https://developer.android.com/studio/command-line/sdkmanager)
- [NDK Overview — Developer Docs](https://developer.android.com/ndk/guides)
- [JDK Requirements for Android](https://developer.android.com/build/jdks)
- [D8/R8 Compilation — Developer Docs](https://developer.android.com/build/shrink-code)

---

⬅️ Previous: [HAL Explained](04-hal-explained.md) | ➡️ Next: [APK Structure & DEX Files](06-apk-structure-dex-files.md)

