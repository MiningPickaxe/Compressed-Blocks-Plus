package de.MiningPickaxe.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import de.MiningPickaxe.compress.compress;
import de.MiningPickaxe.container.ContainerblockStamper;
import de.MiningPickaxe.container.Containercompressor;
import de.MiningPickaxe.gui.Guicompressor;
import de.MiningPickaxe.gui.guiblockStamper;
import de.MiningPickaxe.tileentity.TileEntityblockStamper;

public class GuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,	int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		
		if(entity != null) {
			switch(ID) {
			case compress.guiIDStamper:
				if (entity instanceof TileEntityblockStamper) {
					return new ContainerblockStamper(player.inventory, (TileEntityblockStamper) entity);
				}
				return null;
			}
		}
		
		if(ID == compress.guiIDcompressor) {
			return ID == compress.guiIDcompressor && world.getBlock(x, y, z) == compress.compressor ? new Containercompressor(player.inventory, world, x, y, z) : null;
		}
		
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,	int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		
		if(entity != null) {
			switch(ID) {
				
			case compress.guiIDStamper:
				if (entity instanceof TileEntityblockStamper) {
					return new guiblockStamper(player.inventory, (TileEntityblockStamper) entity);
				}
				return null;
			}
		}
		
		if(ID == compress.guiIDcompressor) {
			return ID == compress.guiIDcompressor && world.getBlock(x, y, z) == compress.compressor ? new Guicompressor(player.inventory, world, x, y, z) : null;
		}
		
		return null;
	}

}