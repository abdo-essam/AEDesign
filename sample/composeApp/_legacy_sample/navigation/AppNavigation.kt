package com.ae.design.sample.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.ae.design.sample.showcase.ShowcaseRoute
import com.ae.design.sample.docs.components.ComponentsCatalogScreen
import com.ae.design.sample.docs.components.DocsScreen
import com.ae.design.sample.whyae.WhyAEScreen
import com.ae.design.sample.theme.ThemeScreen
import com.ae.design.sample.ThemeConfiguration

@Composable
fun AppNavigation(
    navController: NavHostController,
    initialRoute: AppNavGraph = AppNavGraph.HomeRoute,
) {
    val hasNavigated = remember { mutableStateOf(false) }
    LaunchedEffect(Unit) {
        if (!hasNavigated.value && initialRoute != AppNavGraph.HomeRoute) {
            hasNavigated.value = true
            navController.navigate(initialRoute) {
                popUpTo<AppNavGraph.HomeRoute> { inclusive = false }
                launchSingleTop = true
            }
        }
    }

    NavHost(
        navController = navController,
        startDestination = AppNavGraph.HomeRoute,
        modifier = Modifier.fillMaxSize(),
    ) {
        composable<AppNavGraph.HomeRoute> {
            ShowcaseRoute(
                onNavigateToCreator = {
                    navController.navigate(AppNavGraph.CreatorRoute)
                },
                onNavigateToComponents = {
                    navController.navigate(AppNavGraph.ComponentsCatalogRoute)
                },
            )
        }

        composable<AppNavGraph.ComponentsCatalogRoute> {
            ComponentsCatalogScreen(
                onComponentClick = { componentId ->
                    navController.navigate(
                        AppNavGraph.DocsRoute(componentId = componentId)
                    )
                }
            )
        }

        composable<AppNavGraph.WhyAERoute> {
            WhyAEScreen()
        }

        composable<AppNavGraph.CreatorRoute> {
            var themeConfig by remember {
                mutableStateOf(ThemeConfiguration())
            }
            ThemeScreen(
                config = themeConfig,
                onThemeChange = { themeConfig = it }
            )
        }

        composable<AppNavGraph.DocsRoute> { backStackEntry ->
            val route: AppNavGraph.DocsRoute = backStackEntry.toRoute()
            val initialId = route.componentId ?: route.guideId
            DocsScreen(
                initialComponentId = initialId,
                onPageSelected = ::updateDocsHash,
            )
        }
    }
}
