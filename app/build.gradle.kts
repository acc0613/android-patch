import java.util.Locale
 apply("$rootDir/app/jacoco.gradle.kts")

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    jacoco
    // id("com.github.nbaztec.coveralls-jacoco") version "1.2.20"
}

//jacoco {
//    toolVersion = "0.8.7"
//    reportsDirectory.set(layout.buildDirectory.dir("jcc-report"))
//}

val exclusions = listOf(
    "**/R.class",
    "**/R\$*.class",
    "**/BuildConfig.*",
    "**/Manifest*.*",
    "**/*Test*.*"
)

android {
    namespace = "com.example.androidpatch"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.androidpatch"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            enableUnitTestCoverage = true
        }
    }
//
//    testOptions {
//
//    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    tasks.withType<Test> {
        useJUnitPlatform() // Note: automatically generated when creating project
    }
}

//tasks.withType(Test::class) {
//    configure<JacocoTaskExtension> {
//        isIncludeNoLocationClasses = true
//        excludes = listOf("jdk.internal.*")
//    }
//}



dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.ui.graphics.android)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

// apply("$rootDir/app/jacoco.gradle.kts")