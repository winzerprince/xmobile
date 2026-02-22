# Logcat Filtering
> **Difficulty:** 🟢 Beginner | **Time:** 25 min
## 📚 Theory
### Log Levels
```kotlin
Log.v("TAG", "Verbose — most detailed")     // Verbose
Log.d("TAG", "Debug — development info")     // Debug
Log.i("TAG", "Info — general flow")          // Info
Log.w("TAG", "Warning — potential issue")    // Warning
Log.e("TAG", "Error — something broke", exception)  // Error
Log.wtf("TAG", "What a Terrible Failure")    // Assert (should never happen)
```
### Filtering in Android Studio
```
# In Logcat search bar:
package:com.example.wagwanworld              # Your app only
tag:MainActivity                              # Specific tag
level:error                                   # Errors only
tag:OkHttp level:debug                       # Network debugging
message:clicked                              # Search message content
```
### Best Practice: Companion Object TAG
```kotlin
class HomeViewModel : ViewModel() {
    companion object { private const val TAG = "HomeViewModel" }
    fun loadData() { Log.d(TAG, "Loading data...") }
}
```
## 🏋️ Exercise
1. Add `Log.d` calls to your `MainActivity.kt` lifecycle methods.
2. Add `Log.d` to `HelloScreen` to track recompositions.
3. Practice filtering: show only your app, only errors, only a specific tag.
## 📎 Resources
- [Write and View Logs — Android Developers](https://developer.android.com/studio/debug/logcat)
---
➡️ [Exercise](02-exercise-logcat.md)
