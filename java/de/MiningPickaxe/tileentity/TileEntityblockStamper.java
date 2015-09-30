package de.MiningPickaxe.tileentity;

import de.MiningPickaxe.crafting.StamperRecipes;
import de.MiningPickaxe.machine.blocks.blockStamper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityblockStamper extends TileEntity implements ISidedInventory {

	private ItemStack slots[];
	public int nonaPower;
	public int nonaCookTime;
	public static final int maxPower = 10000;
	public static final int stampingSpeed = 150;
	
	private static final int[] slots_top = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8};
	private static final int[] slots_bottom = new int[] {10};
	private static final int[] slots_side = new int[] {9};
	
	private String customName;
	
	
	public TileEntityblockStamper() {
		slots = new ItemStack[11];
	}
	
	
	@Override
	public int getSizeInventory() {
		return slots.length;
	}
	@Override
	public ItemStack getStackInSlot(int i) {
		return slots[i];
	}

	
	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		if (slots[i] != null) {
			ItemStack itemstack = slots[i];
			slots[i] = null;
			return itemstack;
		}else{
			return null;
		}
	}
	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {
		slots[i] = itemstack;
		if (itemstack != null && itemstack.stackSize > getInventoryStackLimit()) {
			itemstack.stackSize = getInventoryStackLimit();
		}
		
	}
	@Override
	public String getInventoryName() {
		return this.hasCustomInventoryName() ? this.customName : "container.blockStamper";
	}
	@Override
	public boolean hasCustomInventoryName() {
		return this.customName != null && this.customName.length() > 0;
	}
	@Override
	public int getInventoryStackLimit() {
		return 64;
	}
	
	/*@Override
	public void setGuiDisplayName (String name) {
		this.customName = name;
	} */
	
	
	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		if (worldObj.getTileEntity(xCoord, yCoord, zCoord) != this) {
			return false;
		} else{
			return player.getDistanceSq((double)xCoord + 0.5D, (double)yCoord + 0.5D, (double)zCoord + 0.5D) <= 64;
		}
	}

	public void openInventory() {
	}
	
	public void closeInventory() {
	}
	
	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		
		return i == 9 ? false : (i == 1 ? hasItemPower(itemstack) : true);
	}
	
	public boolean hasItemPower(ItemStack itemstack) {
		return getItemPower(itemstack) > 0;
	}
	
	private static int getItemPower (ItemStack itemstack) {
		if (itemstack == null) {
			return 0;
		}else{
			Item item = itemstack.getItem();
			
			if (item == Items.coal) return 150;
			
			return 0;
		}
	}
	
	@Override
	public ItemStack decrStackSize(int i, int j) {
		if (slots[i] != null) {
			if(slots[i].stackSize <=j) {
				ItemStack itemstack = slots[i];
				slots[i] = null;
				return itemstack;
			}
			
			ItemStack itemstack1 = slots[i].splitStack(j);
			
			if (slots[i].stackSize == 0) {
				slots[i] = null;
			}
			return itemstack1;
		}else{
			return null;
		}
	}
	
	public void readFromNBT (NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		NBTTagList list = nbt.getTagList("Items", 10);
		slots = new ItemStack[getSizeInventory()];
		
		for (int i = 0; i < list.tagCount(); i++) {
			NBTTagCompound nbt1 = (NBTTagCompound)list.getCompoundTagAt(i);
			byte b0 = nbt1.getByte("Slot");
			
			if (b0 >= 0 && b0 < slots.length) {
				slots[b0] = ItemStack.loadItemStackFromNBT(nbt1);
			}
		}
		
		nonaPower = nbt.getShort("PowerTime");
		nonaCookTime = nbt.getShort("CookTime");
	}
	
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setShort("PowerTime", (short)nonaPower);
		nbt.setShort("CookTime", (short)nonaCookTime);
		NBTTagList list = new NBTTagList();
		
		for (int i = 0; i < slots.length; i++) {
			if (slots[i] != null) {
				NBTTagCompound nbt1 = new NBTTagCompound();
				nbt1.setByte("Slot", (byte)i);
				slots[i].writeToNBT(nbt1);
				list.appendTag(nbt1);
			}
		}
		
		nbt.setTag("Items", list);
		
	}
	
	@Override
	public int[] getAccessibleSlotsFromSide (int i) {
		return i == 0 ? slots_bottom : (i == 1 ? slots_top : slots_side);
	}




	@Override
	public boolean canInsertItem(int var1, ItemStack itemstack, int var3) {
		return this.isItemValidForSlot(var1, itemstack);
	}


	@Override
	public boolean canExtractItem(int i, ItemStack itemstack, int j) {
		return j != 0 || i != 1 || itemstack.getItem() == Items.bucket;
	}
	
	public int getStamperProgressScaled(int i) {
		return (nonaCookTime * i) / this.stampingSpeed;
	}
	
	
	public int getPowerRemainingScaled(int i) {
		return (nonaPower * i) / maxPower;
	}
	
	private boolean canStamp() {
		
		if (slots[0] == null || slots[1] == null || slots[2] == null || slots[3] == null || slots[4] == null || slots[5] == null || slots[6] == null || slots[7] == null || slots[8] == null || slots[9] == null) {
			return false;
		}
		
		ItemStack itemstack = StamperRecipes.getStampingResult(slots[0].getItem(), slots[1].getItem(), slots[2].getItem(), slots[3].getItem(), slots[4].getItem(), slots[5].getItem(), slots[6].getItem(), slots[7].getItem(), slots[8].getItem());
		
		if (itemstack == null) {
			return false;
		}
		
		if (slots[10] == null) {
			return true;
		}
		
		if (!slots[10].isItemEqual(itemstack)) {
			return false;
		}
		
		if (slots[10].stackSize < getInventoryStackLimit() && slots[10].stackSize < slots[10].getMaxStackSize()) {
			return true;
		}else{
			return slots[10].stackSize < itemstack.getMaxStackSize();
		}
		
		
	}
	
	private void StampItem() {
		if (canStamp()) {
			ItemStack itemstack = StamperRecipes.getStampingResult(slots[0].getItem(), slots[1].getItem(), slots[2].getItem(), slots[3].getItem(), slots[4].getItem(), slots[5].getItem(), slots[6].getItem(), slots[7].getItem(), slots[8].getItem());
			
			if (slots[10] == null) {
				slots[10] = itemstack.copy();
			}else if (slots[10].isItemEqual(itemstack)) {
				slots[10].stackSize += itemstack.stackSize;
			}
			
			for (int i = 0; i < 9; i++) {
				if (slots[i].stackSize <= 0) {
					slots[i] = new ItemStack(slots[i].getItem().setFull3D());
				}else{
					slots[i].stackSize--;
				}
				
				if (slots[i].stackSize <= 0) {
					slots[i] = null;
				}
			}
			
		}
		
		
		
		
		
		

		
	}
	
	public boolean hasPower() {
		return nonaPower > 0;
	}
	
	public boolean isStamping() {
		return this.nonaCookTime != 0;//this is not working i think?!
	}
	
	
	public void updateEntity() {
		boolean flag = this.hasPower();
		boolean flag1 = false;
		
		if (hasPower() && this.isStamping()) {
			this.nonaPower--;
		}
		
		if (!worldObj.isRemote) {
			if (this.hasItemPower(this.slots[9]) && this.nonaPower < (this.maxPower - this.getItemPower(this.slots[9]))) {
				this.nonaPower += getItemPower(this.slots[9]);
				
				if (this.slots[9] != null) {
					flag1 = true;
					
					this.slots[9].stackSize--;
					
					if (this.slots[9].stackSize == 0) {
						this.slots[9] = this.slots[9].getItem().getContainerItem(this.slots[9]);
						
					}
				}
			}
			
			if (hasPower() && canStamp()) {
				nonaCookTime++;
				
				if (this.nonaCookTime == this.stampingSpeed) {
					this.nonaCookTime = 0;
					this.StampItem();
					flag1 = true;
				}
			}else{
				nonaCookTime = 0;
			}
			
			if (flag != this.isStamping()) {
				flag1 = true;
				blockStamper.updateBlockState(this.isStamping(), this.worldObj, this.xCoord, this.yCoord, this.zCoord);//works if i set it manual
			}
			
		}
		
		if (flag1) {
			this.markDirty();
		}
		
	}
	
}




