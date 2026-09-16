package com.ae.design.sample.navigation

actual fun resolveInitialRoute(): AppNavGraph = AppNavGraph.HomeRoute

actual fun updateDocsHash(pageId: String) { /* no-op on Android */ }
