package com.ae.design.sample

import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.HostDefaultKey
import androidx.compose.runtime.HostDefaultProvider
import androidx.compose.runtime.LocalHostDefaultProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "AEDesign · Docs",
        state = rememberWindowState(width = 1100.dp, height = 800.dp),
    ) {
        val viewModelStoreOwner = remember {
            object : ViewModelStoreOwner {
                override val viewModelStore: ViewModelStore = ViewModelStore()
            }
        }
        val hostDefaultProvider = remember {
            object : HostDefaultProvider {
                @Suppress("UNCHECKED_CAST")
                override fun <T> getHostDefault(key: HostDefaultKey<T>): T {
                    return null as T
                }
            }
        }
        CompositionLocalProvider(
            LocalHostDefaultProvider provides hostDefaultProvider,
            LocalViewModelStoreOwner provides viewModelStoreOwner,
        ) {
            ColorTestApp()
        }
    }
}
