package com.ae.design.foundation.typography

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

/**
 * Full typography scale for AEDesign.
 *
 * Mirrors the design system's complete type hierarchy:
 * headline, subheading, body, link, and button variants.
 *
 * Two factory options:
 * - [default] — Barlow font, smaller line heights (LTR / English)
 * - [defaultRtl] — Cairo font, larger line heights (RTL / Arabic)
 *
 * Use [AETheme.typography] to access these from within a themed scope.
 */
@Immutable
public data class AETypography(

    // ── Headline ──────────────────────────────────────────────────────────────
    /** 36sp / SemiBold */
    val headlineXl: TextStyle,
    /** 32sp / SemiBold */
    val headlineLg: TextStyle,
    /** 28sp / SemiBold */
    val headlineMd: TextStyle,
    /** 24sp / SemiBold */
    val headlineSm: TextStyle,
    /** 20sp / SemiBold */
    val headlineXs: TextStyle,
    /** 16sp / SemiBold */
    val headlineXXs: TextStyle,
    /** 24sp / SemiBold — fixed-size headline variant */
    val headline24: TextStyle,

    // ── Subheading ────────────────────────────────────────────────────────────
    /** 28sp / Medium */
    val subheadingLg: TextStyle,
    /** 20sp / Medium */
    val subheadingMd: TextStyle,
    /** 18sp / Medium */
    val subheadingSm: TextStyle,
    /** 16sp / Medium */
    val subheadingXs: TextStyle,
    /** 14sp / Medium */
    val subheadingXXs: TextStyle,

    // ── Body ──────────────────────────────────────────────────────────────────
    /** 16sp / Normal */
    val bodyMd: TextStyle,
    /** 16sp / SemiBold */
    val bodyMdSemiBold: TextStyle,
    /** 16sp / Bold */
    val bodyMdBold: TextStyle,

    /** 14sp / Normal */
    val bodySm: TextStyle,
    /** 14sp / SemiBold */
    val bodySmSemiBold: TextStyle,
    /** 14sp / Bold */
    val bodySmBold: TextStyle,

    /** 12sp / Normal */
    val bodyXs: TextStyle,
    /** 12sp / Medium */
    val bodyXsMed: TextStyle,
    /** 12sp / SemiBold */
    val bodyXsSemiBold: TextStyle,
    /** 12sp / Bold */
    val bodyXsBold: TextStyle,

    /** 11sp / Normal */
    val bodyXXs: TextStyle,
    /** 11sp / SemiBold */
    val bodyXXsSemiBold: TextStyle,
    /** 11sp / Bold */
    val bodyXXsBold: TextStyle,

    // ── Link ──────────────────────────────────────────────────────────────────
    /** 18sp / SemiBold */
    val linkLg: TextStyle,
    /** 16sp / SemiBold */
    val linkMd: TextStyle,
    /** 14sp / SemiBold */
    val linkSm: TextStyle,
    /** 12sp / SemiBold */
    val linkXs: TextStyle,

    // ── Button ────────────────────────────────────────────────────────────────
    /** 16sp / SemiBold */
    val buttonLg: TextStyle,
    /** 14sp / SemiBold */
    val buttonMd: TextStyle,
    /** 12sp / SemiBold */
    val buttonSm: TextStyle,
    /** 11sp / SemiBold */
    val buttonXs: TextStyle,
) {
    /** Alias for [buttonMd] — the default button label style. */
    public val buttonDefault: TextStyle get() = buttonMd

    public companion object {

        /**
         * Creates the default LTR typography scale (Barlow).
         * Uses slightly smaller line heights for English text.
         *
         * @param fontFamily Override the font family (defaults to [AEFontFamily.barlow]).
         */
        @androidx.compose.runtime.Composable
        public fun default(
            fontFamily: FontFamily = AEFontFamily.barlow(),
        ): AETypography = build(fontFamily = fontFamily, compactLineHeight = true)

        /**
         * Creates the default RTL typography scale (Cairo).
         * Uses larger line heights for Arabic text.
         *
         * @param fontFamily Override the font family (defaults to [AEFontFamily.cairo]).
         */
        @androidx.compose.runtime.Composable
        public fun defaultRtl(
            fontFamily: FontFamily = AEFontFamily.cairo(),
        ): AETypography = build(fontFamily = fontFamily, compactLineHeight = false)

        /**
         * Non-composable factory for use in previews, tests, or static composition locals.
         * Defaults to system sans-serif.
         */
        public fun defaultStatic(fontFamily: FontFamily = FontFamily.SansSerif): AETypography =
            build(fontFamily = fontFamily, compactLineHeight = true)

        /**
         * Builds the full [AETypography] scale from [fontFamily].
         *
         * [compactLineHeight] = true → smaller line heights (LTR/Barlow).
         * [compactLineHeight] = false → larger line heights (RTL/Cairo).
         */
        private fun build(
            fontFamily: FontFamily,
            compactLineHeight: Boolean,
        ): AETypography {
            fun h(size: Int, compact: Int, expanded: Int) = TextStyle(
                fontFamily = fontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = size.sp,
                lineHeight = (if (compactLineHeight) compact else expanded).sp,
            )

            fun sub(size: Int, compact: Int, expanded: Int) = TextStyle(
                fontFamily = fontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = size.sp,
                lineHeight = (if (compactLineHeight) compact else expanded).sp,
            )

            fun body(size: Int, lineHeight: Int, weight: FontWeight) = TextStyle(
                fontFamily = fontFamily,
                fontWeight = weight,
                fontSize = size.sp,
                lineHeight = lineHeight.sp,
            )

            fun link(size: Int, lineHeight: Int) = TextStyle(
                fontFamily = fontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = size.sp,
                lineHeight = lineHeight.sp,
            )

            fun button(size: Int, lineHeight: Int) = TextStyle(
                fontFamily = fontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = size.sp,
                lineHeight = lineHeight.sp,
            )

            return AETypography(
                // Headline — compactLineHeight: smaller / larger
                headlineXl   = h(36, compact = 40, expanded = 48),
                headlineLg   = h(32, compact = 36, expanded = 44),
                headlineMd   = h(28, compact = 32, expanded = 40),
                headlineSm   = h(24, compact = 32, expanded = 32),
                headlineXs   = h(20, compact = 28, expanded = 32),
                headlineXXs  = h(16, compact = 20, expanded = 24),
                headline24   = h(24, compact = 32, expanded = 32),

                // Subheading
                subheadingLg  = sub(28, compact = 32, expanded = 40),
                subheadingMd  = sub(20, compact = 28, expanded = 32),
                subheadingSm  = sub(18, compact = 24, expanded = 32),
                subheadingXs  = sub(16, compact = 20, expanded = 24),
                subheadingXXs = sub(14, compact = 20, expanded = 24),

                // Body
                bodyMd         = body(16, 24, FontWeight.Normal),
                bodyMdSemiBold = body(16, 24, FontWeight.SemiBold),
                bodyMdBold     = body(16, 24, FontWeight.Bold),

                bodySm         = body(14, 24, FontWeight.Normal),
                bodySmSemiBold = body(14, 24, FontWeight.SemiBold),
                bodySmBold     = body(14, 24, FontWeight.Bold),

                bodyXs         = body(12, 16, FontWeight.Normal),
                bodyXsMed      = body(12, 16, FontWeight.Medium),
                bodyXsSemiBold = body(12, 16, FontWeight.SemiBold),
                bodyXsBold     = body(12, 16, FontWeight.Bold),

                bodyXXs         = body(11, 16, FontWeight.Normal),
                bodyXXsSemiBold = body(11, 16, FontWeight.SemiBold),
                bodyXXsBold     = body(11, 16, FontWeight.Bold),

                // Link
                linkLg = link(18, 32),
                linkMd = link(16, 24),
                linkSm = link(14, 24),
                linkXs = link(12, 16),

                // Button
                buttonLg = button(16, 24),
                buttonMd = button(14, 20),
                buttonSm = button(12, 16),
                buttonXs = button(11, 16),
            )
        }
    }
}
