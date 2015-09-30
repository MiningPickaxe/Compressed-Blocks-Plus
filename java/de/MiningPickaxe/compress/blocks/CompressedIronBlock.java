package de.MiningPickaxe.compress.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import de.MiningPickaxe.compress.compress;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;

public class CompressedIronBlock extends Block{
	public CompressedIronBlock(Material mat) {
		super(mat);
		this.setCreativeTab(compress.CompressTab);
		this.blockHardness=10F;
		this.blockResistance=60;
		this.setLightLevel(0F);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1){
		this.blockIcon = par1.registerIcon(compress.MODID + ":CompressedIronBlock");
	}
	
	public boolean isOpaqueCube(){
		return true;
	}
	
}
