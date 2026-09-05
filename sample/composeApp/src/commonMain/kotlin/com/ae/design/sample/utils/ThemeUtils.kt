package com.ae.design.sample.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import org.jetbrains.compose.resources.Font
import aedesign.sample.composeapp.generated.resources.Res
import aedesign.sample.composeapp.generated.resources.inter_black
import aedesign.sample.composeapp.generated.resources.inter_bold
import aedesign.sample.composeapp.generated.resources.inter_light
import aedesign.sample.composeapp.generated.resources.inter_medium
import aedesign.sample.composeapp.generated.resources.inter_regular
import aedesign.sample.composeapp.generated.resources.inter_semi_bold

object ThemeUtils {
    @Composable
    fun getFontFamily(): FontFamily = FontFamily(
        Font(resource = Res.font.inter_light, weight = FontWeight.Light),
        Font(resource = Res.font.inter_regular, weight = FontWeight.Normal),
        Font(resource = Res.font.inter_medium, weight = FontWeight.Medium),
        Font(resource = Res.font.inter_semi_bold, weight = FontWeight.SemiBold),
        Font(resource = Res.font.inter_bold, weight = FontWeight.Bold),
        Font(resource = Res.font.inter_black, weight = FontWeight.Black),
    )
}
