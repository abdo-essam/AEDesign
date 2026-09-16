package com.ae.design.foundation.tokens

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
public data class AERadius(
    public val xxxs: Dp = 2.dp,
    public val xxs: Dp = 4.dp,
    public val xs: Dp = 8.dp,
    public val sm: Dp = 12.dp,
    public val md: Dp = 16.dp,
    public val lg: Dp = 20.dp,
    public val xl: Dp = 24.dp,
    public val xxl: Dp = 28.dp,
    public val xl3: Dp = 32.dp,
    public val xl4: Dp = 48.dp,
    public val full: Dp = 9999.dp,
)
