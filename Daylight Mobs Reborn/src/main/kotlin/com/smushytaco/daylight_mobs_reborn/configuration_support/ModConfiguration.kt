package com.smushytaco.daylight_mobs_reborn.configuration_support
import com.smushytaco.daylight_mobs_reborn.DaylightMobsReborn
import me.shedaniel.autoconfig.ConfigData
import me.shedaniel.autoconfig.annotation.Config
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment
@Config(name = DaylightMobsReborn.MOD_ID)
class ModConfiguration: ConfigData {
    @Comment("Default value is yes. If set to yes mobs that would usually burn during the day will no longer burn during the day. If set to no they will burn during the day.")
    val mobsDontBurnDuringTheDay = true
}