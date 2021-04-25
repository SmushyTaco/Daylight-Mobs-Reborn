package com.smushytaco.daylight_mobs_reborn.mixins;

import net.minecraft.entity.mob.MobEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MobEntity.class)
public abstract class MobEntityMixin {
    @Inject(method = "isAffectedByDaylight", at = @At("RETURN"), cancellable = true)
    public void hookDaylight(CallbackInfoReturnable<Boolean> ci) {
        ci.setReturnValue(false);
    }
}