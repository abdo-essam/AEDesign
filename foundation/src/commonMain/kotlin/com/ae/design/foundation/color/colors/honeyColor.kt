package com.ae.design.foundation.color

import androidx.compose.ui.graphics.Color

internal val honeyColor = TonalPalette(
    t50 = Color(0xFFFDF9F4),
    t100 = Color(0xFFFDF3EA),
    t200 = Color(0xFFFEE8CC),
    t300 = Color(0xFFFCD7A4),
    t400 = Color(0xFFFABF74),
    t500 = Color(0xFFF0A841),
    t600 = Color(0xFFDF8D29),
    t700 = Color(0xFFC4761B),
    t800 = Color(0xFF9E611A),
    t900 = Color(0xFF754F19),
)

public val honeyLightColors: AEColors = honeyColor.toLightColors()
public val honeyDarkColors: AEColors = honeyColor.toDarkColors()
