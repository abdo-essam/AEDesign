package com.ae.design.foundation.color

import androidx.compose.ui.graphics.Color

internal val cherryColor = TonalPalette(
    t50 = Color(0xFFFEF5F5),
    t100 = Color(0xFFFEEBEB),
    t200 = Color(0xFFFECDCD),
    t300 = Color(0xFFFDA5A5),
    t400 = Color(0xFFFA7575),
    t500 = Color(0xFFF14141),
    t600 = Color(0xFFDF2A2A),
    t700 = Color(0xFFC51B1B),
    t800 = Color(0xFF9E1A1A),
    t900 = Color(0xFF761919),
)

public val cherryLightColors: AEColors = cherryColor.toLightColors()
public val cherryDarkColors: AEColors = cherryColor.toDarkColors()
