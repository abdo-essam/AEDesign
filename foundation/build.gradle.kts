import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidMultiplatformLibrary)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.vanniktechMavenPublish)
}

kotlin {
    explicitApi()

    android {
        namespace = "com.ae.design.foundation"
        compileSdk = 37
        minSdk = 24
    }

    jvm("desktop")

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser()
    }
    js {
        browser()
    }

    applyDefaultHierarchyTemplate()

    sourceSets {
        commonMain {
            dependencies {
                implementation(libs.compose.runtime)
                implementation(libs.compose.foundation)
                implementation(libs.compose.ui)
                implementation(libs.compose.animation)
                implementation(libs.compose.components.resources)
            }
        }
    }
}

signing {
    useInMemoryPgpKeys(
        findProperty("signingInMemoryKeyId") as String?,
        findProperty("signingInMemoryKey") as String?,
        findProperty("signingInMemoryKeyPassword") as String?,
    )
}

mavenPublishing {
    pom {
        name = "AEDesign Foundation"
        description = "Token-driven theme system and design foundation for Compose Multiplatform — zero Material3"
    }
}
