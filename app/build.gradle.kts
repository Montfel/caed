plugins {
    alias(libs.plugins.android.application)
    id(libs.plugins.hilt.get().pluginId)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.ksp)
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "com.montfel.caed"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.montfel.caed"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
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
        compose = true
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
            excludes += "/META-INF/gradle/incremental.annotation.processors"
        }
    }
}

dependencies {
    implementation(projects.data)
    implementation(projects.domain)
    implementation(projects.presentation)

    implementation(libs.activity)
    implementation(libs.core)
    implementation(platform(libs.compose.bom))
    implementation(libs.bundles.compose)
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
    implementation(libs.hilt.navigation)
    implementation(libs.bundles.lifecycle)
    implementation(libs.kotlin.serialization.json)
    implementation(libs.navigation)

    debugImplementation(libs.compose.ui.test.manifest)

    testImplementation(libs.junit.test)
    androidTestImplementation(libs.espresso)
    androidTestImplementation(libs.junit.test.android)
    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation(libs.compose.ui.test.junit4)
    androidTestImplementation(libs.hilt.testing)
    kspAndroidTest(libs.hilt.compiler)
    androidTestImplementation(libs.test.rules)
}