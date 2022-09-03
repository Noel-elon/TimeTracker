plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.noelon.timetracker"

    defaultConfig {
        applicationId = Config.Android.applicationId
        minSdk = Config.Versions.minSdkVersion
        targetSdk = Config.Versions.targetSdkVersion
        compileSdk = Config.Versions.compileSdkVersion
        versionCode = Config.Versions.versionCode
        versionName = Config.Versions.versionName

        testInstrumentationRunner = Config.Android.testImplementationRunner
        vectorDrawables {
            useSupportLibrary =  true
        }
    }

    buildFeatures {
        viewBinding = true
    }

    buildTypes {
        named(BuildType.RELEASE) {
            isMinifyEnabled = BuildTypeRelease.isMinifyEnabled
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

dependencies {
    implementation(project(":core-data"))
    implementation(AppDependencies.AndroidX.androidCoreKtx)
    implementation(AppDependencies.AndroidX.appCompat)
    implementation(AppDependencies.AndroidX.materialDesign)
    implementation(AppDependencies.AndroidX.constraintLayout)
    implementation(AppDependencies.AndroidX.lifecycleKtx)
    implementation(AppDependencies.AndroidX.lifecycleViewModel)
    implementation(AppDependencies.DI.hiltAndroid)
    implementation(AppDependencies.AndroidX.navigationFragment)
    implementation(AppDependencies.AndroidX.navigationUi)
    implementation(AppDependencies.ExternalLibs.circularImageView)
    kapt(AppDependencies.DI.hiltCompiler)
    testImplementation(AppDependencies.Test.JUnit)
    androidTestImplementation(AppDependencies.AndroidX.androidXTestJUnit)
    androidTestImplementation(AppDependencies.AndroidX.androidXEspresso)
}