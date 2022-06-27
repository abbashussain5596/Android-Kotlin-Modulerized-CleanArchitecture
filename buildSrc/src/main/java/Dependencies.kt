object BuildPlugins{
    val android by lazy { "com.android.tools.build:gradle:${Versions.gradlePlugin}" }
    val kotlin by lazy { "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}" }
    val hilt by lazy { "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}" }
    val googleServices by lazy { "com.google.gms:google-services:${Versions.googleServices}" }
    val firebaseCrashlytics by lazy { "com.google.firebase:firebase-crashlytics-gradle:${Versions.firebaseCrashlytics}" }
}

object Deps{
    val core by lazy { "androidx.core:core-ktx:${Versions.core}" }
    val appCompat by lazy { "androidx.appcompat:appcompat:${Versions.appCompat}" }
    val material by lazy { "com.google.android.material:material:${Versions.material}" }
    val constraintLayout by lazy { "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}" }
    val annotation by lazy { "androidx.annotation:annotation:${Versions.annotation}" }
    val lifecycleLiveData by lazy { "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}" }
    val lifecycleRuntime by lazy { "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}" }
    val lifecycleViewModel by lazy { "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}" }
    val dataBinding by lazy { "androidx.databinding:databinding-runtime:${Versions.dataBinding}" }
    val junit by lazy { "junit:junit:${Versions.junit}" }
    val junitTest by lazy { "androidx.test.ext:junit:${Versions.junitTest}" }
    val espresso by lazy { "androidx.test.espresso:espresso-core:${Versions.espresso}" }
    val hilt by lazy { "com.google.dagger:hilt-android:${Versions.hilt}" }
    val hiltCompiler by lazy { "com.google.dagger:hilt-android-compiler:${Versions.hiltCompiler}" }
    val timber by lazy { "com.jakewharton.timber:timber:${Versions.timber}" }
    val roomRuntime by lazy { "androidx.room:room-runtime:${Versions.room}" }
    val roomCompiler by lazy { "androidx.room:room-compiler:${Versions.room}" }
    val room by lazy { "androidx.room:room-ktx:${Versions.room}" }
    val roomPaging by lazy { "androidx.room:room-paging:${Versions.room}" }
    val retrofit2 by lazy { "com.squareup.retrofit2:retrofit:${Versions.retrofit2}" }
    val loggingInterceptor by lazy { "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}" }
    val retrofitGson by lazy { "com.squareup.retrofit2:converter-gson:${Versions.retrofit2}" }
    val coroutinesCore by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}" }
    val coroutinesAndroid by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}" }
    val activity by lazy { "androidx.activity:activity-ktx:${Versions.activity}" }
    val fragment by lazy { "androidx.fragment:fragment-ktx:${Versions.fragment}" }
    val firebaseBom by lazy { "com.google.firebase:firebase-bom:${Versions.firebaseBom}" }
    val firebaseCrashlytics by lazy { "com.google.firebase:firebase-crashlytics-ktx" }
    val firebaseAnalytics by lazy { "com.google.firebase:firebase-analytics-ktx" }
    val firebaseMessaging by lazy { "com.google.firebase:firebase-messaging-ktx" }
    val coroutinesPlayServices by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-play-services:${Versions.coroutines}" }
    val navigationFragment by lazy { "androidx.navigation:navigation-fragment-ktx:${Versions.navVersion}" }
    val navigationUi by lazy { "androidx.navigation:navigation-ui-ktx:${Versions.navVersion}" }
    val navigationModule by lazy { "androidx.navigation:navigation-dynamic-features-fragment:${Versions.navVersion}" }
    val navigationTesting by lazy { "androidx.navigation:navigation-testing:${Versions.navVersion}" }
    val navigationCompose by lazy { "androidx.navigation:navigation-compose:${Versions.navVersion}" }
    val splashScreen by lazy { "androidx.core:core-splashscreen:${Versions.splashScreen}" }

}