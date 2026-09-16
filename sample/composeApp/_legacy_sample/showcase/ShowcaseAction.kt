package com.ae.design.sample.showcase

import com.ae.design.foundation.color.AEAccent
import com.ae.design.foundation.color.AEPalette
import com.ae.design.foundation.tokens.AEStylePreset

sealed interface ShowcaseAction {
    data class ChangePalette(val palette: AEPalette) : ShowcaseAction
    data class ChangeAccent(val accent: AEAccent) : ShowcaseAction
    data class ChangeStylePreset(val preset: AEStylePreset) : ShowcaseAction
}
