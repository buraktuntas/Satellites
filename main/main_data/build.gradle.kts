import Dependencies.Desugaring
import ModuleMainImplements.MainDataModule

plugins {
    id("com.android.library")
    kotlin("android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
}
android {
    namespace = "com.satellite.main_data"
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

    kotlinOptions {
        jvmTarget = Config.kotlinJvmTarget
    }
}

dependencies {
    coreLibraryDesugaring(Desugaring.coreLibraryDesugaring)

    implementation(project(Module.core))
    implementation(project(Module.mainDomain))

    MainDataModule.implementations.forEach { dependency ->
        implementation(dependency)
    }

    MainDataModule.kapts.forEach { dependency ->
        kapt(dependency)
    }

    MainDataModule.testImplementations.forEach { dependency ->
        testImplementation(dependency)
    }

    MainDataModule.androidTestImplementations.forEach { dependency ->
        androidTestImplementation(dependency)
    }
}