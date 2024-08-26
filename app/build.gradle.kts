plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    kotlin("jvm") version "1.8.10"
}

repositories {
    mavenCentral()
}

android {
    namespace = "com.jackassbemybadassapplepie.kotlin_complete_app"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.jackassbemybadassapplepie.kotlin_complete_app"
        minSdk = 31
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }

        manifestPlaceholders["apiKey"] = project.findProperty("MAPBOX_API") ?: ""
        buildConfigField("String", "API_KEY", "\"${project.findProperty("MAPBOX_API")}\"")
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
        kotlinCompilerExtensionVersion = "1.5.1"
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    implementation(libs.mapbox.android)
    implementation(libs.mapbox.plugin.gestures)
    implementation(libs.mapbox.plugin.compass)
    implementation(libs.mapbox.plugin.logo)
    implementation(libs.mapbox.plugin.scalebar)
    implementation(libs.mapbox.plugin.locationcomponent)
    implementation(libs.dotenv.kotlin)
//    implementation("io.github.cdimascio:dotenv-kotlin:6.4.1")

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

}