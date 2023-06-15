package com.smushytaco.daylight_mobs_reborn.mixins;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.smushytaco.daylight_mobs_reborn.DaylightMobsReborn;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.WorldView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
@Mixin(HostileEntity.class)
public abstract class HostileEntityCanSpawnDuringDay {
    @ModifyReturnValue(method = "isSpawnDark", at = @At("RETURN"))
    @SuppressWarnings("unused")
    private static boolean hookIsSpawnDark(boolean original, ServerWorldAccess world, BlockPos pos, Random random) { return !DaylightMobsReborn.INSTANCE.getConfig().getHostileMobsSpawnDuringTheDay() ? original : world.getLightLevel(pos, 10) <= random.nextInt(8); }
    @ModifyReturnValue(method = "getPathfindingFavor", at = @At("RETURN"))
    @SuppressWarnings("unused")
    public float hookGetPathfindingFavor(float original, BlockPos pos, WorldView world) { return !DaylightMobsReborn.INSTANCE.getConfig().getHostileMobsSpawnDuringTheDay() ? original : 1.0F; }
}