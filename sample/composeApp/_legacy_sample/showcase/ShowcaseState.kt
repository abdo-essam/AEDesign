package com.ae.design.sample.showcase

import com.ae.design.foundation.color.AEAccent
import com.ae.design.foundation.color.AEPalette
import com.ae.design.foundation.tokens.AEStylePreset

data class ShowcaseState(
    val palette: AEPalette = AEPalette.Zinc,
    val accent: AEAccent = AEAccent.Blue,
    val stylePreset: AEStylePreset = AEStylePreset.Default,
)
