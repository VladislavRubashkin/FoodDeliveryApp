
plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.ksp)
    alias(libs.plugins.navigationSafeArgs)
}

android {
    namespace = "com.example.fooddeliveryapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.fooddeliveryapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        viewBinding = true
    }

}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //  mockk + runTest
    testImplementation(libs.mockk)
    testImplementation(libs.kotlinx.coroutines.test)

    // navigation + saveArgs
    implementation(libs.navigation.fragment.ktx)
    implementation(libs.navigation.ui.ktx)

    // coroutines
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)

    // lifecycle
    implementation(libs.lifecycle.viewmodel.ktx)
    implementation(libs.lifecycle.runtime.ktx)

    // okhttp + retrofit
    implementation(libs.okhttp3)
    implementation(libs.logging.interceptor)
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.retrofit2.kotlin.coroutines.adapter)
    implementation(libs.picasso)

    // dagger
    implementation(libs.dagger)
    ksp(libs.dagger.compiler)

    // room
    implementation(libs.room.runtime)
    implementation(libs.room.ktx)
    ksp(libs.room.compiler)
}

//buildScript {
//    dependencies {
//        implementation("androidx.navigation:navigation-safe-args-gradle-plugin:${libs.navigation}")
//    }
//}
//buildscript {
//    dependencies {
//        implementation(libs.androidx.navigation.safe.args.gradle.plugin)//2.5.3
//    }
//}

//    testOptions { // для Junit5
//        unitTests.all {
//            useJUnitPlatform()
//        }
//    }