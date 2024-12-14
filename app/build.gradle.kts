plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    jacoco
}

val exclusions = listOf(
    "**/R.class",
    "**/R\$*.class",
    "**/BuildConfig.*",
    "**/Manifest*.*",
    "**/*Test*.*",
    "**/com/example/androidpatch/theme/*"
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

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    tasks.register<JacocoReport>("JacocoCodeCoverage") {
        // Depend on unit tests and Android tests tasks
        dependsOn("testReleaseUnitTest")
        // Set task grouping and description
        group = "Reporting"
        description = "Execute unit tests, generate and combine Jacoco coverage report"
        // Configure reports to generate both XML and HTML formats
        reports {
            xml.required.set(true)
            html.required.set(true)
        }
        // Set source directories to the main source directory
        sourceDirectories.setFrom(layout.projectDirectory.dir("src/main"))
        // Set class directories to compiled Java and Kotlin classes, excluding specified exclusions
        classDirectories.setFrom(files(
            fileTree(layout.buildDirectory.dir("intermediates/javac/")) {
                exclude(exclusions)
            },
            fileTree(layout.buildDirectory.dir("tmp/kotlin-classes/")) {
                exclude(exclusions)
            }
        ))
        // Collect execution data from .exec and .ec files generated during test execution
        executionData.setFrom(files(
            fileTree(layout.buildDirectory) { include(listOf("**/*.exec", "**/*.ec")) }
        ))
    }
}

//tasks.withType(Test::class) {
//    configure<JacocoTaskExtension> {
//        isIncludeNoLocationClasses = true
//        excludes = listOf("com.example.androidpatch.theme")
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