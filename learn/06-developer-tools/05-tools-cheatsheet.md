# Developer Tools Cheatsheet
## ADB Essentials
```bash
adb devices                   # List devices
adb install -r app.apk        # Install/reinstall
adb shell am start -n pkg/.Activity  # Launch app
adb logcat -s TAG:D           # Filter logs
adb shell dumpsys meminfo pkg # Memory info
adb reverse tcp:8080 tcp:8080 # Port forward
```
## Logcat
```kotlin
Log.d("TAG", "message")       // Debug log
// Filter: package:mine tag:MyTag level:error
```
## Gradle
```bash
./gradlew assembleDebug       # Build
./gradlew installDebug        # Build + install
./gradlew clean               # Clean
./gradlew --stacktrace        # Debug errors
./gradlew --scan              # Build analysis
```
## Android Studio Shortcuts
| Shortcut | Action |
|----------|--------|
| Shift+Shift | Search Everywhere |
| Ctrl+B | Go to Declaration |
| Ctrl+Shift+F | Find in Files |
| Alt+Enter | Quick Fix |
| Ctrl+Shift+R | Replace in Files |
| Ctrl+E | Recent Files |
---
🎉 **Congratulations!** You've completed the entire learning framework. You're now equipped to build production Android apps!
