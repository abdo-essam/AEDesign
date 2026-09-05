package com.ae.design.cli.model

import kotlinx.serialization.Serializable
import com.ae.design.cli.CliVersion

@Serializable
data class AEConfig(
    val foundation: String = CliVersion.FOUNDATION,
    val registry: String = "https://abdo-essam.github.io/AEDesign/r",
    val packageName: String = "",
    val componentsDir: String = "",
)
