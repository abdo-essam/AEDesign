package com.ae.design.sample.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.ae.design.components.ui.card.AECard
import com.ae.design.components.ui.chip.AEChip
import com.ae.design.components.ui.text.AEText
import com.ae.design.foundation.color.AEAccent
import com.ae.design.foundation.color.AEPalette
import com.ae.design.foundation.theme.AETheme
import com.ae.design.foundation.tokens.AEStylePreset

@Composable
fun ThemeToolbar(
    palette: AEPalette,
    onPaletteChange: (AEPalette) -> Unit,
    accent: AEAccent,
    onAccentChange: (AEAccent) -> Unit,
    stylePreset: AEStylePreset,
    onStylePresetChange: (AEStylePreset) -> Unit,
) {
    AECard {
        Column(
            modifier = Modifier.fillMaxWidth().padding(AETheme.spacing.md),
            verticalArrangement = Arrangement.spacedBy(AETheme.spacing.md),
        ) {
            AEText("Palette", style = AETheme.typography.labelMedium, color = AETheme.colors.textMuted)
            Row(
                horizontalArrangement = Arrangement.spacedBy(AETheme.spacing.sm),
                modifier = Modifier.fillMaxWidth(),
            ) {
                AEPalette.entries.forEach { p ->
                    AEChip(
                        label = p.name,
                        selected = p == palette,
                        onClick = { onPaletteChange(p) },
                    )
                }
            }

            AEText("Accent", style = AETheme.typography.labelMedium, color = AETheme.colors.textMuted)
            Row(
                horizontalArrangement = Arrangement.spacedBy(AETheme.spacing.sm),
                modifier = Modifier.fillMaxWidth(),
            ) {
                AEAccent.entries.forEach { a ->
                    Box(
                        modifier = Modifier
                            .size(32.dp)
                            .clip(CircleShape)
                            .background(a.primary)
                            .then(
                                if (a == accent) {
                                    Modifier.border(2.dp, AETheme.colors.textPrimary, CircleShape)
                                } else {
                                    Modifier
                                }
                            )
                            .clickable { onAccentChange(a) },
                    )
                }
            }

            AEText("Style Preset", style = AETheme.typography.labelMedium, color = AETheme.colors.textMuted)
            Row(
                horizontalArrangement = Arrangement.spacedBy(AETheme.spacing.sm),
                modifier = Modifier.fillMaxWidth(),
            ) {
                AEStylePreset.entries.forEach { s ->
                    AEChip(
                        label = s.name,
                        selected = s == stylePreset,
                        onClick = { onStylePresetChange(s) },
                    )
                }
            }
        }
    }
}
