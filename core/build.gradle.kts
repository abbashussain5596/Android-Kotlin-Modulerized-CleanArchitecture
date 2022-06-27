plugins {
    id("com.android.library")
    kotlin("android")
//    id("kotlin-android")
//    id("kotlin-kapt")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    id("com.google.gms.google-services")
    id("com.google.firebase.crashlytics")
}

android {
//    compileSdkVersion(ConfigData.compileSdkVersion)
    compileSdk = ConfigData.compileSdkVersion
    buildFeatures {
        dataBinding = true
    }
    defaultConfig {
//        minSdkVersion(ConfigData.minSdkVersion)
        minSdk = ConfigData.minSdkVersion
//        targetSdkVersion(ConfigData.targetSdkVersion)
        targetSdk = ConfigData.targetSdkVersion
//        versionCode = ConfigData.versionCode
//        versionName = ConfigData.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
//    signingConfigs {
//        getByName("stag") {
//            storeFile = file("../certificates/cert_stag.jks")
//            storePassword = "dj12345"
//            keyAlias = "dj12345"
//            keyPassword = "dj12345"
//        }
//        create("release") {
//            storeFile = file("../certificates/cert_release.jks")
//            storePassword = "dj12345"
//            keyAlias = "dj12345"
//            keyPassword = "dj12345"
//        }
//    }
    buildTypes {
        getByName("debug") {

            buildConfigField("String", "BASE_URL", "\"https://591143b0-e6ad-428a-8266-85cafd62f06d.mock.pstmn.io/\"")
            buildConfigField("Boolean", "IS_ENCRYPTION_ENABLED", "false")
            buildConfigField("Boolean", "IS_TLS_ENABLED", "false")
//            buildConfigField("String", "DATA_STORE_NAME", "\"DATA_STORE_DEBUGGING_${defaultConfig.versionName}\"")
//            buildConfigField("String", "DB_NAME", "\"ROOM_DB_DEBUG_${defaultConfig.versionName}\"")
//            buildConfigField("double", "DB_VERSION", defaultConfig.versionName)
            buildConfigField("long", "TIME_OUT", "30")

//            applicationVariants.all { variant ->
//                variant.outputs.all {
//                    outputFileName = "app-${variant.name}-${defaultConfig.versionName}.apk"
//                }
//            }
        }
        create("stag") {

            buildConfigField("String", "BASE_URL", "\"https://591143b0-e6ad-428a-8266-85cafd62f06d.mock.pstmn.io/\"")
            buildConfigField("Boolean", "IS_ENCRYPTION_ENABLED", "false")
            buildConfigField("Boolean", "IS_TLS_ENABLED", "false")
//            buildConfigField("String", "DATA_STORE_NAME", "\"DATA_STORE_STAGING_${defaultConfig.versionName}\"")
//            buildConfigField("String", "DB_NAME", "\"ROOM_DB_STAG_${defaultConfig.versionName}\"")
//            buildConfigField("double", "DB_VERSION", defaultConfig.versionName)
            buildConfigField("long", "TIME_OUT", "30")

//            signingConfig = signingConfigs.create("stag")

//            applicationVariants.all { variant ->
//                variant.outputs.all {
//                    outputFileName = "app-${variant.name}-${defaultConfig.versionName}.apk"
//                }
//            }
        }
        getByName("release") {

            buildConfigField("String", "BASE_URL", "\"https://591143b0-e6ad-428a-8266-85cafd62f06d.mock.pstmn.io/\"")
            buildConfigField("Boolean", "IS_ENCRYPTION_ENABLED", "false")
            buildConfigField("Boolean", "IS_TLS_ENABLED", "false")
//            buildConfigField("String", "DATA_STORE_NAME", "\"DATA_STORE_PRODUCTION_${defaultConfig.versionName}\"")
//            buildConfigField("String", "DB_NAME", "\"ROOM_DB_RELEASE_${defaultConfig.versionName}\"")
//            buildConfigField("double", "DB_VERSION", defaultConfig.versionName)
            buildConfigField("long", "TIME_OUT", "30")

//            signingConfig = signingConfigs.getByName("release")

//            applicationVariants.all { variant ->
//                variant.outputs.all {
//                    outputFileName = "app-${variant.name}-${defaultConfig.versionName}.apk"
//                }
//            }
            proguardFiles (getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(project(":ui"))
//    implementation 'androidx.core:core-ktx:1.7.0'
    implementation(Deps.core)
//    implementation 'androidx.appcompat:appcompat:1.4.1'
    implementation(Deps.appCompat)
//    implementation 'com.google.android.material:material:1.5.0'
    implementation(Deps.material)
//    implementation 'androidx.constraintlayout:constraintlayout:2.1.3'
    implementation(Deps.constraintLayout)
//    implementation 'androidx.annotation:annotation:1.3.0'
    implementation(Deps.annotation)

//    implementation 'androidx.lifecycle:lifecycle-livedata-ktx:2.4.0'
    implementation(Deps.lifecycleLiveData)

    implementation(Deps.lifecycleRuntime)

//    implementation 'androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.0'
    implementation(Deps.lifecycleViewModel)

//    implementation 'androidx.databinding:databinding-runtime:7.0.4'
    implementation(Deps.dataBinding)

//    testImplementation 'junit:junit:4.+'
    testImplementation(Deps.junit)

//    androidTestImplementation 'androidx.test.ext:junit:1.1.3'
    androidTestImplementation(Deps.junitTest)
//    androidTestImplementation 'androidx.test.espresso:espresso-core:3.4.0'
    androidTestImplementation(Deps.espresso)

//    implementation("com.google.dagger:hilt-android:2.40")
    implementation(Deps.hilt)
//    kapt("com.google.dagger:hilt-android-compiler:2.38.1")
    kapt(Deps.hiltCompiler)

//    implementation 'com.jakewharton.timber:timber:5.0.1'
    implementation(Deps.timber)

//    implementation("androidx.room:room-runtime:2.4.1")
    implementation(Deps.roomRuntime)
//    annotationProcessor("androidx.room:room-compiler:2.4.1")
    annotationProcessor(Deps.roomCompiler)
//    kapt ("androidx.room:room-compiler:2.4.1")
    kapt (Deps.roomCompiler)
//    implementation("androidx.room:room-ktx:2.4.1")
    implementation(Deps.room)
//    implementation("androidx.room:room-paging:2.4.1")
    implementation(Deps.roomPaging)

//    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation(Deps.retrofit2)
//    implementation("com.squareup.okhttp3:logging-interceptor:4.9.0")
    implementation(Deps.loggingInterceptor)
//    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation(Deps.retrofitGson)

//    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")
    implementation(Deps.coroutinesCore)
//    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.0")
    implementation(Deps.coroutinesAndroid)

//    implementation "androidx.activity:activity-ktx:1.4.0"
    implementation(Deps.activity)
//    implementation "androidx.fragment:fragment-ktx:1.4.0"
    implementation(Deps.fragment)


//    implementation platform('com.google.firebase:firebase-bom:29.0.4')
    implementation(platform(Deps.firebaseBom))
//    implementation 'com.google.firebase:firebase-crashlytics-ktx'
    implementation(Deps.firebaseCrashlytics)
    implementation(Deps.firebaseAnalytics)
    implementation(Deps.firebaseMessaging)
//    implementation 'com.google.firebase:firebase-analytics-ktx'
//    implementation 'com.google.firebase:firebase-messaging-ktx'

    implementation(Deps.coroutinesPlayServices)
}