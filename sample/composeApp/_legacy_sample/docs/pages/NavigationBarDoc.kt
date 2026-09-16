package com.ae.design.sample.docs.pages

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.ae.design.components.ui.navigationbar.AENavigationBar
import com.ae.design.components.ui.navigationbar.AENavItem
import com.ae.design.foundation.icons.AEIcons
import com.ae.design.sample.docs.catalog.ComponentFamilies
import com.ae.design.sample.docs.components.*
import com.ae.design.foundation.theme.AETheme

@Composable
fun NavigationBarDoc() {
    ComponentPageHeader(
        name = "NavigationBar",
        description = "Bottom navigation bar layout supporting icon and label destinations.",
    )

    ComponentFamily(
        related = ComponentFamilies.NAVIGATION,
        currentId = "navigationbar",
    )

    TabbedDocPage(
        overview = { NavigationBarOverviewTab() },
        usage = { NavigationBarUsageTab() },
        api = { NavigationBarApiTab() },
    )
}

@Composable
private fun NavigationBarOverviewTab() {
    DocSection("Showcase") {
        var currentDest by remember { mutableStateOf(0) }

        DemoBox {
            AENavigationBar(
                items = listOf(
                    AENavItem(AEIcons.Home, "Home", currentDest == 0),
                    AENavItem(AEIcons.Search, "Search", currentDest == 1),
                    AENavItem(AEIcons.User, "Profile", currentDest == 2, badge = 2)
                ),
                onItemSelected = { currentDest = it }
            )
        }
    }
}

@Composable
private fun NavigationBarUsageTab() {
    DocSection("Usage") {
        CodeBlock(
            """
AENavigationBar(
    items = listOf(
        AENavItem(AEIcons.Home, "Home", true)
    ),
    onItemSelected = { index -> }
)
            """.trimIndent()
        )
    }
}

@Composable
private fun NavigationBarApiTab() {
    DocSection("API Reference") {
        PropsTable(
            listOf(
                PropInfo("items", "List<AENavItem>", "required", "Destinations mapping icons, labels, badges, active states."),
                PropInfo("onItemSelected", "(Int) -> Unit", "required", "Triggered when a tab is tapped.")
            )
        )
    }
}
