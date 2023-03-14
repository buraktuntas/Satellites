import Dependencies.Desugaring

plugins {
    id("com.android.library")
    kotlin("android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
}

android {
    namespace = "com.satellites.core"
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
            buildConfigField("String", BuildArgs.apiBaseUrlLabel, "\"${project.properties[BuildArgs.apiBaseUrlValue].toString()}\"")
            buildConfigField("String", BuildArgs.buildNumberLabel, "\"${project.properties[BuildArgs.buildNumberValue].toString()}\"")
        }

        create("stb") {
            dimension = "mode"
            buildConfigField("String", BuildArgs.apiBaseUrlLabel, "\"${project.properties[BuildArgs.apiBaseUrlValue].toString()}\"")
            buildConfigField("String", BuildArgs.buildNumberLabel, "\"${project.properties[BuildArgs.buildNumberValue].toString()}\"")
        }

        create("prod") {
            dimension = "mode"
            buildConfigField("String", BuildArgs.apiBaseUrlLabel, "\"${project.properties[BuildArgs.apiBaseUrlValue].toString()}\"")
            buildConfigField("String", BuildArgs.buildNumberLabel, "\"${project.properties[BuildArgs.buildNumberValue].toString()}\"")
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

    ModuleCoreImplements.implementations.forEach { dependency ->
        implementation(dependency)
    }

    ModuleCoreImplements.kapts.forEach { dependency ->
        kapt(dependency)
    }

    ModuleCoreImplements.testImplementations.forEach { dependency ->
        testImplementation(dependency)
    }

    ModuleCoreImplements.androidTestImplementations.forEach { dependency ->
        androidTestImplementation(dependency)
    }
}