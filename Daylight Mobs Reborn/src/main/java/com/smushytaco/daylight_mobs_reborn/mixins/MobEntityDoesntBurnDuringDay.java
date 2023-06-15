package com.smushytaco.daylight_mobs_reborn.mixins;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.smushytaco.daylight_mobs_reborn.DaylightMobsReborn;
import net.minecraft.entity.mob.MobEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
@Mixin(MobEntity.class)
public abstract class MobEntityDoesntBurnDuringDay {
    @ModifyReturnValue(method = "isAffectedByDaylight", at = @At("RETURN"))
    public boolean hookIsAffectedByDaylight(boolean original) { return !DaylightMobsReborn.INSTANCE.getConfig().getMobsDontBurnDuringTheDay() && !DaylightMobsReborn.INSTANCE.getConfig().getHostileMobsSpawnDuringTheDay() && original; }
}