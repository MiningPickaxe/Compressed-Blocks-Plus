package de.MiningPickaxe.compress.worldgen;

import java.util.Random;

import cpw.mods.fml.common.IWorldGenerator;
import de.MiningPickaxe.compress.compress;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class compressWorldGen implements IWorldGenerator {

	
	
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.dimensionId) {
		case 0:
			//Generate Surface
			generateSurface(world, random, chunkX*16, chunkZ*16);
			
		case -1:
			//Generate Nether
			generateNether(world, random, chunkX*16, chunkZ*16);
			
		case 1:
			//Generate End
			generateEnd(world, random, chunkX*16, chunkZ*16);
		}
		
	}

	private void generateSurface(World world, Random random, int i, int j) {
		// TODO Auto-generated method stub
		
	}
	
	
	private void generateNether(World world, Random random, int x, int z) {
		//this.addOreSpawn(compress.OreWhatever, world, random, x=blockXPosition, z=blockZPosition, 16=maxX, 16=maxY, maxVeinSize, ChanceToSpawn, minY, maxY);
		this.addNetherOreSpawn(compress.OreMaterie, world, random, x, z, 16, 16, 2+random.nextInt(4), 25, 1, 255);
		
	}
	
	

	private void generateEnd(World world, Random random, int i, int j) {
		// TODO Auto-generated method stub
		
	}
	
	private void addNetherOreSpawn(Block block, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int ChanceToSpawn, int minY, int maxY) {
		for(int i = 0; i < ChanceToSpawn; i++) {
			int posX = blockXPos + random.nextInt(maxX);
			int posY = minY + random.nextInt(maxY-minY);
			int posZ = blockZPos + random.nextInt(maxZ);
			(new WorldGenNetherMinable(block, maxVeinSize)).generate(world, random, posX, posY, posZ);
		}
		
	}

	

	

}
