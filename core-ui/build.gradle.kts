import Dependencies.Desugaring

plugins {
    id("com.android.library")
    kotlin("android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
}

android {
    namespace = "com.satellites.core_ui"
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
            resValue("string", Config.appNameLabel, Config.appNameDev)
        }

        create(BuildType.BETA) {
            isMinifyEnabled = false
            resValue("string", Config.appNameLabel, Config.appNameBeta)
        }

        release {
            isMinifyEnabled = true
            resValue("string", Config.appNameLabel, Config.appName)
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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

    ModuleCoreUiImplements.implementations.forEach { dependency ->
        implementation(dependency)
    }

    ModuleCoreUiImplements.kapts.forEach { dependency ->
        kapt(dependency)
    }

    ModuleCoreUiImplements.testImplementations.forEach { dependency ->
        testImplementation(dependency)
    }

    ModuleCoreUiImplements.androidTestImplementations.forEach { dependency ->
        androidTestImplementation(dependency)
    }
}