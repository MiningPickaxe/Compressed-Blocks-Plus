package de.MiningPickaxe.crafting;

import de.MiningPickaxe.compress.compress;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class StamperRecipes {

	
	public StamperRecipes() {
		
	}
	
	public static ItemStack getStampingResult(Item item, Item item2, Item item3, Item item4, Item item5, Item item6, Item item7, Item item8, Item item9) {
		return getOutput(item, item2, item3, item4, item5, item6, item7, item8, item9);
	}
	
	public static ItemStack getOutput(Item item, Item item2, Item item3, Item item4, Item item5, Item item6, Item item7, Item item8, Item item9) {
		//Recipe 1
		if (item == item.getItemFromBlock(Blocks.gold_block) && item2 == item.getItemFromBlock(Blocks.gold_block) && item3 == item.getItemFromBlock(Blocks.gold_block) && item4 == item.getItemFromBlock(Blocks.gold_block) && item5 == item.getItemFromBlock(Blocks.gold_block) && item6 == item.getItemFromBlock(Blocks.gold_block) && item7 == item.getItemFromBlock(Blocks.gold_block) && item8 == item.getItemFromBlock(Blocks.gold_block) && item9 == item.getItemFromBlock(Blocks.gold_block)) {
			return new ItemStack(compress.CompressedGoldBlock, 1);
		}
		if (item == item.getItemFromBlock(Blocks.coal_block) && item2 == item.getItemFromBlock(Blocks.coal_block) && item3 == item.getItemFromBlock(Blocks.coal_block) && item4 == item.getItemFromBlock(Blocks.coal_block) && item5 == item.getItemFromBlock(Blocks.coal_block) && item6 == item.getItemFromBlock(Blocks.coal_block) && item7 == item.getItemFromBlock(Blocks.coal_block) && item8 == item.getItemFromBlock(Blocks.coal_block) && item9 == item.getItemFromBlock(Blocks.coal_block)) {
			return new ItemStack(compress.CompressedCoalBlock, 1);
		}
		if (item == item.getItemFromBlock(Blocks.diamond_block) && item2 == item.getItemFromBlock(Blocks.diamond_block) && item3 == item.getItemFromBlock(Blocks.diamond_block) && item4 == item.getItemFromBlock(Blocks.diamond_block) && item5 == item.getItemFromBlock(Blocks.diamond_block) && item6 == item.getItemFromBlock(Blocks.diamond_block) && item7 == item.getItemFromBlock(Blocks.diamond_block) && item8 == item.getItemFromBlock(Blocks.diamond_block) && item9 == item.getItemFromBlock(Blocks.diamond_block)) {
			return new ItemStack(compress.CompressedDiaBlock, 1);
		}
		if (item == item.getItemFromBlock(Blocks.emerald_block) && item2 == item.getItemFromBlock(Blocks.emerald_block) && item3 == item.getItemFromBlock(Blocks.emerald_block) && item4 == item.getItemFromBlock(Blocks.emerald_block) && item5 == item.getItemFromBlock(Blocks.emerald_block) && item6 == item.getItemFromBlock(Blocks.emerald_block) && item7 == item.getItemFromBlock(Blocks.emerald_block) && item8 == item.getItemFromBlock(Blocks.emerald_block) && item9 == item.getItemFromBlock(Blocks.emerald_block)) {
			return new ItemStack(compress.CompressedEmeraldBlock, 1);
		}
		if (item == item.getItemFromBlock(Blocks.glowstone) && item2 == item.getItemFromBlock(Blocks.glowstone) && item3 == item.getItemFromBlock(Blocks.glowstone) && item4 == item.getItemFromBlock(Blocks.glowstone) && item5 == item.getItemFromBlock(Blocks.glowstone) && item6 == item.getItemFromBlock(Blocks.glowstone) && item7 == item.getItemFromBlock(Blocks.glowstone) && item8 == item.getItemFromBlock(Blocks.glowstone) && item9 == item.getItemFromBlock(Blocks.glowstone)) {
			return new ItemStack(compress.CompressedGlowstoneBlock, 1);
		}
		if (item == item.getItemFromBlock(Blocks.iron_block) && item2 == item.getItemFromBlock(Blocks.iron_block) && item3 == item.getItemFromBlock(Blocks.iron_block) && item4 == item.getItemFromBlock(Blocks.iron_block) && item5 == item.getItemFromBlock(Blocks.iron_block) && item6 == item.getItemFromBlock(Blocks.iron_block) && item7 == item.getItemFromBlock(Blocks.iron_block) && item8 == item.getItemFromBlock(Blocks.iron_block) && item9 == item.getItemFromBlock(Blocks.iron_block)) {
			return new ItemStack(compress.CompressedIronBlock, 1);
		}
		if (item == item.getItemFromBlock(Blocks.lapis_block) && item2 == item.getItemFromBlock(Blocks.lapis_block) && item3 == item.getItemFromBlock(Blocks.lapis_block) && item4 == item.getItemFromBlock(Blocks.lapis_block) && item5 == item.getItemFromBlock(Blocks.lapis_block) && item6 == item.getItemFromBlock(Blocks.lapis_block) && item7 == item.getItemFromBlock(Blocks.lapis_block) && item8 == item.getItemFromBlock(Blocks.lapis_block) && item9 == item.getItemFromBlock(Blocks.lapis_block)) {
			return new ItemStack(compress.CompressedLapisBlock, 1);
		}
		if (item == item.getItemFromBlock(Blocks.netherrack) && item2 == item.getItemFromBlock(Blocks.netherrack) && item3 == item.getItemFromBlock(Blocks.netherrack) && item4 == item.getItemFromBlock(Blocks.netherrack) && item5 == item.getItemFromBlock(Blocks.netherrack) && item6 == item.getItemFromBlock(Blocks.netherrack) && item7 == item.getItemFromBlock(Blocks.netherrack) && item8 == item.getItemFromBlock(Blocks.netherrack) && item9 == item.getItemFromBlock(Blocks.netherrack)) {
			return new ItemStack(compress.CompressedNetherrackBlock, 1);
		}
		if (item == item.getItemFromBlock(Blocks.obsidian) && item2 == item.getItemFromBlock(Blocks.obsidian) && item3 == item.getItemFromBlock(Blocks.obsidian) && item4 == item.getItemFromBlock(Blocks.obsidian) && item5 == item.getItemFromBlock(Blocks.obsidian) && item6 == item.getItemFromBlock(Blocks.obsidian) && item7 == item.getItemFromBlock(Blocks.obsidian) && item8 == item.getItemFromBlock(Blocks.obsidian) && item9 == item.getItemFromBlock(Blocks.obsidian)) {
			return new ItemStack(compress.CompressedObsidianBlock, 1);
		}
		if (item == item.getItemFromBlock(Blocks.quartz_block) && item2 == item.getItemFromBlock(Blocks.quartz_block) && item3 == item.getItemFromBlock(Blocks.quartz_block) && item4 == item.getItemFromBlock(Blocks.quartz_block) && item5 == item.getItemFromBlock(Blocks.quartz_block) && item6 == item.getItemFromBlock(Blocks.quartz_block) && item7 == item.getItemFromBlock(Blocks.quartz_block) && item8 == item.getItemFromBlock(Blocks.quartz_block) && item9 == item.getItemFromBlock(Blocks.quartz_block)) {
			return new ItemStack(compress.CompressedQuartzBlock, 1);
		}
		if (item == item.getItemFromBlock(Blocks.redstone_block) && item2 == item.getItemFromBlock(Blocks.redstone_block) && item3 == item.getItemFromBlock(Blocks.redstone_block) && item4 == item.getItemFromBlock(Blocks.redstone_block) && item5 == item.getItemFromBlock(Blocks.redstone_block) && item6 == item.getItemFromBlock(Blocks.redstone_block) && item7 == item.getItemFromBlock(Blocks.redstone_block) && item8 == item.getItemFromBlock(Blocks.redstone_block) && item9 == item.getItemFromBlock(Blocks.redstone_block)) {
			return new ItemStack(compress.CompressedRedstoneBlock, 1);
		}
		
		
		
		
		return null;
	}
	
}
