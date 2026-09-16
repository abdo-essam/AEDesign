package com.ae.design.sample.docs.catalog

import androidx.compose.runtime.Composable
import org.jetbrains.compose.resources.StringResource
import aedesign.sample.composeapp.generated.resources.Res
import aedesign.sample.composeapp.generated.resources.guide_cli
import aedesign.sample.composeapp.generated.resources.guide_installation
import aedesign.sample.composeapp.generated.resources.guide_introduction
import aedesign.sample.composeapp.generated.resources.guide_theming
import aedesign.sample.composeapp.generated.resources.guide_whats_new
import com.ae.design.sample.docs.pages.CliDoc
import com.ae.design.sample.docs.pages.InstallationDoc
import com.ae.design.sample.docs.pages.IntroductionDoc
import com.ae.design.sample.docs.pages.ThemingDoc
import com.ae.design.sample.docs.pages.WhatsNewDoc

object GuideIds {
    const val WHATS_NEW = "whats-new"
    const val INTRODUCTION = "introduction"
    const val INSTALLATION = "installation"
    const val THEMING = "theming"
    const val CLI = "cli"
}

data class GuidePage(
    val id: String,
    val nameRes: StringResource,
    val content: @Composable () -> Unit,
)

val guidePages =
    listOf(
        GuidePage(
            id = GuideIds.WHATS_NEW,
            nameRes = Res.string.guide_whats_new,
            content = { WhatsNewDoc() },
        ),
        GuidePage(
            id = GuideIds.INTRODUCTION,
            nameRes = Res.string.guide_introduction,
            content = { IntroductionDoc() },
        ),
        GuidePage(
            id = GuideIds.INSTALLATION,
            nameRes = Res.string.guide_installation,
            content = { InstallationDoc() },
        ),
        GuidePage(
            id = GuideIds.THEMING,
            nameRes = Res.string.guide_theming,
            content = { ThemingDoc() },
        ),
        GuidePage(
            id = GuideIds.CLI,
            nameRes = Res.string.guide_cli,
            content = { CliDoc() },
        ),
    )

val guidePageIds = guidePages.map { it.id }.toSet()
