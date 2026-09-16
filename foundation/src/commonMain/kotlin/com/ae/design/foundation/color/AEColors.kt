package com.ae.design.foundation.color

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
public data class AEColors(
    public val primary: Color,
    public val primaryVariant: Color,
    public val onPrimary: Color,

    public val secondary: Color,
    public val secondaryVariant: Color,
    public val onSecondary: Color,

    public val background: Color,
    public val onBackground: Color,
    public val container: Color,
    public val containerVariant: Color,
    public val onContainer: Color,

    public val shadePrimary: Color,
    public val shadeSecondary: Color,
    public val shadeTertiary: Color,
    public val shadeQuaternary: Color,

    public val disable: Color,
    public val onDisable: Color,

    public val error: Color,
    public val errorVariant: Color,
    public val onError: Color,

    public val success: Color,
    public val successVariant: Color,
    public val onSuccess: Color,

    public val warning: Color,
    public val warningVariant: Color,
    public val onWarning: Color,

    public val info: Color,
    public val infoVariant: Color,
    public val onInfo: Color,

    public val scrim: Color,
    public val shadow: Color,
)
