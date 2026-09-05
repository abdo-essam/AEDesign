package com.ae.design.cli.registry

import com.ae.design.cli.model.AEConfig
import kotlinx.serialization.json.Json
import java.io.File

private val prettyJson = Json {
    prettyPrint = true
    ignoreUnknownKeys = true
}

object ConfigManager {
    private const val CONFIG_FILE = "aedesign.json"

    fun findConfigFile(): File? {
        var dir = File(System.getProperty("user.dir"))
        while (dir.parent != null) {
            val file = dir.resolve(CONFIG_FILE)
            if (file.exists()) return file
            dir = dir.parentFile
        }
        return null
    }

    fun load(): AEConfig? {
        val file = findConfigFile() ?: return null
        return prettyJson.decodeFromString<AEConfig>(file.readText())
    }

    fun projectRoot(): File? = findConfigFile()?.parentFile

    fun save(config: AEConfig, dir: File = File(System.getProperty("user.dir"))) {
        val file = dir.resolve(CONFIG_FILE)
        file.writeText(prettyJson.encodeToString(config))
    }

    fun exists(): Boolean = findConfigFile() != null
}
