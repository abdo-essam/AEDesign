package com.ae.design.foundation.color

import androidx.compose.ui.graphics.Color

internal val mintColor = TonalPalette(
    t50 = Color(0xFFF4FDF8),
    t100 = Color(0xFFEAFDF3),
    t200 = Color(0xFFCCFEE4),
    t300 = Color(0xFFA4FCCB),
    t400 = Color(0xFF74FAAE),
    t500 = Color(0xFF41F08F),
    t600 = Color(0xFF29DF74),
    t700 = Color(0xFF1BC45E),
    t800 = Color(0xFF1A9E4E),
    t900 = Color(0xFF197540),
)

public val mintLightColors: AEColors = mintColor.toLightColors()
public val mintDarkColors: AEColors = mintColor.toDarkColors()
