// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        maven("https://plugins.gradle.org/m2/")
    }
    dependencies {
        classpath(AppDependencies.AndroidConfig.androidGradlePlugin)
        classpath(AppDependencies.AndroidConfig.kotlinGradlePlugin)
        classpath(AppDependencies.AndroidConfig.hiltPlugin)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.10")
    }
}