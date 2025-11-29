package com.smushytaco.daylight_mobs_reborn.mixins;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.smushytaco.daylight_mobs_reborn.DaylightMobsReborn;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
@Mixin(Monster.class)
public abstract class HostileEntityCanSpawnDuringDay {
    @ModifyReturnValue(method = "isDarkEnoughToSpawn", at = @At("RETURN"))
    private static boolean hookIsSpawnDark(boolean original, ServerLevelAccessor world, BlockPos pos, RandomSource random) { return !DaylightMobsReborn.INSTANCE.getConfig().getHostileMobsSpawnDuringTheDay() ? original : world.getMaxLocalRawBrightness(pos, 10) <= random.nextInt(8); }
    @ModifyReturnValue(method = "getWalkTargetValue", at = @At("RETURN"))
    public float hookGetPathfindingFavor(float original, BlockPos pos, LevelReader world) { return !DaylightMobsReborn.INSTANCE.getConfig().getHostileMobsSpawnDuringTheDay() ? original : 1.0F; }
}