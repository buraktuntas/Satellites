import Dependencies.AndroidX
import Dependencies.Compose
import Dependencies.Coroutines
import Dependencies.Dagger
import Dependencies.Google
import Dependencies.JakeWharton
import Dependencies.Retrofit
import Dependencies.Testing

object ModuleMainImplements {

    /* Main Data Module Dependencies */
    object MainDataModule {
        val implementations = listOf(
            AndroidX.multiDex,
            AndroidX.coreKtx,
            Dagger.hiltAndroid,
            Retrofit.retrofit,
            Retrofit.moshiConverter
        )

        val kapts = listOf(
            Dagger.hiltCompiler
        )

        val testImplementations = listOf(
            Testing.junit,
            Testing.junitExt,
            Testing.truth,
            Testing.coroutinesTest,
            Testing.composeUiTest,
            Testing.mockk,
            Testing.mockWebServer
        )

        val androidTestImplementations = listOf(
            Testing.junit,
            Testing.junitExt,
            Testing.truth,
            Testing.coroutinesTest,
            Testing.composeUiTest,
            Testing.mockkAndroid,
            Testing.mockWebServer,
            Testing.hiltTesting
        )
    }

    /* Main Domain Module Dependencies */
    object MainDomainModule {
        val implementations = listOf(
            AndroidX.multiDex,
            AndroidX.coreKtx,
            Coroutines.coroutinesCore,
            Dagger.hiltAndroid,
            Retrofit.moshiConverter
        )

        val kapts = listOf(
            Dagger.hiltCompiler
        )

        val testImplementations = listOf(
            Testing.junit,
            Testing.junitExt,
            Testing.truth,
            Testing.coroutinesTest,
            Testing.composeUiTest,
            Testing.mockk,
            Testing.mockWebServer
        )

        val androidTestImplementations = listOf(
            Testing.junit,
            Testing.junitExt,
            Testing.truth,
            Testing.coroutinesTest,
            Testing.composeUiTest,
            Testing.mockkAndroid,
            Testing.mockWebServer,
            Testing.hiltTesting
        )
    }

    /* Main Presentation Module Dependencies */
    object MainPresentationModule {
        val implementations = listOf(
            AndroidX.appcompat,
            AndroidX.multiDex,
            AndroidX.coreKtx,
            Compose.compiler,
            Compose.ui,
            Compose.navigation,
            Compose.uiTooling,
            Compose.uiToolingPreview,
            Compose.material,
            Compose.runtime,
            Compose.constraintLayout,
            Compose.activity,
            Compose.hiltNavigation,
            Compose.lifecycleViewModel,
            Dagger.hiltAndroid,
            Google.material,
            Google.accompanistPager,
            JakeWharton.timber
        )

        val kapts = listOf(
            Dagger.hiltCompiler
        )

        val testImplementations = listOf(
            Testing.junit,
            Testing.junitExt,
            Testing.truth,
            Testing.coroutinesTest,
            Testing.composeUiTest,
            Testing.mockk,
            Testing.mockWebServer
        )

        val androidTestImplementations = listOf(
            Testing.junit,
            Testing.junitExt,
            Testing.truth,
            Testing.coroutinesTest,
            Testing.composeUiTest,
            Testing.mockkAndroid,
            Testing.mockWebServer,
            Testing.hiltTesting
        )
    }
}