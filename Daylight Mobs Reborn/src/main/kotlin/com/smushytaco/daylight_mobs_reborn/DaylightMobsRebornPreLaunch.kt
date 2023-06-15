package com.smushytaco.daylight_mobs_reborn
import com.llamalad7.mixinextras.MixinExtrasBootstrap
import net.fabricmc.loader.api.entrypoint.PreLaunchEntrypoint
@Suppress("UNUSED")
object DaylightMobsRebornPreLaunch: PreLaunchEntrypoint { override fun onPreLaunch() { MixinExtrasBootstrap.init() } }