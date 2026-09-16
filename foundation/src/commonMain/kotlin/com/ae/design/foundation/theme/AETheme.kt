package com.ae.design.foundation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import com.ae.design.foundation.color.AEColors
import com.ae.design.foundation.color.defaultDarkColors
import com.ae.design.foundation.color.defaultLightColors
import com.ae.design.foundation.icons.AEIconPack
import com.ae.design.foundation.tokens.AEElevation
import com.ae.design.foundation.tokens.AEMotion
import com.ae.design.foundation.tokens.AERadius
import com.ae.design.foundation.tokens.AEShadow
import com.ae.design.foundation.tokens.AESpacing
import com.ae.design.foundation.typography.AEFontFamily
import com.ae.design.foundation.typography.AETypography

@Composable
public fun AETheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    colorScheme: AEColors = if (darkTheme) defaultDarkColors else defaultLightColors,
    typography: AETypography = AETypography.default(AEFontFamily.barlow()),
    spacing: AESpacing = AESpacing(),
    radius: AERadius = AERadius(),
    elevation: AEElevation = AEElevation(),
    shadow: AEShadow = AEShadow.default(),
    motion: AEMotion = AEMotion(),
    iconPack: AEIconPack = AEIconPack.Default,
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalAEColors provides colorScheme,
        LocalAETypography provides typography,
        LocalAESpacing provides spacing,
        LocalAERadius provides radius,
        LocalAEElevation provides elevation,
        LocalAEShadow provides shadow,
        LocalAEMotion provides motion,
        LocalAEIconPack provides iconPack,
        content = content,
    )
}

public object AETheme {
    public val colors: AEColors
        @Composable @ReadOnlyComposable
        get() = LocalAEColors.current

    public val typography: AETypography
        @Composable @ReadOnlyComposable
        get() = LocalAETypography.current

    public val spacing: AESpacing
        @Composable @ReadOnlyComposable
        get() = LocalAESpacing.current

    public val radius: AERadius
        @Composable @ReadOnlyComposable
        get() = LocalAERadius.current

    public val elevation: AEElevation
        @Composable @ReadOnlyComposable
        get() = LocalAEElevation.current

    public val shadow: AEShadow
        @Composable @ReadOnlyComposable
        get() = LocalAEShadow.current

    public val motion: AEMotion
        @Composable @ReadOnlyComposable
        get() = LocalAEMotion.current

    public val icons: AEIconPack
        @Composable @ReadOnlyComposable
        get() = LocalAEIconPack.current
}
