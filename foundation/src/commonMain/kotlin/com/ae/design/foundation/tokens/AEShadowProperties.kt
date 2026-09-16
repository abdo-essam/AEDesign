package com.ae.design.foundation.tokens

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Properties needed to draw a single design-system shadow layer.
 *
 * Apply via the `aeShadow` modifier extension.
 */
@Immutable
public data class AEShadowProperties(
    val offsetX: Dp,
    val offsetY: Dp,
    val blur: Dp,
    val spread: Dp,
    val color: Color,
)
