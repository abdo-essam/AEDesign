package com.ae.design.foundation.color

import androidx.compose.ui.graphics.Color

internal val grayColor = TonalPalette(
    t50 = Color(0xFFFCFCFC),
    t100 = Color(0xFFFAFAFA),
    t200 = Color(0xFFF5F5F5),
    t300 = Color(0xFFF0F0F0),
    t400 = Color(0xFFDEDEDE),
    t500 = Color(0xFFC2C2C2),
    t600 = Color(0xFF717779),
    t700 = Color(0xFF363839),
    t800 = Color(0xFF1D1F20),
    t900 = Color(0xFF090B0B),
)

public val grayLightColors: AEColors = grayColor.toLightColors()
public val grayDarkColors: AEColors = grayColor.toDarkColors()

public val defaultLightColors: AEColors = grayLightColors
public val defaultDarkColors: AEColors = grayDarkColors
