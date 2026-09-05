package com.ae.design.sample.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ae.design.components.ui.text.AEText
import com.ae.design.foundation.theme.AETheme

@Composable
fun FooterSection() {
    val colors = AETheme.colors
    val spacing = AETheme.spacing

    Column(
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(spacing.sm),
    ) {
        AEText("AEDesign", style = AETheme.typography.headingMedium)
        AEText(
            "Built with Compose Multiplatform",
            style = AETheme.typography.bodyMedium,
            color = colors.textMuted,
        )
    }
}
