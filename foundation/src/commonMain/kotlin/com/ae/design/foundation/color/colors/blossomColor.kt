package com.ae.design.foundation.color

import androidx.compose.ui.graphics.Color

internal val blossomColor = TonalPalette(
    t50 = Color(0xFFFDF4F9),
    t100 = Color(0xFFFDEAF3),
    t200 = Color(0xFFFECCE4),
    t300 = Color(0xFFFCA4CB),
    t400 = Color(0xFFFA74AE),
    t500 = Color(0xFFF0418F),
    t600 = Color(0xFFDF2974),
    t700 = Color(0xFFC51B5E),
    t800 = Color(0xFF9E1A4E),
    t900 = Color(0xFF761940),
)

public val blossomLightColors: AEColors = blossomColor.toLightColors()
public val blossomDarkColors: AEColors = blossomColor.toDarkColors()
