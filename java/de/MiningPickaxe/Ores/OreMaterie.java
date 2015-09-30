package de.MiningPickaxe.Ores; 
 
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import de.MiningPickaxe.compress.compress;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.World;
 

public class OreMaterie extends Block{
	
	
	
        public OreMaterie(Material mat) {
                super(mat);
                
                
                this.setCreativeTab(compress.CompressTab);
                this.blockHardness=3F;
                this.blockResistance=5;
                this.setLightLevel(0F);
                this.setStepSound(soundTypeStone);
                this.setHarvestLevel("pickaxe", 2);
        }
       
        
        
        /**
         * Returns the dropped Item.
         */
        public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
        {
            return compress.materie;
        }
        
        
        /**
         * Returns the usual quantity dropped by the block plus a bonus of 1 to 'i' (inclusive).
         */
        public int quantityDroppedWithBonus(int i, Random j)
        {
            return this.quantityDropped(j) + j.nextInt(i + 1);
        }

        /**
         * Returns the quantity of items to drop on block destruction.
         */
        public int quantityDropped(Random k)
        {
            return 4 + k.nextInt(2);
        }

        /**
         * Drops the block items with a specified chance of dropping the specified items
         */
        public void dropBlockAsItemWithChance(World world, int i, int j, int k, int l, float u, int o)
        {
            super.dropBlockAsItemWithChance(world, i, j, k, l, u, o);
        }
        
        
        

		@SideOnly(Side.CLIENT)
        public void registerIcons(IIconRegister par1){
                this.blockIcon = par1.registerIcon(compress.MODID + ":OreMaterie");
        }
       
        public boolean isOpaqueCube(){
                return true;
        }
       
}
