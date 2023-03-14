import Dependencies.AndroidX
import Dependencies.Compose
import Dependencies.Dagger
import Dependencies.Google
import Dependencies.JakeWharton
import Dependencies.OkHttp
import Dependencies.Retrofit
import Dependencies.Root
import Dependencies.Testing

object ModuleAppImplements {
  val implementations = listOf(
    AndroidX.appcompat,
    AndroidX.multiDex,
    AndroidX.coreKtx,
    AndroidX.splashScreen,
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
    Google.accompanistSysUiControl,
    Google.accompanistPager,
    JakeWharton.threeTen,
    JakeWharton.timber,
    Retrofit.retrofit,
    Retrofit.moshiConverter,
    Root.rootControl,
    OkHttp.okHttp,
    OkHttp.okHttpLoggingInterceptor
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
    Testing.hiltTesting,
    Testing.testRunner
  )

  val kaptAndroidTests = listOf(
    Dagger.hiltCompiler
  )
}