package com.ae.design.foundation.typography

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import aedesign.foundation.generated.resources.Res
import aedesign.foundation.generated.resources.barlow_bold
import aedesign.foundation.generated.resources.barlow_medium
import aedesign.foundation.generated.resources.barlow_regular
import aedesign.foundation.generated.resources.barlow_semibold
import aedesign.foundation.generated.resources.cairo_bold
import aedesign.foundation.generated.resources.cairo_light
import aedesign.foundation.generated.resources.cairo_medium
import aedesign.foundation.generated.resources.cairo_regular
import aedesign.foundation.generated.resources.cairo_semibold
import org.jetbrains.compose.resources.Font

/**
 * Font family factories for AEDesign.
 *
 * - [barlow] — LTR / English (default)
 * - [cairo] — RTL / Arabic
 */
public object AEFontFamily {

    /**
     * Returns the **Barlow** font family loaded from compose resources.
     *
     * Suitable for LTR / English layouts. Weights: Normal · Medium · SemiBold · Bold
     */
    @Composable
    public fun barlow(): FontFamily = FontFamily(
        Font(resource = Res.font.barlow_regular,  weight = FontWeight.Normal),
        Font(resource = Res.font.barlow_medium,   weight = FontWeight.Medium),
        Font(resource = Res.font.barlow_semibold, weight = FontWeight.SemiBold),
        Font(resource = Res.font.barlow_bold,     weight = FontWeight.Bold),
    )

    /**
     * Returns the **Cairo** font family loaded from compose resources.
     *
     * Suitable for RTL / Arabic layouts. Weights: Light · Normal · Medium · SemiBold · Bold
     */
    @Composable
    public fun cairo(): FontFamily = FontFamily(
        Font(resource = Res.font.cairo_light,    weight = FontWeight.Light),
        Font(resource = Res.font.cairo_regular,  weight = FontWeight.Normal),
        Font(resource = Res.font.cairo_medium,   weight = FontWeight.Medium),
        Font(resource = Res.font.cairo_semibold, weight = FontWeight.SemiBold),
        Font(resource = Res.font.cairo_bold,     weight = FontWeight.Bold),
    )
}
