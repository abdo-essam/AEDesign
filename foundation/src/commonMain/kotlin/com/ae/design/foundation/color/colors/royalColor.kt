package com.ae.design.foundation.color

import androidx.compose.ui.graphics.Color

internal val royalColor = TonalPalette(
    t50 = Color(0xFFF7F4FD),
    t100 = Color(0xFFEEEAFD),
    t200 = Color(0xFFD9CCFE),
    t300 = Color(0xFFBBA4FC),
    t400 = Color(0xFF9674FA),
    t500 = Color(0xFF6D41F0),
    t600 = Color(0xFF5729DF),
    t700 = Color(0xFF451BC5),
    t800 = Color(0xFF3B1A9E),
    t900 = Color(0xFF301975),
)

public val royalLightColors: AEColors = royalColor.toLightColors()
public val royalDarkColors: AEColors = royalColor.toDarkColors()
