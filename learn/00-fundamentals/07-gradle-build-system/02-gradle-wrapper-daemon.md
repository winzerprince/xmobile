# Lesson 00.07.02 — Gradle Wrapper & Daemon

> **Difficulty:** 🟢 Beginner | **Time:** 20–25 min | **Prerequisites:** [01-what-is-gradle.md](01-what-is-gradle.md)

---

## 📚 Theory

### Gradle Wrapper (`gradlew`)

**The Problem:** If you share your project with someone, they might have Gradle 7.x installed but your project needs Gradle 8.x. Builds break.

**The Solution:** The **Gradle Wrapper** — a small script that downloads the correct Gradle version automatically.

```
gradlew          ← Shell script (Linux/Mac)
gradlew.bat      ← Batch script (Windows)
gradle/wrapper/
├── gradle-wrapper.jar        ← The bootstrapper (downloads Gradle)
└── gradle-wrapper.properties ← "Which Gradle version do I need?"
```

In your project's `gradle/wrapper/gradle-wrapper.properties`:
```properties
distributionUrl=https\://services.gradle.org/distributions/gradle-X.X-bin.zip
```

**Rule: ALWAYS use `./gradlew` instead of `gradle`**. This guarantees everyone builds with the same Gradle version.

```bash
# ✅ Correct — uses wrapper
./gradlew assembleDebug

# ❌ Wrong — uses whatever Gradle is installed system-wide
gradle assembleDebug
```

### Gradle Daemon

**The Problem:** Starting a JVM is slow (~2-3 seconds). Starting one for every Gradle command wastes time.

**The Solution:** The **Gradle Daemon** — a long-running background process that stays alive between builds.

```
First build:  Start JVM (~3s) + Build (~20s) = 23s
Second build: JVM already running + Build (~12s) = 12s  ← Much faster!
```

The daemon:
- Starts automatically when you run `./gradlew`
- Stays alive for 3 hours of idle time (configurable)
- Caches project structure and compiled build scripts
- Can be managed with commands:

```bash
# Check running daemons
./gradlew --status

# Stop all daemons (useful if builds are buggy)
./gradlew --stop

# Run without daemon (for debugging build issues)
./gradlew assembleDebug --no-daemon
```

**From `gradle.properties` in your project:**
```properties
org.gradle.jvmargs=-Xmx2048m -Dfile.encoding=UTF-8
```
This gives the daemon **2GB of RAM** (`-Xmx2048m`). If you have 16GB+ RAM, you could increase this to `4096m` for faster builds.

## 🏋️ Exercise

1. **Check wrapper version:**
   ```bash
   cd /home/winzer/AndroidStudioProjects/WagwanWorld
   cat gradle/wrapper/gradle-wrapper.properties | grep distributionUrl
   ```

2. **Check daemon status:**
   ```bash
   ./gradlew --status
   ```

3. **Compare build times:**
   ```bash
   # First, stop the daemon
   ./gradlew --stop

   # Time a cold build (no daemon)
   time ./gradlew assembleDebug --no-daemon 2>&1 | tail -3

   # Time a warm build (daemon running from first build)
   time ./gradlew clean assembleDebug 2>&1 | tail -3
   ```
   The second build should be noticeably faster!

## 📎 Resources

- [Gradle Wrapper — Gradle Docs](https://docs.gradle.org/current/userguide/gradle_wrapper.html)
- [Gradle Daemon — Gradle Docs](https://docs.gradle.org/current/userguide/gradle_daemon.html)

---

⬅️ Previous: [What Is Gradle?](01-what-is-gradle.md) | ➡️ Next: [Build.gradle Files](03-build-gradle-files.md)

