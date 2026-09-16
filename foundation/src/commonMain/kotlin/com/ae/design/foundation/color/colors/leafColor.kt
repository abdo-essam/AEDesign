package com.ae.design.foundation.color

import androidx.compose.ui.graphics.Color

internal val leafColor = TonalPalette(
    t50 = Color(0xFFF5FDF4),
    t100 = Color(0xFFEBFDEA),
    t200 = Color(0xFFCDFECC),
    t300 = Color(0xFFA5FCA4),
    t400 = Color(0xFF75FA74),
    t500 = Color(0xFF41F041),
    t600 = Color(0xFF29DF2A),
    t700 = Color(0xFF1BC51B),
    t800 = Color(0xFF1A9E1A),
    t900 = Color(0xFF197619),
)

public val leafLightColors: AEColors = leafColor.toLightColors()
public val leafDarkColors: AEColors = leafColor.toDarkColors()
