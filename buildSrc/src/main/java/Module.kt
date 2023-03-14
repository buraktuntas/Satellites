object Module {
    const val core = ":core"
    const val coreUi = ":core-ui"

    const val mainData = ":main:main_data"
    const val mainDomain = ":main:main_domain"
    const val mainPresentation = ":main:main_presentation"

    val allModules = listOf(
        core,
        coreUi,

        mainData,
        mainDomain,
        mainPresentation,
    )
}

