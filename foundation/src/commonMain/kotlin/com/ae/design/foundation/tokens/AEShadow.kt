package com.ae.design.foundation.tokens

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ae.design.foundation.color.ColorPalette

/**
 * Shadow token scale (xs → xl3).
 *
 * Access via [AETheme.shadow].
 */
@Immutable
public data class AEShadow(
    val xs: AEShadowProperties,
    val sm: AEShadowProperties,
    val md: AEShadowProperties,
    val lg: AEShadowProperties,
    val xl: AEShadowProperties,
    val xl2: AEShadowProperties,
    val xl3: AEShadowProperties,
) {
    public companion object {

        private val defaultColor = ColorPalette.gray.t900

        public fun default(): AEShadow = AEShadow(
            xs = AEShadowProperties(offsetX = 0.dp, offsetY = 1.dp,  blur = 2.dp,  spread = 0.dp, color = defaultColor.copy(alpha = 0.08f)),
            sm = AEShadowProperties(offsetX = 0.dp, offsetY = 2.dp,  blur = 4.dp,  spread = 0.dp, color = defaultColor.copy(alpha = 0.10f)),
            md = AEShadowProperties(offsetX = 0.dp, offsetY = 4.dp,  blur = 8.dp,  spread = 0.dp, color = defaultColor.copy(alpha = 0.12f)),
            lg = AEShadowProperties(offsetX = 0.dp, offsetY = 8.dp,  blur = 16.dp, spread = 0.dp, color = defaultColor.copy(alpha = 0.14f)),
            xl = AEShadowProperties(offsetX = 0.dp, offsetY = 12.dp, blur = 24.dp, spread = 0.dp, color = defaultColor.copy(alpha = 0.16f)),
            xl2 = AEShadowProperties(offsetX = 0.dp, offsetY = 16.dp, blur = 32.dp, spread = 0.dp, color = defaultColor.copy(alpha = 0.18f)),
            xl3 = AEShadowProperties(offsetX = 0.dp, offsetY = 24.dp, blur = 48.dp, spread = 0.dp, color = defaultColor.copy(alpha = 0.20f)),
        )
    }
}
