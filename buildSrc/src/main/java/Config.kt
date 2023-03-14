import org.gradle.api.JavaVersion

object Config {
    const val appName = "Satellites"
    const val appNameBeta = "Satellites Beta"
    const val appNameDev = "Satellites Dev"

    const val minSdkVersion = 24
    const val targetSdkVersion = 33
    const val compileSdkVersion = 33

    const val kotlinJvmTarget = "1.8"

    val sourceCompatibilityVersion = JavaVersion.VERSION_1_8
    val targetCompatibilityVersion = JavaVersion.VERSION_1_8

    const val applicationId = "com.satellites.app"
    const val androidTestInstrumentation = "com.satellites.app.AndroidJUnitRunner"

    const val appNameLabel = "application_name"
}