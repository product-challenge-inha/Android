@file:Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    kotlin("kapt")
    alias(libs.plugins.hilt)
    alias(libs.plugins.google.service)
}

android {
    namespace = "com.strayalpaca.tiffanyentropy"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.strayalpaca.tiffanyentropy"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.2"
    }
    packaging {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
}

dependencies {

    implementation(platform(libs.compose.bom))
    implementation(libs.bundles.compose)
    testImplementation(libs.junit)
    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation(libs.bundles.ui.test)
    debugImplementation(libs.bundles.compose.debug)

    // hilt
    implementation(libs.hilt.android)
    implementation(libs.hilt.navigation.compose)
    kapt(libs.hilt.andorid.compiler)

    // hilt with compose navigation
    implementation(libs.hilt.navigation.compose)

    // compose navigation
    implementation(libs.navigation.compose)

    // retrofit & okhttp
    implementation(libs.bundles.retrofit2)
    implementation(libs.bundles.okhttp3)

    // firebase
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.cloud.messaging)

    // chart
    implementation(libs.madrapps.plot)

    // cameraX
    implementation(libs.bundles.camerax)
    implementation(libs.mlkit)
}

kapt {
    correctErrorTypes = true
}