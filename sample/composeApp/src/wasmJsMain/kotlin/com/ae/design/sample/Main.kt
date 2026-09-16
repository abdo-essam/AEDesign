package com.ae.design.sample

import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.HostDefaultKey
import androidx.compose.runtime.HostDefaultProvider
import androidx.compose.runtime.LocalHostDefaultProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import kotlinx.browser.document

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    val target = document.getElementById("compose-target") ?: document.body ?: return
    ComposeViewport(target) {
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
