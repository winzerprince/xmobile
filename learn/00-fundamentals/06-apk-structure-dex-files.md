# Lesson 00.06 — APK Structure & DEX Files

> **Difficulty:** 🟢 Beginner | **Time:** 30–40 min | **Prerequisites:** [05-sdk-jdk-ndk.md](05-sdk-jdk-ndk.md)

---

## 🧠 Why This Matters

An APK is the **final product** of your build process — the installable file that goes on a phone. Understanding what's inside it helps you debug build issues, reduce app size, and understand how Android loads your app.

## 📚 Theory

### What Is an APK?

APK = **Android Package**. It's just a ZIP file with a `.apk` extension. Seriously — you can rename it to `.zip` and unzip it!

### APK Anatomy

```
WagwanWorld.apk (it's a ZIP file!)
├── AndroidManifest.xml      ← Binary XML — your app's manifest (compiled by aapt2)
├── classes.dex               ← YOUR compiled Kotlin/Java code (DEX bytecode)
├── classes2.dex              ← (if multidex) Additional DEX file
├── resources.arsc            ← Compiled resource table (strings, dimensions, etc.)
├── res/                      ← Resources that aren't compiled into resources.arsc
│   ├── drawable/             ← Images, vector XMLs
│   ├── mipmap-hdpi/          ← App icon variants
│   ├── mipmap-xhdpi/
│   └── ...
├── lib/                      ← Native libraries (.so files) — only if using NDK
│   ├── arm64-v8a/            ← For 64-bit ARM devices
│   ├── armeabi-v7a/          ← For 32-bit ARM devices
│   └── x86_64/              ← For x86 emulators
├── assets/                   ← Raw files (fonts, JSON, etc.) — accessed via AssetManager
├── META-INF/                 ← Signing information
│   ├── CERT.SF               ← Signature file
│   ├── CERT.RSA              ← Certificate
│   └── MANIFEST.MF           ← Manifest of all files and their digests
└── kotlin/                   ← Kotlin metadata
```

### DEX Files Explained

DEX = **Dalvik Executable**. Even though Dalvik is gone, the format stuck.

```
Your Kotlin → kotlinc → .class files → D8/R8 → .dex files
```

**Why DEX instead of .class?**
- **Consolidation:** Hundreds of .class files → 1 (or few) .dex files
- **Smaller:** Shared constant pool, no duplicate strings
- **Optimized:** Register-based instruction set (better for mobile CPUs)

**Multidex:** A single DEX file can hold ~65,536 methods (the "64K method limit"). Big apps need multiple DEX files. Since your `minSdk = 24` (Android 5.0+), **multidex is automatic** — no config needed!

### AAB — Android App Bundle (Modern Format)

Google now prefers **AAB** (`.aab`) over APK for Play Store uploads:

```
APK:  One file, contains ALL resources for ALL devices
AAB:  Play Store generates OPTIMIZED APKs per device

Example: Your app has icons for hdpi, xhdpi, xxhdpi, xxxhdpi
- APK: Contains ALL icon sizes (wasted space on each device)
- AAB: Play Store generates an APK with ONLY the icons that device needs
```

AAB can reduce download size by **15-30%**!

### R8 — Code Shrinking (Release Builds)

When you build a release APK, **R8** does three things:

1. **Shrinking:** Removes unused classes, methods, and fields
2. **Optimization:** Inlines code, removes dead branches
3. **Obfuscation:** Renames classes to `a`, `b`, `c` (harder to reverse-engineer)

```
Before R8:  classes.dex = 5 MB, 45,000 methods
After R8:   classes.dex = 1.5 MB, 12,000 methods
```

The `proguard-rules.pro` file in your project tells R8 what to keep (e.g., "don't obfuscate my API model classes").

## 🔍 See It In Your Project

Your project's APK is built to: `app/build/outputs/apk/debug/app-debug.apk`

The `proguard-rules.pro` file at `app/proguard-rules.pro` is empty right now — you'll add rules when you enable R8 for release builds.

## 🏋️ Exercise

1. **Build your APK:**
   ```bash
   cd /home/winzer/AndroidStudioProjects/WagwanWorld
   ./gradlew assembleDebug
   ```

2. **Find and inspect it:**
   ```bash
   ls -lh app/build/outputs/apk/debug/app-debug.apk
   # Note the file size
   ```

3. **Look inside the APK:**
   ```bash
   # APK is a ZIP file — you can list its contents!
   unzip -l app/build/outputs/apk/debug/app-debug.apk | head -40
   ```

4. **Use Android Studio's APK Analyzer:**
   - In Android Studio: `Build → Analyze APK...`
   - Select `app/build/outputs/apk/debug/app-debug.apk`
   - Explore the `classes.dex` → find your `com.example.wagwanworld.MainActivity`
   - Check the size breakdown — what takes the most space?

5. **Check the method count:**
   ```bash
   # If you have dexdump available:
   ~/Android/Sdk/build-tools/*/dexdump -f app/build/outputs/apk/debug/app-debug.apk 2>/dev/null | grep "method_ids_size" || echo "Try the APK Analyzer in Android Studio instead"
   ```

<details>
<summary>💡 What to look for in APK Analyzer</summary>

- **classes.dex** is your compiled code — look for your package `com.example.wagwanworld`
- **res/** contains your resources — the mipmap icons will be the biggest
- **resources.arsc** is the compiled resource table
- The "Referenced Methods" count tells you how close you are to the 64K limit
- Compare "Raw File Size" vs "Download Size" to see compression savings
</details>

## 📎 Resources

- [APK Format — Android Developers](https://developer.android.com/guide/components/fundamentals#DeclaringComponents)
- [Android App Bundle — Developer Docs](https://developer.android.com/guide/app-bundle)
- [Shrink, Obfuscate, Optimize (R8) — Developer Docs](https://developer.android.com/build/shrink-code)
- [Analyze Your APK — Developer Docs](https://developer.android.com/studio/debug/apk-analyzer)
- [64K Method Limit — Developer Docs](https://developer.android.com/build/multidex)

---

⬅️ Previous: [SDK, JDK, NDK](05-sdk-jdk-ndk.md) | ➡️ Next: [Gradle Build System](07-gradle-build-system/01-what-is-gradle.md)

