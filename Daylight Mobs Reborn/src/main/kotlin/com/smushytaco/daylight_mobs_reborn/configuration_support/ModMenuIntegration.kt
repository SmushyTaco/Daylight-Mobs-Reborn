package com.smushytaco.daylight_mobs_reborn.configuration_support
import com.smushytaco.daylight_mobs_reborn.DaylightMobsReborn
import io.github.prospector.modmenu.api.ConfigScreenFactory
import io.github.prospector.modmenu.api.ModMenuApi
import me.shedaniel.autoconfig.AutoConfig
import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
@Environment(EnvType.CLIENT)
class ModMenuIntegration: ModMenuApi {
    override fun getModId() = DaylightMobsReborn.MOD_ID
    override fun getModConfigScreenFactory(): ConfigScreenFactory<*> {
        return ConfigScreenFactory { parent -> AutoConfig.getConfigScreen(ModConfiguration::class.java, parent).get() }
    }
}