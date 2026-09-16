package com.ae.design.foundation.color

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
public data class TonalPalette(
    public val t50: Color,
    public val t100: Color,
    public val t200: Color,
    public val t300: Color,
    public val t400: Color,
    public val t500: Color,
    public val t600: Color,
    public val t700: Color,
    public val t800: Color,
    public val t900: Color,
)

public fun TonalPalette.toLightColors(): AEColors = AEColors(
    primary = t800,
    primaryVariant = t50,
    onPrimary = Color.White,

    secondary = t700,
    secondaryVariant = t100,
    onSecondary = Color.White,

    background = t100,
    onBackground = t900,
    container = Color.White,
    containerVariant = t50,
    onContainer = t800,

    shadePrimary = t800,
    shadeSecondary = t600,
    shadeTertiary = t500,
    shadeQuaternary = t300,

    disable = t400,
    onDisable = t600,

    error = cherryColor.t600,
    errorVariant = cherryColor.t50,
    onError = cherryColor.t900,

    success = limeColor.t600,
    successVariant = limeColor.t50,
    onSuccess = limeColor.t900,

    warning = honeyColor.t500,
    warningVariant = honeyColor.t50,
    onWarning = grayColor.t900,

    info = skyColor.t600,
    infoVariant = skyColor.t50,
    onInfo = skyColor.t900,

    scrim = Color.Black.copy(alpha = 0.32f),
    shadow = Color.Black,
)

public fun TonalPalette.toDarkColors(): AEColors = AEColors(
    primary = t100,
    primaryVariant = t900,
    onPrimary = t900,

    secondary = t300,
    secondaryVariant = t800,
    onSecondary = t900,

    background = t900,
    onBackground = t100,
    container = t800,
    containerVariant = t700,
    onContainer = t100,

    shadePrimary = t100,
    shadeSecondary = t400,
    shadeTertiary = t500,
    shadeQuaternary = t700,

    disable = t600,
    onDisable = t700,

    error = cherryColor.t400,
    errorVariant = cherryColor.t900,
    onError = Color.White,

    success = limeColor.t400,
    successVariant = limeColor.t900,
    onSuccess = Color.White,

    warning = honeyColor.t400,
    warningVariant = honeyColor.t800,
    onWarning = Color.White,

    info = skyColor.t400,
    infoVariant = skyColor.t900,
    onInfo = Color.White,

    scrim = Color.Black.copy(alpha = 0.5f),
    shadow = Color.Black,
)
