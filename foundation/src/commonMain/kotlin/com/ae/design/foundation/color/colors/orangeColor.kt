package com.ae.design.foundation.color

import androidx.compose.ui.graphics.Color

internal val orangeColor = TonalPalette(
    t50 = Color(0xFFFDF8F4),
    t100 = Color(0xFFFDF1EA),
    t200 = Color(0xFFFEDFCC),
    t300 = Color(0xFFFCC8A4),
    t400 = Color(0xFFFAA974),
    t500 = Color(0xFFF08A41),
    t600 = Color(0xFFDF6F29),
    t700 = Color(0xFFC45A1B),
    t800 = Color(0xFF9E4C1A),
    t900 = Color(0xFF754019),
)

public val orangeLightColors: AEColors = orangeColor.toLightColors()
public val orangeDarkColors: AEColors = orangeColor.toDarkColors()
