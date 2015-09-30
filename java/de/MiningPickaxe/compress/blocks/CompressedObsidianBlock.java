package de.MiningPickaxe.compress.blocks;
 
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import de.MiningPickaxe.compress.compress;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
 
 
public class CompressedObsidianBlock extends Block{
        public CompressedObsidianBlock(Material mat) {
                super(mat);
                this.setCreativeTab(compress.CompressTab);
                this.blockHardness=100F;
                this.blockResistance=12000;
                this.setLightLevel(0F);
        }
       
        @SideOnly(Side.CLIENT)
        public void registerIcons(IIconRegister par1){
                this.blockIcon = par1.registerIcon(compress.MODID + ":CompressedObsidianBlock");
        }
       
        public boolean isOpaqueCube(){
                return true;
        }
       
}