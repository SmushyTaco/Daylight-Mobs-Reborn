package com.smushytaco.daylight_mobs_reborn.configuration_support
import com.smushytaco.daylight_mobs_reborn.DaylightMobsReborn
import me.shedaniel.autoconfig.ConfigData
import me.shedaniel.autoconfig.annotation.Config
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment
@Config(name = DaylightMobsReborn.MOD_ID)
class ModConfiguration: ConfigData {
    @Comment("Default value is yes. If set to yes mobs that would usually burn during the day will no longer burn during the day. If set to no they will burn during the day. This is ignored if \"Hostile Mobs Spawn During The Day\" is set to yes.")
    val mobsDontBurnDuringTheDay = true
    @Comment("Default value is no. If set to yes hostile mobs will spawn during the day and during the night. If set to no hostile mobs will only spawn during the night like usual.")
    val hostileMobsSpawnDuringTheDay = false
}