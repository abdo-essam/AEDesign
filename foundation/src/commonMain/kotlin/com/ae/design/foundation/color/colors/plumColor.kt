package com.ae.design.foundation.color

import androidx.compose.ui.graphics.Color

internal val plumColor = TonalPalette(
    t50 = Color(0xFFFBF4FD),
    t100 = Color(0xFFF7EAFD),
    t200 = Color(0xFFEECCFE),
    t300 = Color(0xFFDEA4FC),
    t400 = Color(0xFFC974FA),
    t500 = Color(0xFFB341F0),
    t600 = Color(0xFF9629DF),
    t700 = Color(0xFF7B1BC5),
    t800 = Color(0xFF631A9E),
    t900 = Color(0xFF501975),
)

public val plumLightColors: AEColors = plumColor.toLightColors()
public val plumDarkColors: AEColors = plumColor.toDarkColors()
