# Data & Networking Cheatsheet
## Room
```kotlin
@Entity data class PostEntity(@PrimaryKey val id: String, val title: String)
@Dao interface PostDao { @Query("SELECT * FROM PostEntity") fun getAll(): Flow<List<PostEntity>>; @Insert(onConflict = REPLACE) suspend fun insertAll(posts: List<PostEntity>) }
@Database(entities = [PostEntity::class], version = 1) abstract class AppDb : RoomDatabase() { abstract fun postDao(): PostDao }
```
## DataStore
```kotlin
val Context.dataStore by preferencesDataStore("settings")
val DARK_MODE = booleanPreferencesKey("dark_mode")
dataStore.data.map { it[DARK_MODE] ?: false }
dataStore.edit { it[DARK_MODE] = true }
```
## Retrofit
```kotlin
interface ApiService { @GET("posts") suspend fun getPosts(): List<PostDto> }
Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/").addConverterFactory(json.asConverterFactory("application/json".toMediaType())).build()
```
---
➡️ [05 — Advanced Topics](../05-advanced-topics/)
