package com.ae.design.foundation.color

import androidx.compose.ui.graphics.Color

internal val limeColor = TonalPalette(
    t50 = Color(0xFFF9FDF4),
    t100 = Color(0xFFF3FDEA),
    t200 = Color(0xFFE4FECC),
    t300 = Color(0xFFCBFCA4),
    t400 = Color(0xFFAEFA74),
    t500 = Color(0xFF8FF041),
    t600 = Color(0xFF74DF29),
    t700 = Color(0xFF5EC41B),
    t800 = Color(0xFF4E9E1A),
    t900 = Color(0xFF407519),
)

public val limeLightColors: AEColors = limeColor.toLightColors()
public val limeDarkColors: AEColors = limeColor.toDarkColors()
