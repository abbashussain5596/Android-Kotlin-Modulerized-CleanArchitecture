// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
//        classpath "com.android.tools.build:gradle:7.0.4"
        classpath(BuildPlugins.android)
        classpath(BuildPlugins.kotlin)
        classpath(BuildPlugins.hilt)
        classpath(BuildPlugins.googleServices)
        classpath(BuildPlugins.firebaseCrashlytics)
//        classpath 'org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10'
//        classpath("com.google.dagger:hilt-android-gradle-plugin:2.40")
//        classpath 'com.google.gms:google-services:4.3.10'
//        classpath 'com.google.firebase:firebase-crashlytics-gradle:2.8.1'
    }
}
tasks.register("clean", Delete::class){
    delete(rootProject.buildDir)
}
//task clean(type: Delete) {
//    delete rootProject.buildDir
//}