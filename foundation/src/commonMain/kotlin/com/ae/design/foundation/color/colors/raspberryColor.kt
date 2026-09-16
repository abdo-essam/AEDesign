package com.ae.design.foundation.color

import androidx.compose.ui.graphics.Color

internal val raspberryColor = TonalPalette(
    t50 = Color(0xFFFDF7F8),
    t100 = Color(0xFFF9EBED),
    t200 = Color(0xFFF2D7DB),
    t300 = Color(0xFFE5AEB5),
    t400 = Color(0xFFCC5D6C),
    t500 = Color(0xFFBF3547),
    t600 = Color(0xFFA62A3C),
    t700 = Color(0xFF8C1930),
    t800 = Color(0xFF6E1023),
    t900 = Color(0xFF500816),
)

public val raspberryLightColors: AEColors = raspberryColor.toLightColors()
public val raspberryDarkColors: AEColors = raspberryColor.toDarkColors()
