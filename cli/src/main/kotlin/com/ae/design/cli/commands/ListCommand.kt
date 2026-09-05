package com.ae.design.cli.commands

import com.ae.design.cli.registry.ConfigManager
import com.ae.design.cli.registry.RegistryClient
import com.github.ajalt.clikt.core.Abort
import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.Context
import com.github.ajalt.clikt.parameters.options.option

class ListCommand : CliktCommand(name = "list") {

    override fun help(context: Context) = "List all available components"

    private val registryFlag by option("--registry", "-r", help = "Registry URL")

    override fun run() {
        val config = ConfigManager.load()
        val registryUrl = registryFlag ?: config?.registry ?: "https://abdo-essam.github.io/AEDesign/r"
        val client = RegistryClient(registryUrl)

        echo("Fetching components from $registryUrl...")
        echo("")

        val index = try {
            client.fetchIndex()
        } catch (e: Exception) {
            echo("Error: Failed to fetch registry: ${e.message}", err = true)
            throw Abort()
        }

        echo("  AEDesign v${index.version} — ${index.items.size} components")
        echo("")

        val grouped = index.items.groupBy { it.category.ifEmpty { "Other" } }
        grouped.forEach { (category, items) ->
            echo("  $category:")
            items.forEach { item ->
                val deps = if (item.registryDependencies.isNotEmpty()) {
                    " [deps: ${item.registryDependencies.joinToString(", ")}]"
                } else ""
                echo("    ${item.name.padEnd(20)} ${item.description}$deps")
            }
            echo("")
        }

        echo("")
        echo("  Run 'aedesign add <name>' to add a component.")
        echo("")
    }
}
