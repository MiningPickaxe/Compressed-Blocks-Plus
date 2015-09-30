package de.MiningPickaxe.crafting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import cpw.mods.fml.common.registry.GameRegistry;
import de.MiningPickaxe.compress.compress;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.world.World;

public class compressorCraftingManager
{
    /** The static instance of this class */
    private static final compressorCraftingManager instance = new compressorCraftingManager();
    /** A list of all the recipes added */
    private List recipes = new ArrayList();
    private static final String __OBFID = "CL_00000090";

    /**
     * Returns the static instance of this class
     */
    public static final compressorCraftingManager getInstance()
    {
        /** The static instance of this class */
        return instance;
    }

    private compressorCraftingManager()
    {
    	recipes = new ArrayList();
    	//Goldblock
    	this.addRecipe(new ItemStack(compress.CompressedGoldBlock, 1), new Object[] {
    	"ggg",
    	"ggg",
    	"ggg",
    	Character.valueOf('g'), Blocks.gold_block
    	});
    	//Eisen
    	this.addRecipe(new ItemStack(compress.CompressedIronBlock, 1), new Object[] {
    			"iii",
    			"iii",
    			"iii",
    			Character.valueOf('i'), Blocks.iron_block
    	});
    	
    	//Emerald
    	this.addRecipe(new ItemStack(compress.CompressedEmeraldBlock, 1), new Object[]{
    			"eee",
    			"eee",
    			"eee",
    			Character.valueOf('e'), Blocks.emerald_block			
    	});
    	
     	//Lapis
    	this.addRecipe(new ItemStack(compress.CompressedLapisBlock, 1), new Object[]{
    			"lll",
    			"lll",
    			"lll",
    			Character.valueOf('l'), Blocks.lapis_block
    	});
    	
    	
    	//Diablock
    	this.addRecipe(new ItemStack(compress.CompressedDiaBlock, 1), new Object[] {
    	"ddd",
    	"ddd",
    	"ddd",
    	Character.valueOf('d'), Blocks.diamond_block
    	});
    	
    	//Redstone
    	this.addRecipe(new ItemStack(compress.CompressedRedstoneBlock, 1), new Object[] {
   		"rrr",
    	"rrr",
  		"rrr",
  		Character.valueOf('r'), Blocks.redstone_block
  		});
    	
    	//Quartz
    	this.addRecipe(new ItemStack(compress.CompressedQuartzBlock, 1), new Object[] {
    	"qqq",
    	"qqq",
    	"qqq",
    	Character.valueOf('q'), Blocks.quartz_block 
    	});
    	
    	//Netherrack
    	this.addRecipe(new ItemStack(compress.CompressedNetherrackBlock, 1), new Object[] {
    	"nnn",
    	"nnn",
    	"nnn",
    	Character.valueOf('n'), Blocks.netherrack
    	});
    	
    	//Coal
    	this.addRecipe(new ItemStack(compress.CompressedCoalBlock, 1), new Object[] {
    	"ccc",
    	"ccc",
    	"ccc",
    	Character.valueOf('c'), Blocks.coal_block
    	});
    	
    	//Netherstar
    	this.addRecipe(new ItemStack(compress.NetherstarBlock, 1), new Object[] {
    	"sss",
    	"sss",
    	"sss",
    	Character.valueOf('s'), Items.nether_star
    	});
    	
    	//Glowstone
    	this.addRecipe(new ItemStack(compress.CompressedGlowstoneBlock, 1), new Object[] {
    	"ccc",
    	"ccc",
    	"ccc",
    	Character.valueOf('c'), Blocks.glowstone
    	});
    	
    	//Obsidian
    	this.addRecipe(new ItemStack(compress.CompressedObsidianBlock, 1), new Object[] {
    	"ooo",
    	"ooo",
    	"ooo",
    	Character.valueOf('o'), Blocks.obsidian
    	});
    	
    	
    	
    	
    	
        Collections.sort(this.recipes, new compressorRecipeSorter(this));
    }

    public compressorShapedRecipes addRecipe(ItemStack p_92103_1_, Object ... p_92103_2_)
    {
        String s = "";
        int i = 0;
        int j = 0;
        int k = 0;

        if (p_92103_2_[i] instanceof String[])
        {
            String[] astring = (String[])((String[])p_92103_2_[i++]);

            for (int l = 0; l < astring.length; ++l)
            {
                String s1 = astring[l];
                ++k;
                j = s1.length();
                s = s + s1;
            }
        }
        else
        {
            while (p_92103_2_[i] instanceof String)
            {
                String s2 = (String)p_92103_2_[i++];
                ++k;
                j = s2.length();
                s = s + s2;
            }
        }

        HashMap hashmap;

        for (hashmap = new HashMap(); i < p_92103_2_.length; i += 2)
        {
            Character character = (Character)p_92103_2_[i];
            ItemStack itemstack1 = null;

            if (p_92103_2_[i + 1] instanceof Item)
            {
                itemstack1 = new ItemStack((Item)p_92103_2_[i + 1]);
            }
            else if (p_92103_2_[i + 1] instanceof Block)
            {
                itemstack1 = new ItemStack((Block)p_92103_2_[i + 1], 1, 32767);
            }
            else if (p_92103_2_[i + 1] instanceof ItemStack)
            {
                itemstack1 = (ItemStack)p_92103_2_[i + 1];
            }

            hashmap.put(character, itemstack1);
        }

        ItemStack[] aitemstack = new ItemStack[j * k];

        for (int i1 = 0; i1 < j * k; ++i1)
        {
            char c0 = s.charAt(i1);

            if (hashmap.containsKey(Character.valueOf(c0)))
            {
                aitemstack[i1] = ((ItemStack)hashmap.get(Character.valueOf(c0))).copy();
            }
            else
            {
                aitemstack[i1] = null;
            }
        }

        compressorShapedRecipes shapedrecipes = new compressorShapedRecipes(j, k, aitemstack, p_92103_1_);
        this.recipes.add(shapedrecipes);
        return shapedrecipes;
    }

    public void addShapelessRecipe(ItemStack p_77596_1_, Object ... p_77596_2_)
    {
        ArrayList arraylist = new ArrayList();
        Object[] aobject = p_77596_2_;
        int i = p_77596_2_.length;

        for (int j = 0; j < i; ++j)
        {
            Object object1 = aobject[j];

            if (object1 instanceof ItemStack)
            {
                arraylist.add(((ItemStack)object1).copy());
            }
            else if (object1 instanceof Item)
            {
                arraylist.add(new ItemStack((Item)object1));
            }
            else
            {
                if (!(object1 instanceof Block))
                {
                    throw new RuntimeException("Invalid shapeless recipe!");
                }

                arraylist.add(new ItemStack((Block)object1));
            }
        }

        this.recipes.add(new ShapelessRecipes(p_77596_1_, arraylist));
    }

    public ItemStack findMatchingRecipe(InventoryCrafting p_82787_1_, World p_82787_2_)
    {
        int i = 0;
        ItemStack itemstack = null;
        ItemStack itemstack1 = null;
        int j;

        for (j = 0; j < p_82787_1_.getSizeInventory(); ++j)
        {
            ItemStack itemstack2 = p_82787_1_.getStackInSlot(j);

            if (itemstack2 != null)
            {
                if (i == 0)
                {
                    itemstack = itemstack2;
                }

                if (i == 1)
                {
                    itemstack1 = itemstack2;
                }

                ++i;
            }
        }

        if (i == 2 && itemstack.getItem() == itemstack1.getItem() && itemstack.stackSize == 1 && itemstack1.stackSize == 1 && itemstack.getItem().isRepairable())
        {
            Item item = itemstack.getItem();
            int j1 = item.getMaxDamage() - itemstack.getItemDamageForDisplay();
            int k = item.getMaxDamage() - itemstack1.getItemDamageForDisplay();
            int l = j1 + k + item.getMaxDamage() * 5 / 100;
            int i1 = item.getMaxDamage() - l;

            if (i1 < 0)
            {
                i1 = 0;
            }

            return new ItemStack(itemstack.getItem(), 1, i1);
        }
        else
        {
            for (j = 0; j < this.recipes.size(); ++j)
            {
                IRecipe irecipe = (IRecipe)this.recipes.get(j);

                if (irecipe.matches(p_82787_1_, p_82787_2_))
                {
                	//Minecraft.getMinecraft().thePlayer.playSound("random.anvil_use", 0.5F, 0.5F);
                	return irecipe.getCraftingResult(p_82787_1_);
                    
                }
            }

            return null;
        }
    }

    /**
     * returns the List<> of all recipes
     */
    public List getRecipeList()
    {
        return this.recipes;
    }
}