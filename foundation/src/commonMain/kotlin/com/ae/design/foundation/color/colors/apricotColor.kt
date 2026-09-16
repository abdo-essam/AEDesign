package com.ae.design.foundation.color.colors

import androidx.compose.ui.graphics.Color
import com.ae.design.foundation.color.AEColors
import com.ae.design.foundation.color.TonalPalette
import com.ae.design.foundation.color.toDarkColors
import com.ae.design.foundation.color.toLightColors

internal val apricotColor = TonalPalette(
    t50 = Color(0xFFFDF7F4),
    t100 = Color(0xFFFDEFEA),
    t200 = Color(0xFFFED9CC),
    t300 = Color(0xFFFCBAA4),
    t400 = Color(0xFFFA9674),
    t500 = Color(0xFFF06D41),
    t600 = Color(0xFFDF5729),
    t700 = Color(0xFFC4451B),
    t800 = Color(0xFF9E3B1A),
    t900 = Color(0xFF753019),
)

public val apricotLightColors: AEColors = apricotColor.toLightColors()
public val apricotDarkColors: AEColors = apricotColor.toDarkColors()
