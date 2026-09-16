package com.ae.design.foundation.color

import androidx.compose.ui.graphics.Color

internal val skyColor = TonalPalette(
    t50 = Color(0xFFF4FBFD),
    t100 = Color(0xFFEAF7FD),
    t200 = Color(0xFFCCEEFE),
    t300 = Color(0xFFA4DEFC),
    t400 = Color(0xFF74C9FA),
    t500 = Color(0xFF41B3F0),
    t600 = Color(0xFF2996DF),
    t700 = Color(0xFF1B7BC5),
    t800 = Color(0xFF1A639E),
    t900 = Color(0xFF195076),
)

public val skyLightColors: AEColors = skyColor.toLightColors()
public val skyDarkColors: AEColors = skyColor.toDarkColors()
