package com.smushytaco.daylight_mobs_reborn.mixins;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.smushytaco.daylight_mobs_reborn.DaylightMobsReborn;
import net.minecraft.world.entity.Mob;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
@Mixin(Mob.class)
public abstract class MobEntityDoesntBurnDuringDay {
    @ModifyReturnValue(method = "isSunBurnTick", at = @At("RETURN"))
    public boolean hookIsAffectedByDaylight(boolean original) { return !DaylightMobsReborn.INSTANCE.getConfig().getMobsDontBurnDuringTheDay() && !DaylightMobsReborn.INSTANCE.getConfig().getHostileMobsSpawnDuringTheDay() && original; }
}