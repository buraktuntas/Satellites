object Dependencies {

    object AndroidX {
        const val appcompat = "androidx.appcompat:appcompat:${LibVersion.appcompat}"
        const val multiDex = "androidx.multidex:multidex:${LibVersion.multiDex}"
        const val coreKtx = "androidx.core:core-ktx:${LibVersion.coreKtx}"
        const val splashScreen = "androidx.core:core-splashscreen:${LibVersion.splashScreen}"
    }

    object Compose {
        const val material = "androidx.compose.material:material:${LibVersion.compose}"
        const val ui = "androidx.compose.ui:ui:${LibVersion.compose}"
        const val uiTooling = "androidx.compose.ui:ui-tooling:${LibVersion.compose}"
        const val uiToolingPreview = "androidx.compose.ui:ui-tooling-preview:${LibVersion.compose}"
        const val runtime = "androidx.compose.runtime:runtime:${LibVersion.compose}"
        const val compiler = "androidx.compose.compiler:compiler:${LibVersion.composeCompiler}"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout-compose:${LibVersion.composeConstraintLayout}"
        const val activity = "androidx.activity:activity-compose:${LibVersion.composeActivity}"
        const val navigation = "androidx.navigation:navigation-compose:${LibVersion.composeNavigation}"
        const val hiltNavigation = "androidx.hilt:hilt-navigation-compose:${LibVersion.composeHiltNavigation}"
        const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-compose:${LibVersion.composeLifecycleViewModel}"
    }

    object Coroutines {
        const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${LibVersion.coroutines}"
    }

    object Dagger {
        const val hiltAndroid = "com.google.dagger:hilt-android:${LibVersion.hilt}"
        const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${LibVersion.hilt}"
    }

    object Desugaring {
        const val coreLibraryDesugaring = "com.android.tools:desugar_jdk_libs:${LibVersion.coreLibraryDesugaring}"
    }

    object Glide {
        const val glide = "com.github.skydoves:landscapist-glide:${LibVersion.glide}"
    }

    object Google {
        const val material = "com.google.android.material:material:${LibVersion.material}"
        const val accompanistSysUiControl = "com.google.accompanist:accompanist-systemuicontroller:${LibVersion.accompanistSysUiControl}"
        const val accompanistPager = "com.google.accompanist:accompanist-pager:${LibVersion.accompanistPager}"
    }

    object JakeWharton {
        const val threeTen = "com.jakewharton.threetenabp:threetenabp:${LibVersion.threeTen}"
        const val timber = "com.jakewharton.timber:timber:${LibVersion.timber}"
    }

    object OkHttp {
        const val okHttp = "com.squareup.okhttp3:okhttp:${LibVersion.okHttp}"
        const val okHttpLoggingInterceptor =
            "com.squareup.okhttp3:logging-interceptor:${LibVersion.okHttp}"
    }

    object Retrofit {
        const val retrofit = "com.squareup.retrofit2:retrofit:${LibVersion.retrofit}"
        const val moshiConverter = "com.squareup.retrofit2:converter-moshi:${LibVersion.retrofit}"
    }

    object Room {
        const val roomRuntime = "androidx.room:room-runtime:${LibVersion.room}"
        const val roomCompiler = "androidx.room:room-compiler:${LibVersion.room}"
        const val roomKtx = "androidx.room:room-ktx:${LibVersion.room}"
    }

    object Root {
        const val rootControl = "com.scottyab:rootbeer-lib:${LibVersion.rootControl}"
    }

    object Security {
        const val securityCrypto = "androidx.security:security-crypto:${LibVersion.securityCrypto}"
    }

    object Testing {
        const val junit = "junit:junit:${LibVersion.junit}"
        const val junitExt = "androidx.test.ext:junit:${LibVersion.junitExt}"
        const val coroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${LibVersion.coroutinesTest}"
        const val truth = "com.google.truth:truth:${LibVersion.truth}"
        const val mockk = "io.mockk:mockk:${LibVersion.mockk}"
        const val mockkAndroid = "io.mockk:mockk-android:${LibVersion.mockk}"
        const val mockWebServer = "com.squareup.okhttp3:mockwebserver:${LibVersion.mockWebServer}"
        const val composeUiTest = "androidx.compose.ui:ui-test-junit4:${LibVersion.compose}"
        const val hiltTesting = "com.google.dagger:hilt-android-testing:${LibVersion.hilt}"
        const val testRunner = "androidx.test:runner:${LibVersion.testRunner}"
    }
}
