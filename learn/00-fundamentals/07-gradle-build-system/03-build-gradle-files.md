# Lesson 00.07.03 — Build.gradle Files Explained

> **Difficulty:** 🟢 Beginner | **Time:** 35–45 min | **Prerequisites:** [01-what-is-gradle.md](01-what-is-gradle.md)

---

## 📚 Theory

Your project has **two** `build.gradle.kts` files. This confuses beginners — let's clarify.

### Why Two Files?

Android projects are **multi-module**. Right now you have one module (`app`), but real apps often have:
```
WagwanWorld/
├── app/              ← UI module
├── data/             ← Data layer module
├── domain/           ← Business logic module
└── build.gradle.kts  ← Root: shared settings for ALL modules
```

The root file configures things shared across modules. Each module file configures that specific module.

### Root `build.gradle.kts` — Line by Line

Open `/home/winzer/AndroidStudioProjects/WagwanWorld/build.gradle.kts`:

```kotlin
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false  // ← Declare the plugin exists, but DON'T apply it here
    alias(libs.plugins.kotlin.compose) apply false        // ← Same — modules will apply these themselves
}
```

**`apply false`** = "Make this plugin available to sub-modules, but don't activate it at the root level." It's like buying a tool and putting it on the shelf — modules will grab it when they need it.

### Module `app/build.gradle.kts` — Section by Section

This is the real workhorse. Let's walk through every section:

#### Plugins Block
```kotlin
plugins {
    alias(libs.plugins.android.application)  // Now APPLIED — this IS an Android application
    alias(libs.plugins.kotlin.compose)       // Enables Compose compiler
}
```

#### Android Block
```kotlin
android {
    namespace = "com.example.wagwanworld"  // Used for generated R class & BuildConfig
    compileSdk = 36                        // Which SDK to compile against

    defaultConfig {
        applicationId = "com.example.wagwanworld"  // Unique app ID (Play Store identity)
        minSdk = 24        // Oldest Android version supported
        targetSdk = 36     // Newest version you've tested on
        versionCode = 1    // Integer — increment for each Play Store release
        versionName = "1.0" // Human-readable version shown to users

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false  // Set to true for production (enables R8)
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11  // Java bytecode level
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"  // Kotlin compiles to Java 11 bytecode
    }

    buildFeatures {
        compose = true  // Enable Compose — without this, @Composable won't work!
    }
}
```

**Key distinctions:**
- `namespace` vs `applicationId`: Usually the same, but can differ. `applicationId` is your Play Store identity (can never change after publishing). `namespace` is for code generation.
- `compileSdk` vs `targetSdk` vs `minSdk`: See the diagram:

```
SDK Versions:
  minSdk (24) ←── Minimum API level your app supports
       |          Users with older phones can't install
       |
  targetSdk (36) ← "I've tested on this version"
       |            Android enables modern behaviors
       |
  compileSdk (36) ← You can USE APIs up to this level
                     But must check version at runtime for features > minSdk
```

#### Dependencies Block
```kotlin
dependencies {
    // "implementation" = I need this to compile AND at runtime
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)

    // BOM (Bill of Materials) — locks all Compose library versions together
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)

    // "testImplementation" = only for unit tests (not in the APK)
    testImplementation(libs.junit)

    // "androidTestImplementation" = only for on-device tests
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)

    // "debugImplementation" = only included in debug builds
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
}
```

## 🏋️ Exercise

1. Open `app/build.gradle.kts` and change `versionName` to `"1.1"`. Sync Gradle (the banner at the top of Android Studio). What changed?

2. Try changing `minSdk` to `21` (Android 5.0). What does this mean for your app's potential user base?

3. Run to see your project's full dependency tree:
   ```bash
   ./gradlew :app:dependencies --configuration debugRuntimeClasspath 2>&1 | head -60
   ```
   Notice how `compose-bom` controls the versions of all Compose libraries.

4. **Change it back** to `minSdk = 24` and `versionName = "1.0"` after experimenting.

## 📎 Resources

- [Configure Your Build — Android Developers](https://developer.android.com/build)
- [Application ID — Android Developers](https://developer.android.com/build/configure-app-module#set-application-id)
- [SDK Version Guide — Android Developers](https://developer.android.com/reference/android/os/Build.VERSION_CODES)

---

⬅️ Previous: [Gradle Wrapper & Daemon](02-gradle-wrapper-daemon.md) | ➡️ Next: [Version Catalogs](04-version-catalogs.md)

