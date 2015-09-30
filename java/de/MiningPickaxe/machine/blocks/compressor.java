package de.MiningPickaxe.machine.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import de.MiningPickaxe.compress.compress;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class compressor extends Block {
	
	@SideOnly(Side.CLIENT)
	private IIcon compressorTop;

	public compressor(Material mat) {
		super(mat);
		this.setCreativeTab(compress.CompressTab);
		this.blockHardness=5F;
		this.blockResistance=30F;
		this.setLightLevel(0F);
	}
	public boolean isOpaqueCube(){
		return true;
	}
	
	@SideOnly(Side.CLIENT)
	public IIcon getIcon (int side, int metadata) {
		return side == 1 ? this.compressorTop : this.blockIcon;
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons (IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(compress.MODID + ":" + "compressorSide");
		this.compressorTop = iconRegister.registerIcon(compress.MODID + ":" + "compressorTop");
	}
	
	public boolean onBlockActivated (World world, int x, int y, int z, EntityPlayer player, int q, float a, float b, float c) {
		
		if (!player.isSneaking()) {
			player.openGui(compress.instance, compress.guiIDcompressor, world, x, y, z);
			return true;
		}else{
				return false;
			
		}
		
	}
	
}
