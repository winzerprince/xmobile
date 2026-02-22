# ADB — Android Debug Bridge Commands
> **Difficulty:** 🟢 Beginner | **Time:** 45 min
## 📚 What Is ADB?
ADB is a command-line tool that lets you communicate with Android devices/emulators. It's THE most important tool outside Android Studio.
**Location:** `~/Android/Sdk/platform-tools/adb` (add to PATH!)
## Command Reference
### Device Management
```bash
adb devices                     # List connected devices
adb devices -l                  # List with details (model, transport)
adb -s <serial> shell           # Connect to specific device (when multiple)
adb connect <ip>:5555           # Connect wirelessly (after enabling)
adb disconnect                  # Disconnect wireless
```
### App Management
```bash
adb install app.apk             # Install APK
adb install -r app.apk          # Re-install (keep data)
adb install -t app.apk          # Allow test APK
adb uninstall com.example.app   # Uninstall by package name
adb uninstall -k com.example.app # Uninstall but keep data
```
### Shell Commands
```bash
adb shell                       # Open interactive shell on device
adb shell pm list packages      # List all installed packages
adb shell pm list packages | grep wagwan  # Find your app
adb shell am start -n com.example.wagwanworld/.MainActivity  # Start activity
adb shell am force-stop com.example.wagwanworld  # Force stop app
adb shell input text "Hello"    # Type text
adb shell input keyevent 4      # Press Back button
adb shell screencap /sdcard/screen.png  # Screenshot
adb shell settings get system screen_brightness  # Read system setting
```
### File Transfer
```bash
adb push local_file.txt /sdcard/  # PC → Device
adb pull /sdcard/file.txt ./      # Device → PC
```
### Logging
```bash
adb logcat                       # Stream ALL logs
adb logcat -s "MainActivity"     # Filter by tag
adb logcat *:E                   # Only errors
adb logcat -c                    # Clear log buffer
adb logcat -d > log.txt          # Dump to file
```
### Network
```bash
adb reverse tcp:8080 tcp:8080    # Device→PC port forwarding (for local servers)
adb forward tcp:8080 tcp:8080    # PC→Device port forwarding
```
### Advanced
```bash
adb shell dumpsys activity activities  # See activity stack
adb shell dumpsys meminfo com.example.wagwanworld  # Memory usage
adb shell getprop ro.build.version.sdk  # Get Android API level
adb bugreport > bugreport.zip    # Full bug report
adb shell wm size                # Screen resolution
adb shell wm density             # Screen density
```
## 🏋️ Exercise
Practice each command category with WagwanWorld running on an emulator.
## 📎 Resources
- [ADB — Android Developers](https://developer.android.com/tools/adb)
---
➡️ [Exercise](02-exercise-adb.md)
