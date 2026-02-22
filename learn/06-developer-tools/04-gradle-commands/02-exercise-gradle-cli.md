# Exercise — Gradle CLI Mastery
> **Time:** 30 min
## 📝 Tasks
Run each command and understand the output:
1. `./gradlew tasks --group=build`
2. `./gradlew :app:dependencies --configuration debugRuntimeClasspath | head -50`
3. `./gradlew assembleDebug --dry-run | wc -l` (count tasks)
4. `./gradlew clean assembleDebug --profile` (open the HTML report)
5. `./gradlew lintDebug` (fix any warnings)
6. `./gradlew signingReport` (note the debug SHA-1)
7. `./gradlew assembleDebug --scan` (explore the web report)
8. `./gradlew --stop && time ./gradlew assembleDebug` (cold build time)
9. `time ./gradlew assembleDebug` (warm build time — compare!)
10. `./gradlew :app:dependencies | grep "compose"` (find all Compose deps)
---
⬅️ [Gradle Reference](01-gradle-commands-reference.md) | ➡️ [Tools Cheatsheet](../05-tools-cheatsheet.md)
