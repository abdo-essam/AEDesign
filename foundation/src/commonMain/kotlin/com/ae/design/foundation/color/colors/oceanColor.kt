package com.ae.design.foundation.color

import androidx.compose.ui.graphics.Color

internal val oceanColor = TonalPalette(
    t50 = Color(0xFFF4F7FD),
    t100 = Color(0xFFEAEEFD),
    t200 = Color(0xFFCCD9FE),
    t300 = Color(0xFFA4BBFC),
    t400 = Color(0xFF7496FA),
    t500 = Color(0xFF416DF0),
    t600 = Color(0xFF2957DF),
    t700 = Color(0xFF1B45C5),
    t800 = Color(0xFF1A3B9E),
    t900 = Color(0xFF193075),
)

public val oceanLightColors: AEColors = oceanColor.toLightColors()
public val oceanDarkColors: AEColors = oceanColor.toDarkColors()
