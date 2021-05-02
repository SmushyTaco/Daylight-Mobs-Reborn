package com.smushytaco.daylight_mobs_reborn.mixins;
import com.smushytaco.daylight_mobs_reborn.DaylightMobsReborn;
import com.smushytaco.daylight_mobs_reborn.configuration_support.ModConfiguration;
import net.minecraft.entity.mob.MobEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
@Mixin(MobEntity.class)
public abstract class MobEntityDoesntBurnDuringDay {
    @Inject(method = "isAffectedByDaylight", at = @At("RETURN"), cancellable = true)
    public void hookIsAffectedByDaylight(CallbackInfoReturnable<Boolean> cir) {
        ModConfiguration config = DaylightMobsReborn.INSTANCE.getConfig();
        if (!config.getMobsDontBurnDuringTheDay() && !config.getHostileMobsSpawnDuringTheDay()) return;
        cir.setReturnValue(false);
    }
}