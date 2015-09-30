package de.MiningPickaxe.crafting;

import java.util.Comparator;

import net.minecraft.item.crafting.IRecipe;

public class compressorRecipeSorter implements Comparator {

	
	final compressorCraftingManager compressor;
	
	public compressorRecipeSorter(compressorCraftingManager compressorCraftingManager) {
		this.compressor = compressorCraftingManager;
	}
	
	public int compareRecipes(IRecipe irecipe1, IRecipe irecipe2) {
		return irecipe1 instanceof compressorShapelessRecipes && irecipe2 instanceof compressorShapedRecipes ? 1: (irecipe2 instanceof compressorShapelessRecipes && irecipe1 instanceof compressorShapedRecipes ? -1 : (irecipe2.getRecipeSize() < irecipe1.getRecipeSize() ? -1 : (irecipe2.getRecipeSize() > irecipe1.getRecipeSize() ? 1 : 0)));
	}
	
	@Override
	public int compare(Object o1, Object o2) {
		
		return this.compareRecipes((IRecipe)o1, (IRecipe)o2);
	}
	
}
