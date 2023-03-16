import Dependencies.Desugaring
import ModuleMainImplements.MainDomainModule

plugins {
    id("com.android.library")
    kotlin("android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
}

android {
    namespace = "com.satellites.main_domain"
    compileSdk = Config.compileSdkVersion

    defaultConfig {
        minSdk = Config.minSdkVersion
        targetSdk = Config.targetSdkVersion
        multiDexEnabled = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
        }

        create(BuildType.BETA) {
            isMinifyEnabled = false
        }

        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    flavorDimensions += listOf("mode")

    productFlavors {
        create("dev") {
            dimension = "mode"
        }

        create("stb") {
            dimension = "mode"
        }

        create("prod") {
            dimension = "mode"
        }
    }

    compileOptions {
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = Config.sourceCompatibilityVersion
        targetCompatibility = Config.targetCompatibilityVersion
    }

    kotlinOptions {
        jvmTarget = Config.kotlinJvmTarget
    }
}

dependencies {
    coreLibraryDesugaring(Desugaring.coreLibraryDesugaring)

    implementation(project(Module.core))

    MainDomainModule.implementations.forEach { dependency ->
        implementation(dependency)
    }

    MainDomainModule.kapts.forEach { dependency ->
        kapt(dependency)
    }

    MainDomainModule.testImplementations.forEach { dependency ->
        testImplementation(dependency)
    }

    MainDomainModule.androidTestImplementations.forEach { dependency ->
        androidTestImplementation(dependency)
    }
}