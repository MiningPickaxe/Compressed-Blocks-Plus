package de.MiningPickaxe.compress.blocks; 
 
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import de.MiningPickaxe.compress.compress;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
 

public class CompressedGlowstoneBlock extends Block{
        public CompressedGlowstoneBlock(Material mat) {
                super(mat);
                this.setCreativeTab(compress.CompressTab);
                this.blockHardness=0.6F;
                this.blockResistance=3F;
                this.setLightLevel(1F);
        }
       
        @SideOnly(Side.CLIENT)
        public void registerIcons(IIconRegister par1){
                this.blockIcon = par1.registerIcon(compress.MODID + ":CompressedGlowstoneBlock"); 
        }
       
        public boolean isOpaqueCube(){
                return true;
        }
       
}