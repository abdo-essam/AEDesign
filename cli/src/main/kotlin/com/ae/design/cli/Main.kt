package com.ae.design.cli

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.Context
import com.github.ajalt.clikt.core.main
import com.github.ajalt.clikt.core.subcommands
import com.ae.design.cli.commands.AddCommand
import com.ae.design.cli.commands.InitCommand
import com.ae.design.cli.commands.ListCommand

class AECli : CliktCommand(name = "aedesign") {
    override fun help(context: Context) =
        "AEDesign — Add components to your Compose Multiplatform project"

    override fun run() = Unit
}

fun main(args: Array<String>) =
    AECli()
        .subcommands(InitCommand(), AddCommand(), ListCommand())
        .main(args)
