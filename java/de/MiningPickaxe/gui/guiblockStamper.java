package de.MiningPickaxe.gui;

import org.lwjgl.opengl.GL11;

import de.MiningPickaxe.compress.compress;
import de.MiningPickaxe.container.ContainerblockStamper;
import de.MiningPickaxe.tileentity.TileEntityblockStamper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

public class guiblockStamper extends GuiContainer{
	
	private ResourceLocation texture = new ResourceLocation(compress.MODID + ":" + "/textures/gui/blockStamperGui.png");
	public TileEntityblockStamper blockStamper;
	
	public guiblockStamper(InventoryPlayer invPlayer, TileEntityblockStamper teblockStamper) {
		super(new ContainerblockStamper(invPlayer, teblockStamper));
		blockStamper = teblockStamper;
		
		this.xSize = 176;
		this.ySize = 188;
	}

	protected void drawGuiContainerForegroundLayer(int i, int j) {
		String name = this.blockStamper.hasCustomInventoryName() ? this.blockStamper.getInventoryName() : I18n.format(this.blockStamper.getInventoryName());
		
		this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) + 23, 6, 4210762);
		this.fontRendererObj.drawString(I18n.format("Container.inventory"), 8, 96, 4210752);
	}
	
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		
		//do the thing with the power
		if (blockStamper.hasPower()) {
			int i1 = blockStamper.getPowerRemainingScaled(53);
			drawTexturedModalRect(guiLeft + 17, guiTop + 72 - i1, 176, 123 - i1, 16, i1);
		}
		
		//do the thing with the stamping
		int j1 = blockStamper.getStamperProgressScaled(22);
		drawTexturedModalRect(guiLeft + 108, guiTop + 41, 176, 41, j1 + 1, 30);
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
