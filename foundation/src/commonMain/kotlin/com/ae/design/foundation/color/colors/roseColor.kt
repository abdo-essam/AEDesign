package com.ae.design.foundation.color

import androidx.compose.ui.graphics.Color

internal val roseColor = TonalPalette(
    t50 = Color(0xFFFDF4F6),
    t100 = Color(0xFFFDEAED),
    t200 = Color(0xFFFECCD5),
    t300 = Color(0xFFFCA4B5),
    t400 = Color(0xFFFA748C),
    t500 = Color(0xFFF04165),
    t600 = Color(0xFFDF294F),
    t700 = Color(0xFFC51B3F),
    t800 = Color(0xFF9E1A35),
    t900 = Color(0xFF76192C),
)

public val roseLightColors: AEColors = roseColor.toLightColors()
public val roseDarkColors: AEColors = roseColor.toDarkColors()
