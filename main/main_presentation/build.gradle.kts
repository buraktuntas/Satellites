import Dependencies.Desugaring
import ModuleMainImplements.MainPresentationModule

plugins {
    id("com.android.library")
    kotlin("android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
}

android {
    namespace = "com.satellites.main_presentation"
    compileSdk = Config.compileSdkVersion

    defaultConfig {
        minSdk = Config.minSdkVersion
        targetSdk = Config.targetSdkVersion
        multiDexEnabled = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
        vectorDrawables {
            useSupportLibrary = true
        }
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

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = LibVersion.composeCompiler
    }

    kotlinOptions {
        jvmTarget = Config.kotlinJvmTarget
    }
}

dependencies {
    coreLibraryDesugaring(Desugaring.coreLibraryDesugaring)

    implementation(project(Module.core))
    implementation(project(Module.coreUi))
    implementation(project(Module.mainDomain))

    MainPresentationModule.implementations.forEach { dependency ->
        implementation(dependency)
    }

    MainPresentationModule.kapts.forEach { dependency ->
        kapt(dependency)
    }

    MainPresentationModule.testImplementations.forEach { dependency ->
        testImplementation(dependency)
    }

    MainPresentationModule.androidTestImplementations.forEach { dependency ->
        androidTestImplementation(dependency)
    }
}