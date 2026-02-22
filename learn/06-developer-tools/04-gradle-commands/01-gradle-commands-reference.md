# Gradle Commands Reference
> See also: [Module 00 Gradle Lesson](../../00-fundamentals/07-gradle-build-system/06-gradle-commands-flags.md)
## Quick Reference
```bash
./gradlew assembleDebug          # Build debug APK
./gradlew installDebug           # Build + install
./gradlew clean                  # Delete build outputs
./gradlew testDebugUnitTest      # Run unit tests
./gradlew connectedDebugAndroidTest  # Run device tests
./gradlew lintDebug              # Code quality check
./gradlew :app:dependencies      # Show dependency tree
./gradlew assembleDebug --stacktrace --info  # Debug build issues
./gradlew assembleDebug --scan   # Generate build scan
./gradlew signingReport          # Show signing info
./gradlew assembleDebug --profile # Performance report
./gradlew --stop                 # Kill daemon
```
---
➡️ [Exercise](02-exercise-gradle-cli.md)
