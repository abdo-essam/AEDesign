package com.ae.design.sample

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ae.design.foundation.color.AEColors

import com.ae.design.foundation.color.ColorPalette
import com.ae.design.foundation.color.TonalPalette
import com.ae.design.foundation.color.defaultDarkColors
import com.ae.design.foundation.color.defaultLightColors
import com.ae.design.foundation.theme.AETheme

@Composable
private fun Text(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    fontSize: TextUnit = TextUnit.Unspecified,
    fontWeight: FontWeight? = null,
    fontFamily: FontFamily? = null,
) {
    BasicText(
        text = text,
        modifier = modifier,
        style = TextStyle(
            color = color,
            fontSize = fontSize,
            fontWeight = fontWeight,
            fontFamily = fontFamily,
        ),
    )
}

private enum class ColorSection(val title: String) {
    Semantic("Semantic Tokens"),
    TonalPalettes("Tonal Palettes (20)"),
    ComponentsPreview("UI Component Preview"),
}

public data class ThemePaletteOption(
    val name: String,
    val palette: TonalPalette,
)

public val AllThemePaletteOptions: List<ThemePaletteOption> = listOf(
    ThemePaletteOption("Gray", ColorPalette.gray),
    ThemePaletteOption("Sky", ColorPalette.sky),
    ThemePaletteOption("Royal", ColorPalette.royal),
    ThemePaletteOption("Ocean", ColorPalette.ocean),
    ThemePaletteOption("Aqua", ColorPalette.aqua),
    ThemePaletteOption("Mint", ColorPalette.mint),
    ThemePaletteOption("Leaf", ColorPalette.leaf),
    ThemePaletteOption("Lime", ColorPalette.lime),
    ThemePaletteOption("Honey", ColorPalette.honey),
    ThemePaletteOption("Banana", ColorPalette.banana),
    ThemePaletteOption("Orange", ColorPalette.orange),
    ThemePaletteOption("Apricot", ColorPalette.apricot),
    ThemePaletteOption("Cherry", ColorPalette.cherry),
    ThemePaletteOption("Rose", ColorPalette.rose),
    ThemePaletteOption("Raspberry", ColorPalette.raspberry),
    ThemePaletteOption("Blossom", ColorPalette.blossom),
    ThemePaletteOption("Plum", ColorPalette.plum),
    ThemePaletteOption("Orchid", ColorPalette.orchid),
    ThemePaletteOption("Coffee", ColorPalette.coffee),
    ThemePaletteOption("Natural", ColorPalette.natural),
)

@Composable
public fun ColorTestApp() {
    var isDark by remember { mutableStateOf(false) }
    var selectedPrimary by remember { mutableStateOf(AllThemePaletteOptions[0]) } // Gray (default)
    var selectedSecondary by remember { mutableStateOf(AllThemePaletteOptions[0]) } // Gray (default)

    val activeColors = remember(selectedPrimary, selectedSecondary, isDark) {
        val base = if (isDark) defaultDarkColors else defaultLightColors
        if (selectedPrimary.name == "Gray" && selectedSecondary.name == "Gray") {
            base
        } else {
            base.copy(
                primary = if (isDark) selectedPrimary.palette.t100 else selectedPrimary.palette.t800,
                primaryVariant = if (isDark) selectedPrimary.palette.t900 else selectedPrimary.palette.t50,
                secondary = if (isDark) selectedSecondary.palette.t300 else selectedSecondary.palette.t700,
                secondaryVariant = if (isDark) selectedSecondary.palette.t800 else selectedSecondary.palette.t100,
            )
        }
    }

    AETheme(
        darkTheme = isDark,
        colorScheme = activeColors,
    ) {
        ColorTestScreen(
            isDark = isDark,
            onToggleTheme = { isDark = !isDark },
            selectedPrimary = selectedPrimary,
            onSelectPrimary = { selectedPrimary = it },
            selectedSecondary = selectedSecondary,
            onSelectSecondary = { selectedSecondary = it },
        )
    }
}

@Composable
public fun ColorTestScreen(
    isDark: Boolean,
    onToggleTheme: () -> Unit,
    selectedPrimary: ThemePaletteOption = AllThemePaletteOptions[0],
    onSelectPrimary: (ThemePaletteOption) -> Unit = {},
    selectedSecondary: ThemePaletteOption = AllThemePaletteOptions[0],
    onSelectSecondary: (ThemePaletteOption) -> Unit = {},
    modifier: Modifier = Modifier,
) {
    var selectedSection by remember { mutableStateOf(ColorSection.Semantic) }
    var searchQuery by remember { mutableStateOf("") }
    var selectedColorInfo by remember { mutableStateOf<Pair<String, Color>?>(null) }

    val colors = AETheme.colors

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(colors.background),
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            // ── Top Bar ──
            HeaderBar(
                isDark = isDark,
                onToggleTheme = onToggleTheme,
                colors = colors,
            )

            // ── Live Theme Palette Switcher Bar ──
            LivePaletteSwitcherBar(
                selectedPrimary = selectedPrimary,
                onSelectPrimary = onSelectPrimary,
                selectedSecondary = selectedSecondary,
                onSelectSecondary = onSelectSecondary,
                colors = colors,
            )

            // ── Tab Navigation & Search ──
            NavigationAndSearch(
                selectedSection = selectedSection,
                onSelectSection = { selectedSection = it },
                searchQuery = searchQuery,
                onSearchChange = { searchQuery = it },
                colors = colors,
            )

            // ── Main Content ──
            Box(modifier = Modifier.weight(1f).fillMaxWidth()) {
                when (selectedSection) {
                    ColorSection.Semantic -> SemanticTokensView(
                        colors = colors,
                        searchQuery = searchQuery,
                        onSelectColor = { name, color -> selectedColorInfo = name to color },
                    )
                    ColorSection.TonalPalettes -> TonalPalettesView(
                        searchQuery = searchQuery,
                        colors = colors,
                        selectedPrimaryName = selectedPrimary.name,
                        selectedSecondaryName = selectedSecondary.name,
                        onSelectPrimary = onSelectPrimary,
                        onSelectSecondary = onSelectSecondary,
                        onSelectColor = { name, color -> selectedColorInfo = name to color },
                    )
                    ColorSection.ComponentsPreview -> ComponentsPreviewView(
                        colors = colors,
                        selectedPrimary = selectedPrimary,
                        selectedSecondary = selectedSecondary,
                        isDark = isDark,
                    )
                }
            }

            // ── Selected Color Floating Inspector ──
            selectedColorInfo?.let { (name, color) ->
                SelectedColorFooter(
                    name = name,
                    color = color,
                    colors = colors,
                    onDismiss = { selectedColorInfo = null },
                )
            }
        }
    }
}

// ─────────────────────────────────────────────────────────────────────────────
// Header & Navigation
// ─────────────────────────────────────────────────────────────────────────────

@Composable
private fun HeaderBar(
    isDark: Boolean,
    onToggleTheme: () -> Unit,
    colors: AEColors,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(colors.container)
            .padding(horizontal = 20.dp, vertical = 14.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column {
            Text(
                text = "AEDesign Color System",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = colors.shadePrimary,
            )
            Text(
                text = "AEDesign Architecture · 20 Tonal Palettes + Semantic Token Scale",
                fontSize = 12.sp,
                color = colors.shadeSecondary,
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .background(colors.containerVariant)
                .clickable { onToggleTheme() }
                .padding(horizontal = 14.dp, vertical = 8.dp),
        ) {
            Box(
                modifier = Modifier
                    .size(10.dp)
                    .clip(CircleShape)
                    .background(if (isDark) ColorPalette.royal.t400 else ColorPalette.honey.t400),
            )
            Text(
                text = if (isDark) "Dark Mode" else "Light Mode",
                fontSize = 13.sp,
                fontWeight = FontWeight.SemiBold,
                color = colors.shadePrimary,
            )
        }
    }
}

private enum class PaletteSwitcherMode(val label: String) {
    Primary("Primary (20)"),
    Secondary("Secondary (20)"),
}

@Composable
private fun LivePaletteSwitcherBar(
    selectedPrimary: ThemePaletteOption,
    onSelectPrimary: (ThemePaletteOption) -> Unit,
    selectedSecondary: ThemePaletteOption,
    onSelectSecondary: (ThemePaletteOption) -> Unit,
    colors: AEColors,
) {
    var currentMode by remember { mutableStateOf(PaletteSwitcherMode.Primary) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(colors.container)
            .border(1.dp, colors.shadeQuaternary)
            .padding(horizontal = 20.dp, vertical = 10.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        // Top status and selector tabs row
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            // Left: status indicators
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Text(
                    text = "Live Re-Theming:",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = colors.shadeSecondary,
                )

                // Primary pill
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(5.dp),
                    modifier = Modifier
                        .clip(RoundedCornerShape(14.dp))
                        .background(if (currentMode == PaletteSwitcherMode.Primary) colors.primaryVariant else colors.containerVariant)
                        .border(
                            1.dp,
                            if (currentMode == PaletteSwitcherMode.Primary) colors.primary else colors.shadeQuaternary,
                            RoundedCornerShape(14.dp),
                        )
                        .clickable { currentMode = PaletteSwitcherMode.Primary }
                        .padding(horizontal = 8.dp, vertical = 3.dp),
                ) {
                    Box(
                        modifier = Modifier
                            .size(9.dp)
                            .clip(CircleShape)
                            .background(selectedPrimary.palette.t500),
                    )
                    Text(
                        text = "Primary: ${selectedPrimary.name}",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = if (currentMode == PaletteSwitcherMode.Primary) colors.primary else colors.shadePrimary,
                    )
                }

                // Secondary pill
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(5.dp),
                    modifier = Modifier
                        .clip(RoundedCornerShape(14.dp))
                        .background(if (currentMode == PaletteSwitcherMode.Secondary) colors.secondaryVariant else colors.containerVariant)
                        .border(
                            1.dp,
                            if (currentMode == PaletteSwitcherMode.Secondary) colors.secondary else colors.shadeQuaternary,
                            RoundedCornerShape(14.dp),
                        )
                        .clickable { currentMode = PaletteSwitcherMode.Secondary }
                        .padding(horizontal = 8.dp, vertical = 3.dp),
                ) {
                    Box(
                        modifier = Modifier
                            .size(9.dp)
                            .clip(CircleShape)
                            .background(selectedSecondary.palette.t500),
                    )
                    Text(
                        text = "Secondary: ${selectedSecondary.name}",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = if (currentMode == PaletteSwitcherMode.Secondary) colors.secondary else colors.shadePrimary,
                    )
                }
            }

            // Right: Mode tabs
            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                PaletteSwitcherMode.entries.forEach { mode ->
                    val isModeSelected = mode == currentMode
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(6.dp))
                            .background(if (isModeSelected) colors.primary else colors.containerVariant)
                            .clickable { currentMode = mode }
                            .padding(horizontal = 8.dp, vertical = 4.dp),
                    ) {
                        Text(
                            text = mode.label,
                            fontSize = 11.sp,
                            fontWeight = if (isModeSelected) FontWeight.Bold else FontWeight.Medium,
                            color = if (isModeSelected) colors.onPrimary else colors.shadeSecondary,
                        )
                    }
                }
            }
        }

        // Palette selector row
        when (currentMode) {
            PaletteSwitcherMode.Primary -> {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    items(AllThemePaletteOptions) { option ->
                        val isSelected = option.name == selectedPrimary.name
                        PaletteChip(
                            option = option,
                            isSelected = isSelected,
                            activeColor = colors.primary,
                            activeBg = colors.primaryVariant,
                            colors = colors,
                            onClick = { onSelectPrimary(option) },
                        )
                    }
                }
            }
            PaletteSwitcherMode.Secondary -> {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    items(AllThemePaletteOptions) { option ->
                        val isSelected = option.name == selectedSecondary.name
                        PaletteChip(
                            option = option,
                            isSelected = isSelected,
                            activeColor = colors.secondary,
                            activeBg = colors.secondaryVariant,
                            colors = colors,
                            onClick = { onSelectSecondary(option) },
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun PaletteChip(
    option: ThemePaletteOption,
    isSelected: Boolean,
    activeColor: Color,
    activeBg: Color,
    colors: AEColors,
    onClick: () -> Unit,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .background(if (isSelected) activeBg else colors.containerVariant)
            .border(
                width = if (isSelected) 1.5.dp else 1.dp,
                color = if (isSelected) activeColor else colors.shadeQuaternary,
                shape = RoundedCornerShape(8.dp),
            )
            .clickable { onClick() }
            .padding(horizontal = 10.dp, vertical = 6.dp),
    ) {
        Box(
            modifier = Modifier
                .size(14.dp)
                .clip(CircleShape)
                .background(option.palette.t500)
                .border(1.dp, Color.White.copy(alpha = 0.5f), CircleShape),
        )
        Text(
            text = if (isSelected) "V ${option.name}" else option.name,
            fontSize = 12.sp,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
            color = if (isSelected) activeColor else colors.shadePrimary,
        )
    }
}


@Composable
private fun NavigationAndSearch(
    selectedSection: ColorSection,
    onSelectSection: (ColorSection) -> Unit,
    searchQuery: String,
    onSearchChange: (String) -> Unit,
    colors: AEColors,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(colors.container)
            .padding(horizontal = 20.dp, vertical = 10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        // Tabs
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth(),
        ) {
            items(ColorSection.entries) { section ->
                val isSelected = section == selectedSection
                val bg = if (isSelected) colors.primary else colors.containerVariant
                val textColor = if (isSelected) colors.onPrimary else colors.shadeSecondary

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(bg)
                        .clickable { onSelectSection(section) }
                        .padding(horizontal = 14.dp, vertical = 8.dp),
                ) {
                    Text(
                        text = section.title,
                        fontSize = 13.sp,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                        color = textColor,
                    )
                }
            }
        }

        // Search Input
        if (selectedSection != ColorSection.ComponentsPreview) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .background(colors.containerVariant)
                    .border(1.dp, colors.shadeQuaternary, RoundedCornerShape(8.dp))
                    .padding(horizontal = 12.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "S",
                    fontSize = 14.sp,
                    modifier = Modifier.padding(end = 8.dp),
                )
                BasicTextField(
                    value = searchQuery,
                    onValueChange = onSearchChange,
                    textStyle = TextStyle(
                        fontSize = 13.sp,
                        color = colors.shadePrimary,
                    ),
                    cursorBrush = SolidColor(colors.primary),
                    singleLine = true,
                    modifier = Modifier.weight(1f),
                    decorationBox = { innerTextField ->
                        if (searchQuery.isEmpty()) {
                            Text(
                                text = "Search colors by token name (e.g. primary, error, sky, 500)...",
                                fontSize = 13.sp,
                                color = colors.shadeTertiary,
                            )
                        }
                        innerTextField()
                    },
                )
                if (searchQuery.isNotEmpty()) {
                    Text(
                        text = "X",
                        fontSize = 13.sp,
                        color = colors.shadeSecondary,
                        modifier = Modifier
                            .clickable { onSearchChange("") }
                            .padding(start = 6.dp),
                    )
                }
            }
        }
    }
}

// ─────────────────────────────────────────────────────────────────────────────
// Section 1: Semantic Tokens View
// ─────────────────────────────────────────────────────────────────────────────

private data class TokenGroup(
    val title: String,
    val description: String,
    val tokens: List<Pair<String, Color>>,
)

@Composable
private fun SemanticTokensView(
    colors: AEColors,
    searchQuery: String,
    onSelectColor: (String, Color) -> Unit,
) {
    val groups = remember(colors) {
        listOf(
            TokenGroup(
                title = "Primary",
                description = "Primary interactive surfaces and core accent tokens",
                tokens = listOf(
                    "primary" to colors.primary,
                    "primaryVariant" to colors.primaryVariant,
                    "onPrimary" to colors.onPrimary,
                ),
            ),
            TokenGroup(
                title = "Secondary",
                description = "Secondary accents, supporting actions, and highlights",
                tokens = listOf(
                    "secondary" to colors.secondary,
                    "secondaryVariant" to colors.secondaryVariant,
                    "onSecondary" to colors.onSecondary,
                ),
            ),
            TokenGroup(
                title = "Surfaces & Containers",
                description = "Background canvas, elevation cards, and grouped containers",
                tokens = listOf(
                    "background" to colors.background,
                    "onBackground" to colors.onBackground,
                    "container" to colors.container,
                    "containerVariant" to colors.containerVariant,
                    "onContainer" to colors.onContainer,
                ),
            ),
            TokenGroup(
                title = "Text & Border Shades",
                description = "Hierarchy levels for text, icons, dividers, and outlines",
                tokens = listOf(
                    "shadePrimary" to colors.shadePrimary,
                    "shadeSecondary" to colors.shadeSecondary,
                    "shadeTertiary" to colors.shadeTertiary,
                    "shadeQuaternary" to colors.shadeQuaternary,
                ),
            ),
            TokenGroup(
                title = "Interactive States",
                description = "Disabled and inactive component styling",
                tokens = listOf(
                    "disable" to colors.disable,
                    "onDisable" to colors.onDisable,
                ),
            ),
            TokenGroup(
                title = "Feedback: Success",
                description = "Successful operations, confirmations, positive metrics",
                tokens = listOf(
                    "success" to colors.success,
                    "successVariant" to colors.successVariant,
                    "onSuccess" to colors.onSuccess,
                ),
            ),
            TokenGroup(
                title = "Feedback: Warning",
                description = "Cautionary notices, pending states, non-blocking alerts",
                tokens = listOf(
                    "warning" to colors.warning,
                    "warningVariant" to colors.warningVariant,
                    "onWarning" to colors.onWarning,
                ),
            ),
            TokenGroup(
                title = "Feedback: Error & Destructive",
                description = "Critical errors, validation failures, delete actions",
                tokens = listOf(
                    "error" to colors.error,
                    "errorVariant" to colors.errorVariant,
                    "onError" to colors.onError,
                ),
            ),
            TokenGroup(
                title = "Feedback: Info",
                description = "Informational messages, neutral tips, system highlights",
                tokens = listOf(
                    "info" to colors.info,
                    "infoVariant" to colors.infoVariant,
                    "onInfo" to colors.onInfo,
                ),
            ),
            TokenGroup(
                title = "Overlays & Elevation",
                description = "Modals backdrop scrim and shadow ambient color",
                tokens = listOf(
                    "scrim" to colors.scrim,
                    "shadow" to colors.shadow,
                ),
            ),
        )
    }

    val filteredGroups = remember(groups, searchQuery) {
        if (searchQuery.isBlank()) groups
        else {
            groups.mapNotNull { group ->
                val matchingTokens = group.tokens.filter { (name, _) ->
                    name.contains(searchQuery, ignoreCase = true) ||
                        group.title.contains(searchQuery, ignoreCase = true)
                }
                if (matchingTokens.isNotEmpty()) group.copy(tokens = matchingTokens) else null
            }
        }
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        items(filteredGroups) { group ->
            TokenGroupCard(
                group = group,
                colors = colors,
                onSelectColor = onSelectColor,
            )
        }
    }
}

@Composable
private fun TokenGroupCard(
    group: TokenGroup,
    colors: AEColors,
    onSelectColor: (String, Color) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(colors.container)
            .border(1.dp, colors.shadeQuaternary, RoundedCornerShape(12.dp))
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Column {
            Text(
                text = group.title,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = colors.shadePrimary,
            )
            Text(
                text = group.description,
                fontSize = 12.sp,
                color = colors.shadeSecondary,
            )
        }

        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            group.tokens.forEach { (name, color) ->
                TokenRow(
                    name = name,
                    color = color,
                    colors = colors,
                    onClick = { onSelectColor(name, color) },
                )
            }
        }
    }
}

@Composable
private fun TokenRow(
    name: String,
    color: Color,
    colors: AEColors,
    onClick: () -> Unit,
) {
    val hex = color.toHex()

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(colors.containerVariant)
            .clickable { onClick() }
            .padding(horizontal = 12.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            Box(
                modifier = Modifier
                    .size(36.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(color)
                    .border(1.dp, colors.shadeQuaternary, RoundedCornerShape(8.dp)),
            )

            Column {
                Text(
                    text = name,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = colors.shadePrimary,
                )
                Text(
                    text = hex,
                    fontSize = 11.sp,
                    fontFamily = FontFamily.Monospace,
                    color = colors.shadeSecondary,
                )
            }
        }

        // Contrast Preview Pill
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(6.dp))
                .background(color)
                .padding(horizontal = 10.dp, vertical = 4.dp),
        ) {
            val textColor = if (color.luminance() > 0.5f) Color.Black else Color.White
            Text(
                text = "Preview",
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = textColor,
            )
        }
    }
}


// ─────────────────────────────────────────────────────────────────────────────
// Section 3: Tonal Palettes View
// ─────────────────────────────────────────────────────────────────────────────

@Composable
private fun TonalPalettesView(
    searchQuery: String,
    colors: AEColors,
    selectedPrimaryName: String,
    selectedSecondaryName: String,
    onSelectPrimary: (ThemePaletteOption) -> Unit,
    onSelectSecondary: (ThemePaletteOption) -> Unit,
    onSelectColor: (String, Color) -> Unit,
) {
    val allPalettes = remember { AllThemePaletteOptions }

    val filteredPalettes = remember(allPalettes, searchQuery) {
        if (searchQuery.isBlank()) allPalettes
        else allPalettes.filter { it.name.contains(searchQuery, ignoreCase = true) }
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        // 20 Tonal Palette Rows
        items(filteredPalettes) { named ->
            PaletteRowCard(
                named = named,
                colors = colors,
                selectedPrimaryName = selectedPrimaryName,
                selectedSecondaryName = selectedSecondaryName,
                onSelectPrimary = onSelectPrimary,
                onSelectSecondary = onSelectSecondary,
                onSelectColor = onSelectColor,
            )
        }

        // Base single colors
        item {
            BaseSinglesCard(colors = colors, onSelectColor = onSelectColor)
        }
    }
}


@Composable
private fun PaletteRowCard(
    named: ThemePaletteOption,
    colors: AEColors,
    selectedPrimaryName: String,
    selectedSecondaryName: String,
    onSelectPrimary: (ThemePaletteOption) -> Unit,
    onSelectSecondary: (ThemePaletteOption) -> Unit,
    onSelectColor: (String, Color) -> Unit,
) {
    val steps = remember(named) {
        listOf(
            "t50" to named.palette.t50,
            "t100" to named.palette.t100,
            "t200" to named.palette.t200,
            "t300" to named.palette.t300,
            "t400" to named.palette.t400,
            "t500" to named.palette.t500,
            "t600" to named.palette.t600,
            "t700" to named.palette.t700,
            "t800" to named.palette.t800,
            "t900" to named.palette.t900,
        )
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(colors.container)
            .border(1.dp, colors.shadeQuaternary, RoundedCornerShape(12.dp))
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Text(
                    text = "${named.name} Palette",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = colors.shadePrimary,
                )
                Text(
                    text = "10 steps (50→900)",
                    fontSize = 11.sp,
                    color = colors.shadeTertiary,
                )
            }

            // Quick Theme Apply Buttons
            Row(
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                val isPrimary = named.name == selectedPrimaryName
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(6.dp))
                        .background(if (isPrimary) colors.primaryVariant else colors.containerVariant)
                        .border(
                            1.dp,
                            if (isPrimary) colors.primary else colors.shadeQuaternary,
                            RoundedCornerShape(6.dp),
                        )
                        .clickable { onSelectPrimary(named) }
                        .padding(horizontal = 8.dp, vertical = 4.dp),
                ) {
                    Text(
                        text = if (isPrimary) "V Primary" else "Set Primary",
                        fontSize = 11.sp,
                        fontWeight = if (isPrimary) FontWeight.Bold else FontWeight.Medium,
                        color = if (isPrimary) colors.primary else colors.shadeSecondary,
                    )
                }

                val isSecondary = named.name == selectedSecondaryName
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(6.dp))
                        .background(if (isSecondary) colors.secondaryVariant else colors.containerVariant)
                        .border(
                            1.dp,
                            if (isSecondary) colors.secondary else colors.shadeQuaternary,
                            RoundedCornerShape(6.dp),
                        )
                        .clickable { onSelectSecondary(named) }
                        .padding(horizontal = 8.dp, vertical = 4.dp),
                ) {
                    Text(
                        text = if (isSecondary) "V Secondary" else "Set Secondary",
                        fontSize = 11.sp,
                        fontWeight = if (isSecondary) FontWeight.Bold else FontWeight.Medium,
                        color = if (isSecondary) colors.secondary else colors.shadeSecondary,
                    )
                }
            }
        }

        // Swatch Bar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .border(1.dp, colors.shadeQuaternary, RoundedCornerShape(8.dp)),
        ) {
            steps.forEach { (stepName, color) ->
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(48.dp)
                        .background(color)
                        .clickable { onSelectColor("${named.name}.$stepName", color) },
                    contentAlignment = Alignment.Center,
                ) {
                    val stepNumber = stepName.removePrefix("t")
                    val textColor = if (color.luminance() > 0.5f) Color.Black.copy(alpha = 0.6f) else Color.White.copy(alpha = 0.8f)
                    Text(
                        text = stepNumber,
                        fontSize = 9.sp,
                        fontWeight = FontWeight.Bold,
                        color = textColor,
                    )
                }
            }
        }
    }
}

@Composable
private fun BaseSinglesCard(
    colors: AEColors,
    onSelectColor: (String, Color) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(colors.container)
            .border(1.dp, colors.shadeQuaternary, RoundedCornerShape(12.dp))
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        Text(
            text = "Base Common Tokens",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            color = colors.shadePrimary,
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            listOf(
                "white" to Color.White,
                "black" to Color.Black,
            ).forEach { (name, color) ->
                Row(
                    modifier = Modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(8.dp))
                        .background(colors.containerVariant)
                        .clickable { onSelectColor(name, color) }
                        .padding(10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                ) {
                    Box(
                        modifier = Modifier
                            .size(32.dp)
                            .clip(RoundedCornerShape(6.dp))
                            .background(color)
                            .border(1.dp, colors.shadeQuaternary, RoundedCornerShape(6.dp)),
                    )
                    Column {
                        Text(
                            text = name,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = colors.shadePrimary,
                        )
                        Text(
                            text = color.toHex(),
                            fontSize = 11.sp,
                            fontFamily = FontFamily.Monospace,
                            color = colors.shadeSecondary,
                        )
                    }
                }
            }
        }
    }
}

// ─────────────────────────────────────────────────────────────────────────────
// Section 3: Live UI Component Preview
// ─────────────────────────────────────────────────────────────────────────────

@Composable
private fun ComponentsPreviewView(
    colors: AEColors,
    selectedPrimary: ThemePaletteOption,
    selectedSecondary: ThemePaletteOption,
    isDark: Boolean,
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        // 0. Live Theme Reactive Banner
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(colors.primaryVariant)
                    .border(1.dp, colors.primary, RoundedCornerShape(12.dp))
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(4.dp),
                    modifier = Modifier.weight(1f),
                ) {
                    Text(
                        text = "Live Theme Reactive Preview",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = colors.primary,
                    )
                    Text(
                        text = "Primary: ${selectedPrimary.name} (${colors.primary.toHex()})  ·  Secondary: ${selectedSecondary.name} (${colors.secondary.toHex()})",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
                        color = colors.shadePrimary,
                    )
                    Text(
                        text = "All components below actively re-theme whenever you tap any palette chip above.",
                        fontSize = 11.sp,
                        color = colors.shadeSecondary,
                    )
                }

                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(start = 12.dp),
                ) {
                    Box(
                        modifier = Modifier
                            .size(28.dp)
                            .clip(CircleShape)
                            .background(colors.primary)
                            .border(1.dp, colors.container, CircleShape),
                    )
                    Box(
                        modifier = Modifier
                            .size(28.dp)
                            .clip(CircleShape)
                            .background(colors.secondary)
                            .border(1.dp, colors.container, CircleShape),
                    )
                }
            }
        }

        // 1. Buttons Preview
        item {
            PreviewSectionCard(title = "Button Variants & States", colors = colors) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                ) {
                    // Primary Button
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .background(colors.primary)
                            .padding(horizontal = 16.dp, vertical = 10.dp),
                    ) {
                        Text(
                            text = "Primary Button",
                            color = colors.onPrimary,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 13.sp,
                        )
                    }

                    // Secondary Button
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .background(colors.secondary)
                            .padding(horizontal = 16.dp, vertical = 10.dp),
                    ) {
                        Text(
                            text = "Secondary",
                            color = colors.onSecondary,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 13.sp,
                        )
                    }

                    // Muted Variant Button
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .background(colors.primaryVariant)
                            .padding(horizontal = 16.dp, vertical = 10.dp),
                    ) {
                        Text(
                            text = "Variant",
                            color = colors.primary,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 13.sp,
                        )
                    }

                    // Disabled Button
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .background(colors.disable)
                            .padding(horizontal = 16.dp, vertical = 10.dp),
                    ) {
                        Text(
                            text = "Disabled",
                            color = colors.onDisable,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 13.sp,
                        )
                    }
                }
            }
        }

        // 2. Alert Banners Preview
        item {
            PreviewSectionCard(title = "Alert & Feedback Banners", colors = colors) {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    AlertBanner(
                        title = "Success Alert",
                        message = "Your action completed successfully.",
                        icon = "V",
                        containerColor = colors.successVariant,
                        borderColor = colors.success,
                        contentColor = colors.onSuccess,
                    )
                    AlertBanner(
                        title = "Warning Notice",
                        message = "This operation requires authentication verification.",
                        icon = "!",
                        containerColor = colors.warningVariant,
                        borderColor = colors.warning,
                        contentColor = colors.onWarning,
                    )
                    AlertBanner(
                        title = "Error Destructive",
                        message = "Failed to connect to backend server.",
                        icon = "X",
                        containerColor = colors.errorVariant,
                        borderColor = colors.error,
                        contentColor = colors.onError,
                    )
                    AlertBanner(
                        title = "Info Message",
                        message = "System update scheduled tonight at 02:00 UTC.",
                        icon = "i",
                        containerColor = colors.infoVariant,
                        borderColor = colors.info,
                        contentColor = colors.onInfo,
                    )
                }
            }
        }

        // 3. Text & Typography Hierarchy on Container
        item {
            PreviewSectionCard(title = "Text Shade Hierarchy (shadePrimary -> shadeQuaternary)", colors = colors) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(8.dp))
                        .background(colors.containerVariant)
                        .padding(14.dp),
                    verticalArrangement = Arrangement.spacedBy(6.dp),
                ) {
                    Text(
                        text = "Heading Level 1 — shadePrimary",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = colors.shadePrimary,
                    )
                    Text(
                        text = "Subtitle and standard body copy — shadeSecondary",
                        fontSize = 14.sp,
                        color = colors.shadeSecondary,
                    )
                    Text(
                        text = "Caption, timestamps, and placeholder copy — shadeTertiary",
                        fontSize = 12.sp,
                        color = colors.shadeTertiary,
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(1.dp)
                            .background(colors.shadeQuaternary)
                            .padding(vertical = 4.dp),
                    )
                    Text(
                        text = "Above divider line is styled with shadeQuaternary",
                        fontSize = 11.sp,
                        color = colors.shadeTertiary,
                    )
                }
            }
        }

        // 4. Form Field Preview
        item {
            PreviewSectionCard(title = "Form Input States", colors = colors) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                ) {
                    // Active input
                    Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        Text("Active Field", fontSize = 12.sp, fontWeight = FontWeight.Medium, color = colors.shadeSecondary)
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(8.dp))
                                .background(colors.containerVariant)
                                .border(1.5.dp, colors.primary, RoundedCornerShape(8.dp))
                                .padding(horizontal = 12.dp, vertical = 10.dp),
                        ) {
                            Text("john.doe@bank.com", fontSize = 13.sp, color = colors.shadePrimary)
                        }
                    }

                    // Disabled input
                    Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        Text("Disabled Field", fontSize = 12.sp, fontWeight = FontWeight.Medium, color = colors.shadeSecondary)
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(8.dp))
                                .background(colors.disable.copy(alpha = 0.5f))
                                .border(1.dp, colors.shadeQuaternary, RoundedCornerShape(8.dp))
                                .padding(horizontal = 12.dp, vertical = 10.dp),
                        ) {
                            Text("Locked parameter", fontSize = 13.sp, color = colors.onDisable)
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun PreviewSectionCard(
    title: String,
    colors: AEColors,
    content: @Composable () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(colors.container)
            .border(1.dp, colors.shadeQuaternary, RoundedCornerShape(12.dp))
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Text(
            text = title,
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            color = colors.shadePrimary,
        )
        content()
    }
}

@Composable
private fun AlertBanner(
    title: String,
    message: String,
    icon: String,
    containerColor: Color,
    borderColor: Color,
    contentColor: Color,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(containerColor)
            .border(1.dp, borderColor, RoundedCornerShape(8.dp))
            .padding(12.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(
            modifier = Modifier
                .size(24.dp)
                .clip(CircleShape)
                .background(borderColor),
            contentAlignment = Alignment.Center,
        ) {
            Text(text = icon, fontSize = 12.sp, color = Color.White, fontWeight = FontWeight.Bold)
        }
        Column {
            Text(text = title, fontSize = 13.sp, fontWeight = FontWeight.Bold, color = contentColor)
            Text(text = message, fontSize = 11.sp, color = contentColor.copy(alpha = 0.85f))
        }
    }
}

// ─────────────────────────────────────────────────────────────────────────────
// Selected Color Footer Inspector
// ─────────────────────────────────────────────────────────────────────────────

@Composable
private fun SelectedColorFooter(
    name: String,
    color: Color,
    colors: AEColors,
    onDismiss: () -> Unit,
) {
    val hex = color.toHex()
    val r = (color.red * 255).toInt()
    val g = (color.green * 255).toInt()
    val b = (color.blue * 255).toInt()
    val a = (color.alpha * 255).toInt()

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(colors.container)
            .border(width = 1.dp, color = colors.shadeQuaternary)
            .padding(horizontal = 20.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            Box(
                modifier = Modifier
                    .size(42.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(color)
                    .border(1.dp, colors.shadeQuaternary, RoundedCornerShape(8.dp)),
            )

            Column {
                Text(
                    text = name,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = colors.shadePrimary,
                )
                Text(
                    text = "$hex  ·  RGB($r, $g, $b)  ·  Alpha $a",
                    fontSize = 11.sp,
                    fontFamily = FontFamily.Monospace,
                    color = colors.shadeSecondary,
                )
            }
        }

        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(6.dp))
                .background(colors.containerVariant)
                .clickable { onDismiss() }
                .padding(horizontal = 12.dp, vertical = 6.dp),
        ) {
            Text(text = "Close", fontSize = 12.sp, color = colors.shadePrimary)
        }
    }
}

// ─────────────────────────────────────────────────────────────────────────────
// Pure Kotlin Color Extension Helpers (Zero JVM/Android platform dependencies)
// ─────────────────────────────────────────────────────────────────────────────

private fun Color.toHex(): String {
    val a = (alpha * 255).toInt().coerceIn(0, 255)
    val r = (red * 255).toInt().coerceIn(0, 255)
    val g = (green * 255).toInt().coerceIn(0, 255)
    val b = (blue * 255).toInt().coerceIn(0, 255)
    return "#" + listOf(a, r, g, b).joinToString("") {
        it.toString(16).padStart(2, '0').uppercase()
    }
}

private fun Color.luminance(): Float {
    return 0.299f * red + 0.587f * green + 0.114f * blue
}
