plugins {
    id("com.android.application") version LibVersion.gradlePluginVersion apply false
    id("com.android.library") version LibVersion.gradlePluginVersion apply false
    id("org.jetbrains.kotlin.android") version LibVersion.kotlinVersion apply false
    id("com.google.dagger.hilt.android") version LibVersion.hilt apply false
}


buildscript {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }

    dependencies {
        classpath(Build.androidBuildGradlePlugin)
        classpath(Build.kotlinGradlePlugin)
        classpath(Build.hiltAndroidGradlePlugin)
    }
}

subprojects {
    configurations.all {
        resolutionStrategy.eachDependency {
            val requested = requested
            if (requested.group == "org.jetbrains.kotlin" &&
                    (requested.name == "kotlin-stdlib-jdk8" ||
                            requested.name == "kotlin-stdlib-jdk7" ||
                            requested.name == "kotlin-reflect" ||
                            requested.name == "kotlin-stdlib" ||
                            requested.name == "kotlin-stdlib-common")
            ) {
                useVersion(LibVersion.kotlinVersion)
            }
        }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}