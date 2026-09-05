package com.ae.design.foundation.typography

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import aedesign.foundation.generated.resources.Res
import aedesign.foundation.generated.resources.barlow_bold
import aedesign.foundation.generated.resources.barlow_medium
import aedesign.foundation.generated.resources.barlow_regular
import aedesign.foundation.generated.resources.barlow_semibold
import org.jetbrains.compose.resources.Font

/**
 * Font family holder for AEDesign.
 *
 * Barlow TTF files (400/500/600/700) loaded from compose resources.
 */
public object AEFontFamily {

    /**
     * Returns the **Barlow** font family loaded from compose resources.
     *
     * Weights: Normal (400) · Medium (500) · SemiBold (600) · Bold (700)
     */
    @Composable
    public fun barlow(): FontFamily = FontFamily(
        Font(resource = Res.font.barlow_regular, weight = FontWeight.Normal),
        Font(resource = Res.font.barlow_medium, weight = FontWeight.Medium),
        Font(resource = Res.font.barlow_semibold, weight = FontWeight.SemiBold),
        Font(resource = Res.font.barlow_bold, weight = FontWeight.Bold),
    )
}
