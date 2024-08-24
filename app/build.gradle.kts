plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    jacoco
}

//// Register the main JaCoCo task to later depend on the per-variant tasks
//val jacocoTestReport = tasks.register("jacocoTestReport")
//
//tasks.withType<Test> {
//    configure<JacocoTaskExtension> {
//        isIncludeNoLocationClasses = true
//    }
//}

//val exclusions = listOf(
//    "**/R.class",
//    "**/R\$*.class",
//    "**/BuildConfig.*",
//    "**/Manifest*.*",
//    "**/*Test*.*"
//)

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
}

//tasks.withType(Test::class) {
//    configure<JacocoTaskExtension> {
//        isIncludeNoLocationClasses = true
//        excludes = listOf("com.example.androidpatch.theme")
//    }
//}

//tasks.withType<JacocoReport> {
//    afterEvaluate {
//        classDirectories.setFrom(files(classDirectories.files.map {
//            fileTree(it).apply {
//                exclude("com.example.androidpatch.theme")
//            }
//        }))
//    }
//}

//tasks {
//    register("Jacoco", JacocoReport::class) {
//        val jacocoReportTask = this
//
//        group = "Coverage reports"
//        val projects = coveredProjects
//
//        // Here we depend on the jacocoReport task that we created before
//        val subTasks = projects.map { it.task<JacocoReport>("jacocoReport") }
//        dependsOn(subTasks)
//
//        val subSourceDirs = subTasks.map { files(it.sourceDirectories) }
//        additionalSourceDirs.setFrom(subSourceDirs)
//        sourceDirectories.setFrom(subSourceDirs)
//
//        classDirectories.setFrom(subTasks.map { files(it.classDirectories) })
//        executionData.setFrom(subTasks.map { files(it.executionData) })
//
//        reports {
//            html.isEnabled = true
//            html.destination = file("$buildDir/reports/jacoco/html")
//
//            xml.isEnabled = true
//            xml.destination = file("$buildDir/reports/jacoco/jacocoFullReport.xml")
//        }
//
//        doFirst {
//            executionData.setFrom(files(executionData.filter { it.exists() }))
//        }
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

apply("$rootDir/app/jacoco.gradle.kts")