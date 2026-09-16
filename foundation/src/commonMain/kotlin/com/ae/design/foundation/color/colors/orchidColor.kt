package com.ae.design.foundation.color

import androidx.compose.ui.graphics.Color

internal val orchidColor = TonalPalette(
    t50 = Color(0xFFFDF4FD),
    t100 = Color(0xFFFDEAFD),
    t200 = Color(0xFFFECCFE),
    t300 = Color(0xFFFCA4FC),
    t400 = Color(0xFFFA74FA),
    t500 = Color(0xFFF041F0),
    t600 = Color(0xFFDF29DF),
    t700 = Color(0xFFC51BC5),
    t800 = Color(0xFF9E1A9E),
    t900 = Color(0xFF761976),
)

public val orchidLightColors: AEColors = orchidColor.toLightColors()
public val orchidDarkColors: AEColors = orchidColor.toDarkColors()
