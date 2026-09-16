package com.ae.design.foundation.color.colors

import androidx.compose.ui.graphics.Color
import com.ae.design.foundation.color.AEColors
import com.ae.design.foundation.color.TonalPalette
import com.ae.design.foundation.color.toDarkColors
import com.ae.design.foundation.color.toLightColors

internal val naturalColor = TonalPalette(
    t50 = Color(0xFFFFFFFF),
    t100 = Color(0xFFFFFFFF),
    t200 = Color(0xFFFAFAFA),
    t300 = Color(0xFFEFEFEF),
    t400 = Color(0xFFDDDFDF),
    t500 = Color(0xFF9C9C9C),
    t600 = Color(0xFF737373),
    t700 = Color(0xFF616161),
    t800 = Color(0xFF454545),
    t900 = Color(0xFF262626),
)

public val naturalLightColors: AEColors = naturalColor.toLightColors()
public val naturalDarkColors: AEColors = naturalColor.toDarkColors()

