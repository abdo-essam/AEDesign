package com.ae.design.foundation.theme

import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf
import com.ae.design.foundation.color.AEColors
import com.ae.design.foundation.color.defaultLightColors
import com.ae.design.foundation.icons.AEIconPack
import com.ae.design.foundation.tokens.AEElevation
import com.ae.design.foundation.tokens.AEMotion
import com.ae.design.foundation.tokens.AERadius
import com.ae.design.foundation.tokens.AEShadow
import com.ae.design.foundation.tokens.AESpacing
import com.ae.design.foundation.typography.AETypography

public val LocalAEColors: ProvidableCompositionLocal<AEColors> =
    staticCompositionLocalOf {
        defaultLightColors
    }

public val LocalAETypography: ProvidableCompositionLocal<AETypography> =
    staticCompositionLocalOf {
        AETypography.defaultStatic()
    }

public val LocalAESpacing: ProvidableCompositionLocal<AESpacing> =
    staticCompositionLocalOf {
        AESpacing()
    }

public val LocalAERadius: ProvidableCompositionLocal<AERadius> =
    staticCompositionLocalOf {
        AERadius()
    }

public val LocalAEElevation: ProvidableCompositionLocal<AEElevation> =
    staticCompositionLocalOf {
        AEElevation()
    }

public val LocalAEShadow: ProvidableCompositionLocal<AEShadow> =
    staticCompositionLocalOf {
        AEShadow.default()
    }

public val LocalAEMotion: ProvidableCompositionLocal<AEMotion> =
    staticCompositionLocalOf {
        AEMotion()
    }

public val LocalAEIconPack: ProvidableCompositionLocal<AEIconPack> =
    staticCompositionLocalOf {
        AEIconPack.Default
    }
