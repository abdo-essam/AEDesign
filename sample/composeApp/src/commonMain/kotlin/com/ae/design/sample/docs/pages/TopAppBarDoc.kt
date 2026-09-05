package com.ae.design.sample.docs.pages

import androidx.compose.runtime.Composable
import com.ae.design.components.ui.button.AEButton
import com.ae.design.components.ui.button.AEButtonVariant
import com.ae.design.components.ui.topappbar.AETopAppBar
import com.ae.design.foundation.icons.AEIcon
import com.ae.design.foundation.icons.AEIcons
import com.ae.design.sample.docs.catalog.ComponentFamilies
import com.ae.design.sample.docs.components.CodeBlock
import com.ae.design.sample.docs.components.ComponentFamily
import com.ae.design.sample.docs.components.ComponentPageHeader
import com.ae.design.sample.docs.components.DemoBox
import com.ae.design.sample.docs.components.DocSection
import com.ae.design.sample.docs.components.PropInfo
import com.ae.design.sample.docs.components.PropsTable
import com.ae.design.sample.docs.components.TabbedDocPage

@Composable
fun TopAppBarDoc() {
    ComponentPageHeader(
        name = "TopAppBar",
        description = "Header app bar supporting title text and navigation/action slots.",
    )

    ComponentFamily(
        related = ComponentFamilies.NAVIGATION,
        currentId = "topappbar",
    )

    TabbedDocPage(
        overview = { TopAppBarOverviewTab() },
        usage = { TopAppBarUsageTab() },
        api = { TopAppBarApiTab() },
    )
}

@Composable
private fun TopAppBarOverviewTab() {
    DocSection("Top Header Showcase") {
        DemoBox {
            AETopAppBar(
                title = "Dashboard View",
                navigationIcon = AEIcons.Menu,
                onNavigationClick = {},
                actions = {
                    AEButton(onClick = {}, variant = AEButtonVariant.Ghost) {
                        AEIcon(AEIcons.Search)
                    }
                }
            )
        }
    }
}

@Composable
private fun TopAppBarUsageTab() {
    DocSection("Usage") {
        CodeBlock(
            """
AETopAppBar(
    title = "Application Title",
    navigationIcon = AEIcons.Menu,
    onNavigationClick = { },
    actions = {
        AEButton(onClick = {}, variant = AEButtonVariant.Ghost) {
            AEIcon(AEIcons.Search)
        }
    }
)
            """.trimIndent()
        )
    }
}

@Composable
private fun TopAppBarApiTab() {
    DocSection("API Reference") {
        PropsTable(
            listOf(
                PropInfo("title", "String", "required", "Title text string centered/placed in header."),
                PropInfo("navigationIcon", "AEIconToken?", "null", "Left navigation icon token (e.g. Menu)."),
                PropInfo("onNavigationClick", "(() -> Unit)?", "null", "Callback on clicking navigation icon."),
                PropInfo("actions", "@Composable RowScope.() -> Unit", "null", "Slot for trailing action buttons."),
                PropInfo("elevated", "Boolean", "false", "Whether to draw a shadow beneath the bar.")
            )
        )
    }
}
