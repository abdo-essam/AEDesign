package com.ae.design.foundation.color

import androidx.compose.ui.graphics.Color

internal val bananaColor = TonalPalette(
    t50 = Color(0xFFFDFBF4),
    t100 = Color(0xFFFDF7EA),
    t200 = Color(0xFFFEF0CC),
    t300 = Color(0xFFFCE4A4),
    t400 = Color(0xFFFAD374),
    t500 = Color(0xFFF0C441),
    t600 = Color(0xFFDFAD29),
    t700 = Color(0xFFC4931B),
    t800 = Color(0xFF9E781A),
    t900 = Color(0xFF756219),
)

public val bananaLightColors: AEColors = bananaColor.toLightColors()
public val bananaDarkColors: AEColors = bananaColor.toDarkColors()
