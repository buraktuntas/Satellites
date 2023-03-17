import Dependencies.AndroidX
import Dependencies.Compose
import Dependencies.Dagger
import Dependencies.Google
import Dependencies.JakeWharton
import Dependencies.Testing

object ModuleCoreUiImplements {
    val implementations = listOf(
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