package de.MiningPickaxe.container;

import de.MiningPickaxe.slot.SlotblockStamper;
import de.MiningPickaxe.tileentity.TileEntityblockStamper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntityFurnace;

public class ContainerblockStamper extends Container {

	private TileEntityblockStamper stamper;
	private int nonaCookTime;
	private int nonaPower;
	private int lastItemBurnTime;
	
	public ContainerblockStamper(InventoryPlayer invPlayer, TileEntityblockStamper teblockStamper) {
		nonaCookTime = 0;
		nonaPower = 0;
		lastItemBurnTime = 0;
		
		stamper = teblockStamper;
		
		this.addSlotToContainer(new Slot(teblockStamper, 0, 52, 25)); //Matrix links oben
		this.addSlotToContainer(new Slot(teblockStamper, 1, 70, 25)); //Matrix mitte oben
		this.addSlotToContainer(new Slot(teblockStamper, 2, 88, 25)); //Matrix rechts oben
		this.addSlotToContainer(new Slot(teblockStamper, 3, 52, 43)); //Matrix links mitte
		this.addSlotToContainer(new Slot(teblockStamper, 4, 70, 43)); //Matrix mitte mitte
		this.addSlotToContainer(new Slot(teblockStamper, 5, 88, 43)); //Matrix rechts mitte
		this.addSlotToContainer(new Slot(teblockStamper, 6, 52, 61)); //Matrix links unten
		this.addSlotToContainer(new Slot(teblockStamper, 7, 70, 61)); //Matrix mitte unten
		this.addSlotToContainer(new Slot(teblockStamper, 8, 88, 61)); //Matrix rechts unten
		this.addSlotToContainer(new Slot(teblockStamper, 9, 17, 77)); //Fuel
		this.addSlotToContainer(new SlotblockStamper(invPlayer.player, teblockStamper, 10, 141, 43)); //Output
		//Inventory
		for (int i = 0; i < 3; i++) {
			for(int k = 0; k < 9; k++) {
				this.addSlotToContainer(new Slot(invPlayer, k + i * 9 + 9, 8 + k * 18, 106 + i * 18));
			}
		}
		//Hotbar
		for (int i = 0; i < 9; i++) {
			this.addSlotToContainer(new Slot(invPlayer, i, 8 + i * 18, 164));
		}
		
	}
	
	public void addCraftingToCrafters (ICrafting crafting) {
		super.addCraftingToCrafters(crafting);
		crafting.sendProgressBarUpdate(this, 0, this.stamper.nonaCookTime);
		crafting.sendProgressBarUpdate(this, 1, this.stamper.nonaPower);
	}
	
	
	
	
	public ItemStack transferStackInSlot(EntityPlayer p_82846_1_, int p_82846_2_)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(p_82846_2_);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (p_82846_2_ < 9)
            {
                if (!this.mergeItemStack(itemstack1, 9, 45, true))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 0, 9, false))
            {
                return null;
            }

            if (itemstack1.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize)
            {
                return null;
            }

            slot.onPickupFromSlot(p_82846_1_, itemstack1);
        }

        return itemstack;
    }
	
	
	
	
	
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return stamper.isUseableByPlayer(player);
	}
	
	public void detectAndSendChanges() {
		super.detectAndSendChanges();
		
		for (int i = 0; i < this.crafters.size(); i++) {
			ICrafting par1 = (ICrafting)this.crafters.get(i);
			
			if (this.nonaCookTime != this.stamper.nonaCookTime) {
				par1.sendProgressBarUpdate(this, 0, this.stamper.nonaCookTime);
			}
			
			if (this.nonaPower != this.stamper.nonaPower) {
				par1.sendProgressBarUpdate(this, 1, this.stamper.nonaPower);
			}
		}
		
		this.nonaCookTime = this.stamper.nonaCookTime;
		this.nonaPower = this.stamper.nonaPower;
		
	}
	
	public void updateProgressBar(int i, int j) {
		if (i == 0) {
			stamper.nonaCookTime = j;
		}
		if (i == 1) {
			stamper.nonaPower = j;
		}
	}

}
