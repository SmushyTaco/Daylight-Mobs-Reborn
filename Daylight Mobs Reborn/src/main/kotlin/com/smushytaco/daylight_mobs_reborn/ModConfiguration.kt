package com.smushytaco.daylight_mobs_reborn
import io.wispforest.owo.config.annotation.Config
import io.wispforest.owo.config.annotation.Modmenu
@Modmenu(modId = DaylightMobsReborn.MOD_ID)
@Config(name = DaylightMobsReborn.MOD_ID, wrapperName = "ModConfig")
@Suppress("UNUSED")
class ModConfiguration {
    @JvmField
    var mobsDontBurnDuringTheDay = true
    @JvmField
    var hostileMobsSpawnDuringTheDay = false
}