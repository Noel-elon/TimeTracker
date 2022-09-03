object AppDependencies {
    object Versions {
        internal const val ANDROID_GRADLE_PLUGIN = "7.1.0"
        internal const val KOTLIN = "1.7.10"

        internal const val androidXcoreVersion = "1.8.0"
        internal const val lifecycleRuntimeVersion = "2.5.1"

        internal const val appCompatVersion = "1.4.1"
        internal const val materialDesignVersion = "1.3.0-alpha03"
        internal const val constraintLayoutVersion = "2.1.3"

        /**
         * Test Versions
         */
        internal const val androidXTestVersion = "1.1.3"
        internal const val androidXEspressoVersion = "3.4.0"
        internal const val JUnitVersion = "4.13.2"

        internal const val coroutinesVersion = "1.6.4"

        internal const val kotlin = "1.7.10"

        /**
         * DI
         */
        internal const val hiltVersion = "2.42"

        /**
         * Cache
         */
        internal const val room = "2.4.2"

    }

    object AndroidX {
        const val androidCoreKtx: String = "androidx.core:core-ktx:${Versions.androidXcoreVersion}"
        const val appCompat: String = "androidx.appcompat:appcompat:${Versions.appCompatVersion}"
        const val materialDesign: String = "com.google.android.material:material:${Versions.materialDesignVersion}"
        const val constraintLayout: String = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayoutVersion}"

        const val lifecycleKtx =
            "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleRuntimeVersion}"
        const val androidXTestJUnit = "androidx.test.ext:junit:${Versions.androidXTestVersion}"
        const val androidXEspresso =
            "androidx.test.espresso:espresso-core:${Versions.androidXEspressoVersion}"
    }

    object AndroidConfig {
        const val androidGradlePlugin =
            "com.android.tools.build:gradle:${Versions.ANDROID_GRADLE_PLUGIN}"
        const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KOTLIN}"
        const val hiltPlugin = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hiltVersion}"
    }

    object Test {
        const val JUnit = "junit:junit:${Versions.JUnitVersion}"
    }

    object Network {
        const val coroutinesAndroid =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesVersion}"
        const val coroutinesTest =
            "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutinesVersion}"
    }

    object Local {
        const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
        const val roomKtx = "androidx.room:room-ktx:${Versions.room}"
        const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    }

    object DI {
        const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hiltVersion}"
        const val hiltCompiler = "com.google.dagger:hilt-compiler:${Versions.hiltVersion}"
        const val hiltTest = "com.google.dagger:hilt-android-testing:${Versions.hiltVersion}"
    }
}

object Config {
    object Versions {
        const val minSdkVersion: Int = 21
        const val compileSdkVersion: Int = 31
        const val targetSdkVersion: Int = 31
        const val versionName: String = "1.0"
        const val versionCode: Int = 1
    }

    object Android {
        const val applicationId: String = "com.noelon.timetracker"
        const val testImplementationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}