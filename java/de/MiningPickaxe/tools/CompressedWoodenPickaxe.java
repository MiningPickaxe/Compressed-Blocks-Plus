package de.MiningPickaxe.tools;

import net.minecraft.item.Item.ToolMaterial;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import de.MiningPickaxe.compress.compress;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemPickaxe;

public class CompressedWoodenPickaxe extends ItemPickaxe{

	public CompressedWoodenPickaxe(ToolMaterial mat) {
		super(mat);
		this.setCreativeTab(compress.CompressTab);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcrons(IIconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon(compress.MODID + ":" + "CompressedWoodenAxe");
	}
	

}
