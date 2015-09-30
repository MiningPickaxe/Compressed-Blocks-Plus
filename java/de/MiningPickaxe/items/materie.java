package de.MiningPickaxe.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import de.MiningPickaxe.compress.compress;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class materie extends Item {
	public materie() {
		maxStackSize = 64;
		this.setCreativeTab(compress.CompressTab);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1) {
		this.itemIcon = par1.registerIcon(compress.MODID + ":materie");
	}
	
}