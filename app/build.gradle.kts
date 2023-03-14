import Dependencies.Desugaring

plugins {
    id("com.android.application")
    kotlin("android")
    id("com.google.dagger.hilt.android")
    id("kotlin-kapt")
}

android {
    namespace = Config.applicationId
    compileSdk = Config.compileSdkVersion

    signingConfigs {
        create(BuildType.BETA) {
            keyAlias = project.properties[BuildArgs.keyStoreAliasLabel].toString()
            keyPassword = project.properties[BuildArgs.keyStorePasswordLabel].toString()
            storeFile = file(project.properties[BuildArgs.keyStoreFilePathLabel].toString())
            storePassword = project.properties[BuildArgs.keyStorePasswordLabel].toString()
        }

        create(BuildType.RELEASE) {
            keyAlias = project.properties[BuildArgs.keyStoreAliasLabel].toString()
            keyPassword = project.properties[BuildArgs.keyStorePasswordLabel].toString()
            storeFile = file(project.properties[BuildArgs.keyStoreFilePathLabel].toString())
            storePassword = project.properties[BuildArgs.keyStorePasswordLabel].toString()
        }
    }

    defaultConfig {
        applicationId = Config.applicationId
        minSdk = Config.minSdkVersion
        targetSdk = Config.targetSdkVersion
        multiDexEnabled = true
        versionCode = project.properties[BuildArgs.buildNumberValue]?.toString()?.toInt()
        versionName = AppVersion.versionName
        testInstrumentationRunner = Config.androidTestInstrumentation
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        debug {
            enableUnitTestCoverage = true
            applicationIdSuffix = ".debug"
            resValue("string", Config.appNameLabel, Config.appNameDev)
            isDebuggable = true
            isMinifyEnabled = false
            isShrinkResources = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }

        create(BuildType.BETA) {
            enableUnitTestCoverage = true
            applicationIdSuffix = ".beta"
            resValue("string", Config.appNameLabel, Config.appNameBeta)
            signingConfig = signingConfigs.getByName(BuildType.BETA)
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }

        release {
            enableUnitTestCoverage = true
            applicationIdSuffix = ".prod"
            resValue("string", Config.appNameLabel, Config.appName)
            signingConfig = signingConfigs.getByName(BuildType.RELEASE)
            isMinifyEnabled = true
            isShrinkResources = true
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
        viewBinding = true
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = LibVersion.composeCompiler
    }

    kotlinOptions {
        freeCompilerArgs = listOf("-Xjvm-default=enable")
        jvmTarget = Config.kotlinJvmTarget
    }
}

dependencies {
    coreLibraryDesugaring(Desugaring.coreLibraryDesugaring)

    Module.allModules.forEach { module ->
        implementation(project(module))
    }

    ModuleAppImplements.implementations.forEach { dependency ->
        implementation(dependency)
    }

    ModuleAppImplements.kapts.forEach { dependency ->
        kapt(dependency)
    }

    ModuleAppImplements.testImplementations.forEach { dependency ->
        testImplementation(dependency)
    }

    ModuleAppImplements.androidTestImplementations.forEach { dependency ->
        androidTestImplementation(dependency)
    }

    ModuleAppImplements.kaptAndroidTests.forEach { dependency ->
        kaptAndroidTest(dependency)
    }
}