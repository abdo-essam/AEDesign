package com.ae.design.foundation.tokens

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
public data class AEElevation(
    public val none: Dp = 0.dp,
    public val sm: Dp = 2.dp,
    public val md: Dp = 4.dp,
    public val lg: Dp = 8.dp,
    public val xl: Dp = 16.dp,
)
