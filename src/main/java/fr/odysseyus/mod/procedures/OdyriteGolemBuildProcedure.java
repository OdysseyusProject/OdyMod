package fr.odysseyus.mod.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import java.util.Map;

import fr.odysseyus.mod.entity.OdyriteGolemEntity;
import fr.odysseyus.mod.block.OdyriteblockBlock;
import fr.odysseyus.mod.OdysseyusMod;

public class OdyriteGolemBuildProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				OdysseyusMod.LOGGER.warn("Failed to load dependency world for procedure OdyriteGolemBuild!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				OdysseyusMod.LOGGER.warn("Failed to load dependency x for procedure OdyriteGolemBuild!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				OdysseyusMod.LOGGER.warn("Failed to load dependency y for procedure OdyriteGolemBuild!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				OdysseyusMod.LOGGER.warn("Failed to load dependency z for procedure OdyriteGolemBuild!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if (((world.getBlockState(new BlockPos((int) (x + 1), (int) (y - 1), (int) z))).getBlock() == OdyriteblockBlock.block
				&& (world.getBlockState(new BlockPos((int) (x - 1), (int) (y - 1), (int) z))).getBlock() == OdyriteblockBlock.block
				|| (world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) (z - 1)))).getBlock() == OdyriteblockBlock.block
						&& (world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) (z + 1)))).getBlock() == OdyriteblockBlock.block)
				&& (world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == OdyriteblockBlock.block
				&& (world.getBlockState(new BlockPos((int) x, (int) (y - 2), (int) z))).getBlock() == OdyriteblockBlock.block) {
			world.destroyBlock(new BlockPos((int) x, (int) (y - 1), (int) z), false);
			world.destroyBlock(new BlockPos((int) x, (int) (y - 2), (int) z), false);
			if ((world.getBlockState(new BlockPos((int) (x + 1), (int) (y - 1), (int) z))).getBlock() == OdyriteblockBlock.block) {
				world.destroyBlock(new BlockPos((int) (x + 1), (int) (y - 1), (int) z), false);
				world.destroyBlock(new BlockPos((int) (x - 1), (int) (y - 2), (int) z), false);
			} else {
				world.destroyBlock(new BlockPos((int) x, (int) (y - 1), (int) (z - 1)), false);
				world.destroyBlock(new BlockPos((int) x, (int) (y - 1), (int) (z + 1)), false);
			}
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
			if (world instanceof ServerWorld) {
				Entity entityToSpawn = new OdyriteGolemEntity.CustomEntity(OdyriteGolemEntity.entity, (World) world);
				entityToSpawn.setLocationAndAngles(x, (y - 1), z, (float) 0, (float) 0);
				entityToSpawn.setRenderYawOffset((float) 0);
				entityToSpawn.setRotationYawHead((float) 0);
				if (entityToSpawn instanceof MobEntity)
					((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
							SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
				world.addEntity(entityToSpawn);
			}
		}
	}
}
