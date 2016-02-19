package de.MiningPickaxe.tools;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import de.MiningPickaxe.compress.compress;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemAxe;


public class CompressedWoodenAxe extends ItemAxe{

	public CompressedWoodenAxe(ToolMaterial mat) {
		super(mat);
		this.setCreativeTab(compress.CompressTab);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcrons(IIconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon(compress.MODID + ":" + "CompressedWoodenAxe");
	}
	

}
