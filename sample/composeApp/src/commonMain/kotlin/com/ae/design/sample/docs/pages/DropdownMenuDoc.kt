package com.ae.design.sample.docs.pages

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.ae.design.components.ui.dropdown.AEDropdownMenu
import com.ae.design.components.ui.dropdown.AEDropdownItem
import com.ae.design.components.ui.button.AEButton
import com.ae.design.components.ui.text.AEText
import com.ae.design.foundation.icons.AEIcons
import com.ae.design.sample.docs.catalog.ComponentFamilies
import com.ae.design.sample.docs.components.*
import com.ae.design.foundation.theme.AETheme

@Composable
fun DropdownMenuDoc() {
    ComponentPageHeader(
        name = "DropdownMenu",
        description = "Anchored floating popup with a list of dropdown action items.",
    )

    ComponentFamily(
        related = ComponentFamilies.POPUPS,
        currentId = "dropdown",
    )

    TabbedDocPage(
        overview = { DropdownOverviewTab() },
        usage = { DropdownUsageTab() },
        api = { DropdownApiTab() },
    )
}

@Composable
private fun DropdownOverviewTab() {
    DocSection("Live Preview") {
        var expanded by remember { mutableStateOf(false) }

        DemoBox {
            Box {
                AEButton(onClick = { expanded = true }) {
                    AEText("Open Dropdown Options")
                }
                AEDropdownMenu(
                    expanded = expanded,
                    onDismiss = { expanded = false },
                    items = listOf(
                        AEDropdownItem("Edit Settings", icon = AEIcons.Settings) { expanded = false },
                        AEDropdownItem("Copy Link", icon = AEIcons.Copy) { expanded = false },
                        AEDropdownItem("Delete File", icon = AEIcons.Delete, destructive = true) { expanded = false }
                    )
                )
            }
        }
    }
}

@Composable
private fun DropdownUsageTab() {
    DocSection("Usage") {
        CodeBlock(
            """
AEDropdownMenu(
    expanded = isExpanded,
    onDismiss = { isExpanded = false },
    items = listOf(
        AEDropdownItem("Save", icon = AEIcons.Check) { save() }
    )
)
            """.trimIndent()
        )
    }
}

@Composable
private fun DropdownApiTab() {
    DocSection("API Reference") {
        PropsTable(
            listOf(
                PropInfo("expanded", "Boolean", "required", "Controls showing/hiding dropdown popup."),
                PropInfo("onDismiss", "() -> Unit", "required", "Callback when user taps outside the menu."),
                PropInfo("items", "List<AEDropdownItem>", "required", "Dropdown items containing labels, icons, actions.")
            )
        )
    }
}
