package com.ae.design.foundation.color

import androidx.compose.ui.graphics.Color

internal val coffeeColor = TonalPalette(
    t50 = Color(0xFFFDFAF6),
    t100 = Color(0xFFFBF4EE),
    t200 = Color(0xFFF7E4D4),
    t300 = Color(0xFFEFCFB3),
    t400 = Color(0xFFE5B58B),
    t500 = Color(0xFFD29560),
    t600 = Color(0xFFBA814F),
    t700 = Color(0xFFA46D3D),
    t800 = Color(0xFF825935),
    t900 = Color(0xFF60462E),
)

public val coffeeLightColors: AEColors = coffeeColor.toLightColors()
public val coffeeDarkColors: AEColors = coffeeColor.toDarkColors()
