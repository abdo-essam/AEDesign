package com.ae.design.sample.docs.components

import aedesign.sample.composeapp.generated.resources.Res
import aedesign.sample.composeapp.generated.resources.docs_components
import aedesign.sample.composeapp.generated.resources.docs_getting_started
import aedesign.sample.composeapp.generated.resources.docs_search_placeholder
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import com.ae.design.components.ui.text.AEText
import com.ae.design.components.ui.textfield.AETextField
import com.ae.design.foundation.theme.AETheme
import com.ae.design.sample.docs.catalog.ComponentCategory
import com.ae.design.sample.docs.catalog.ComponentEntry
import com.ae.design.sample.docs.catalog.guidePages
import org.jetbrains.compose.resources.stringResource

@Composable
fun DocsSidebar(
    grouped: Map<ComponentCategory, List<ComponentEntry>>,
    selectedId: String,
    onSelect: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    var searchQuery by remember { mutableStateOf("") }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(AETheme.spacing.xs),
    ) {
        // ─── Search Field ──────────────────────────────────
        AETextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            placeholder = stringResource(Res.string.docs_search_placeholder),
            modifier = Modifier.fillMaxWidth().padding(bottom = AETheme.spacing.sm),
        )

        val query = searchQuery.trim().lowercase()

        // ─── Getting Started ───────────────────────────────
        val filteredGuides = if (query.isEmpty()) {
            guidePages
        } else {
            guidePages.filter { page ->
                page.id.lowercase().contains(query)
            }
        }

        if (filteredGuides.isNotEmpty()) {
            AEText(
                text = stringResource(Res.string.docs_getting_started),
                style = AETheme.typography.headingSmall.copy(color = AETheme.colors.accent),
            )

            Spacer(Modifier.height(AETheme.spacing.xs))

            filteredGuides.forEach { page ->
                SidebarItem(
                    name = stringResource(page.nameRes),
                    isSelected = page.id == selectedId,
                    onClick = { onSelect(page.id) },
                )
            }

            Spacer(Modifier.height(AETheme.spacing.lg))
        }

        // ─── Components ────────────────────────────────────
        val filteredGrouped = if (query.isEmpty()) {
            grouped
        } else {
            grouped.mapValues { (_, entries) ->
                entries.filter { entry ->
                    entry.rawName.lowercase().contains(query) ||
                    entry.rawDescription.lowercase().contains(query)
                }
            }.filterValues { it.isNotEmpty() }
        }

        if (filteredGrouped.isNotEmpty()) {
            AEText(
                text = stringResource(Res.string.docs_components),
                style = AETheme.typography.headingSmall.copy(color = AETheme.colors.accent),
            )

            Spacer(Modifier.height(AETheme.spacing.xs))

            filteredGrouped.forEach { (category, entries) ->
                Spacer(Modifier.height(AETheme.spacing.sm))

                BasicText(
                    text = stringResource(category.labelRes),
                    style = AETheme.typography.labelSmall.copy(
                        color = AETheme.colors.textMuted,
                        fontWeight = FontWeight.SemiBold
                    ),
                    modifier = Modifier.padding(vertical = AETheme.spacing.xs),
                )

                entries.forEach { entry ->
                    SidebarItem(
                        name = stringResource(entry.nameRes),
                        isSelected = entry.id == selectedId,
                        onClick = { onSelect(entry.id) },
                    )
                }
            }
        }
    }
}

@Composable
private fun SidebarItem(
    name: String,
    isSelected: Boolean,
    onClick: () -> Unit,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()

    val bg = when {
        isSelected -> AETheme.colors.surfaceHover
        isHovered -> AETheme.colors.backgroundSecondary
        else -> AETheme.colors.background
    }

    val fg = if (isSelected) {
        AETheme.colors.textPrimary
    } else {
        AETheme.colors.textSecondary
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .hoverable(interactionSource)
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick,
            )
            .background(bg, androidx.compose.foundation.shape.RoundedCornerShape(AETheme.radius.md))
            .clip(androidx.compose.foundation.shape.RoundedCornerShape(AETheme.radius.md))
            .padding(
                horizontal = AETheme.spacing.sm,
                vertical = AETheme.spacing.xs,
            ),
    ) {
        BasicText(
            text = name,
            style = AETheme.typography.bodySmall.copy(
                color = fg,
                fontWeight = if (isSelected) FontWeight.Medium else FontWeight.Normal
            ),
        )
    }
}
