import Dependencies.AndroidX
import Dependencies.Coroutines
import Dependencies.Dagger
import Dependencies.JakeWharton
import Dependencies.OkHttp
import Dependencies.Retrofit
import Dependencies.Security
import Dependencies.Testing

object ModuleCoreImplements {
    val implementations = listOf(
        AndroidX.multiDex,
        Coroutines.coroutinesCore,
        Dagger.hiltAndroid,
        JakeWharton.threeTen,
        JakeWharton.timber,
        OkHttp.okHttp,
        OkHttp.okHttpLoggingInterceptor,
        Retrofit.retrofit,
        Retrofit.moshiConverter,
        Security.securityCrypto
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