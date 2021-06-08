package com.smushytaco.daylight_mobs_reborn.mixins;
import com.smushytaco.daylight_mobs_reborn.DaylightMobsReborn;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.WorldView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import java.util.Random;
@Mixin(HostileEntity.class)
public abstract class HostileEntityCanSpawnDuringDay {
    @Inject(method = "isSpawnDark", at = @At("RETURN"), cancellable = true)
    private static void hookIsSpawnDark(ServerWorldAccess world, BlockPos pos, Random random, CallbackInfoReturnable<Boolean> cir) {
        if (!DaylightMobsReborn.INSTANCE.getConfig().getHostileMobsSpawnDuringTheDay()) return;
        cir.setReturnValue(world.getLightLevel(pos, 10) <= random.nextInt(8));
    }
    @Inject(method = "getPathfindingFavor", at = @At("RETURN"), cancellable = true)
    public void hookGetPathfindingFavor(BlockPos pos, WorldView world, CallbackInfoReturnable<Float> cir) {
        if (!DaylightMobsReborn.INSTANCE.getConfig().getHostileMobsSpawnDuringTheDay()) return;
        cir.setReturnValue(1.0F);
    }
}