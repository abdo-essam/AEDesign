package com.ae.design.sample.docs.components

import androidx.compose.runtime.staticCompositionLocalOf

/**
 * Provides page navigation within the docs section.
 *
 * Provided by DocsScreen wrapping the content area.
 */
val LocalDocNavigation =
    staticCompositionLocalOf<(String) -> Unit> { {} }
