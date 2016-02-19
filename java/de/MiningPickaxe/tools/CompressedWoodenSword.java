package de.MiningPickaxe.tools;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import de.MiningPickaxe.compress.compress;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemSword;

public class CompressedWoodenSword extends ItemSword{

	public CompressedWoodenSword(ToolMaterial p_i45356_1_) {
		super(p_i45356_1_);
		this.setCreativeTab(compress.CompressTab);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcrons(IIconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon(compress.MODID + ":" + "CompressedWoodenSword");
	}
	

}
