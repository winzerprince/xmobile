# Architecture Cheatsheet
## MVVM
```
View (Compose) → observes → ViewModel (StateFlow) → calls → Repository → Data Source
```
## MVI
```
View → Intent (sealed class) → ViewModel.reduce(intent) → new State → View
```
## Clean Architecture Layers
```
Presentation (UI + ViewModel) → Domain (Use Cases + Entities) → Data (Repository Impl + Data Sources)
```
## Hilt Quick Reference
```kotlin
@HiltAndroidApp class App : Application()
@AndroidEntryPoint class MainActivity : ComponentActivity()
@HiltViewModel class MyVM @Inject constructor(repo: Repo) : ViewModel()
@Module @InstallIn(SingletonComponent::class) object AppModule { @Provides @Singleton fun provideRepo(): Repo = ... }
```
---
➡️ [04 — Data & Networking](../04-data-and-networking/)
