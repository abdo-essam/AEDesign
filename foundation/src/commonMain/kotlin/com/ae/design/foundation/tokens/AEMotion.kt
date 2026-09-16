package com.ae.design.foundation.tokens

import androidx.compose.animation.core.CubicBezierEasing
import androidx.compose.animation.core.Easing
import androidx.compose.runtime.Immutable

@Immutable
public data class AEMotion(
    public val durationFast: Int = 150,
    public val durationMedium: Int = 250,
    public val durationSlow: Int = 400,
    public val easingStandard: Easing = CubicBezierEasing(0.2f, 0f, 0f, 1f),
    public val easingEmphasized: Easing = CubicBezierEasing(0.05f, 0.7f, 0.1f, 1f),
    public val easingDecelerate: Easing = CubicBezierEasing(0f, 0f, 0.2f, 1f),
)
