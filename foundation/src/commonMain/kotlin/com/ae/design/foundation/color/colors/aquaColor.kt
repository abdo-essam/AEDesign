package com.ae.design.foundation.color

import androidx.compose.ui.graphics.Color

internal val aquaColor = TonalPalette(
    t50 = Color(0xFFF4FDFD),
    t100 = Color(0xFFEAFDFD),
    t200 = Color(0xFFCCFEFE),
    t300 = Color(0xFFA4FCFC),
    t400 = Color(0xFF74FAFA),
    t500 = Color(0xFF41F0F0),
    t600 = Color(0xFF29DFDF),
    t700 = Color(0xFF1BC5C5),
    t800 = Color(0xFF1A9E9E),
    t900 = Color(0xFF197676),
)

public val aquaLightColors: AEColors = aquaColor.toLightColors()
public val aquaDarkColors: AEColors = aquaColor.toDarkColors()
