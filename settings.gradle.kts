pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven {
            url = uri("https://jitpack.io")
        }
    }
}
rootProject.name = "Satellites"

include(
        ":app",
        ":core",
        ":core-ui"
)
include(":main:main_data")
include(":main:main_domain")
include(":main:main_presentation")
