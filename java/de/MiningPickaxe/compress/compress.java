package de.MiningPickaxe.compress;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import de.MiningPickaxe.compress.worldgen.compressWorldGen;
import de.MiningPickaxe.handler.GuiHandler;
import de.MiningPickaxe.tileentity.TileEntityblockStamper;
import cpw.mods.fml.common.network.IGuiHandler;

@Mod(modid = compress.MODID, version = compress.VERSION)
public class compress
{
    public static final String MODID = "compress";
    public static final String VERSION = "1.2beta1";
    
    compressWorldGen eventWorldGen = new compressWorldGen();
    
    public static CreativeTabs CompressTab = new CreativeTabs("CompressTab") {
		
		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {
			return Item.getItemFromBlock(CompressedGoldBlock);
		}
	};
    
	
	//Compressed Blöcke
    public static Block CompressedGoldBlock = new de.MiningPickaxe.compress.blocks.CompressedGoldBlock(Material.rock).setBlockName("CompressedGoldBlock").setBlockTextureName(MODID + ":CompressedGoldBlock");
    public static Block CompressedIronBlock = new de.MiningPickaxe.compress.blocks.CompressedIronBlock(Material.rock).setBlockName("CompressedIronBlock").setBlockTextureName(MODID + ":CompressedIronBlock");
    public static Block CompressedEmeraldBlock = new de.MiningPickaxe.compress.blocks.CompressedEmeraldBlock(Material.rock).setBlockName("CompressedEmeraldBlock").setBlockTextureName(MODID + ":CompressedEmeraldBlock");
    public static Block CompressedLapisBlock = new de.MiningPickaxe.compress.blocks.CompressedLapisBlock(Material.rock).setBlockName("CompressedLapisBlock").setBlockTextureName(MODID + ":CompressedLapisBlock");
    public static Block CompressedDiaBlock = new de.MiningPickaxe.compress.blocks.CompressedDiaBlock(Material.rock).setBlockName("CompressedDiaBlock").setBlockTextureName(MODID + ":CompressedDiaBlock");
    public static Block CompressedNetherrackBlock = new de.MiningPickaxe.compress.blocks.CompressedNetherrackBlock(Material.rock).setBlockName("CompressedNetherrackBlock").setBlockTextureName(MODID + ":CompressedNetherrackBlock");
    public static Block CompressedQuartzBlock = new de.MiningPickaxe.compress.blocks.CompressedQuartzBlock(Material.rock).setBlockName("CompressedQuartzBlock").setBlockTextureName(MODID + ":CompressedQuartzBlock");
    public static Block CompressedRedstoneBlock = new de.MiningPickaxe.compress.blocks.CompressedRedstoneBlock(Material.rock).setBlockName("CompressedRedstoneBlock").setBlockTextureName(MODID + ":CompressedRedstoneBlock");
    public static Block CompressedCoalBlock = new de.MiningPickaxe.compress.blocks.CompressedCoalBlock(Material.rock).setBlockName("CompressedCoalBlock").setBlockTextureName(MODID + ":CompressedCoalBlock");
    public static Block NetherstarBlock = new de.MiningPickaxe.compress.blocks.NetherstarBlock(Material.rock).setBlockName("NetherstarBlock").setBlockTextureName(MODID + ":NetherstarBlock");
    public static Block CompressedGlowstoneBlock = new de.MiningPickaxe.compress.blocks.CompressedGlowstoneBlock(Material.rock).setBlockName("CompressedGlowstoneBlock").setBlockTextureName(MODID + ":CompressedGlowstoneBlock");
    public static Block CompressedObsidianBlock = new de.MiningPickaxe.compress.blocks.CompressedObsidianBlock(Material.rock).setBlockName("CompressedObsidianBlock").setBlockTextureName(MODID + ":CompressedObsidianBlock");
    
    
    //Erze
    public static Block OreMaterie = new de.MiningPickaxe.Ores.OreMaterie(Material.rock).setBlockName("OreMaterie").setBlockTextureName(MODID + ":OreMaterie");
    
    
    //Items
    public static Item materie;
    
    //Maschine
    public static Block compressor = new de.MiningPickaxe.machine.blocks.compressor(Material.rock).setBlockName("compressor");
    public static final int guiIDcompressor = 1;
    
    public static Block blockStamperIdle = new de.MiningPickaxe.machine.blocks.blockStamper(false).setBlockName("blockStamperIdle").setCreativeTab(compress.CompressTab).setHardness(10F).setResistance(60F);
    public static Block blockStamperActive = new de.MiningPickaxe.machine.blocks.blockStamper(true).setBlockName("blockStamperActive").setHardness(10F).setResistance(60F);
    public static final int guiIDStamper = 1;
    
    
    
    @Instance(MODID)
    public static compress instance;
    
    @EventHandler
    public void preinit(FMLPreInitializationEvent event)
    {
    	//Compressed Blöcke
    	GameRegistry.registerBlock(CompressedGoldBlock, "CompressedGoldBlock");
    	GameRegistry.registerBlock(CompressedIronBlock, "CompressedIronBlock");
    	GameRegistry.registerBlock(CompressedEmeraldBlock, "CompressedEmeraldBlock");
    	GameRegistry.registerBlock(CompressedLapisBlock, "CompressedLapisBlock");
    	GameRegistry.registerBlock(CompressedDiaBlock, "CompressedDiaBlock");
    	GameRegistry.registerBlock(CompressedRedstoneBlock, "CompressedRedstoneBlock");
    	GameRegistry.registerBlock(CompressedQuartzBlock, "CompressedQuartzBlock");
    	GameRegistry.registerBlock(CompressedNetherrackBlock, "CompressedNetherrackBlock");
    	GameRegistry.registerBlock(CompressedCoalBlock, "CompressedCoalBlock");
    	GameRegistry.registerBlock(NetherstarBlock, "NetherstarBlock");
    	GameRegistry.registerBlock(CompressedGlowstoneBlock, "CompressedGlowstoneBlock");
    	GameRegistry.registerBlock(CompressedObsidianBlock, "CompressedObsidianBlock");
    	GameRegistry.registerBlock(blockStamperActive, "blockStamperActive");
    	GameRegistry.registerBlock(blockStamperIdle, "blockStamperIdle");
    	GameRegistry.registerBlock(OreMaterie, "OreMaterie");
    	
    	//Items
    	materie = new de.MiningPickaxe.items.materie().setUnlocalizedName("materie").setTextureName(MODID + ":materie");
    	GameRegistry.registerItem(materie, "materie");
    	
    	
    	
    	//Maschinen
    	GameRegistry.registerBlock(compressor, "compressor");
    	
    	//Spawn
        GameRegistry.registerWorldGenerator(eventWorldGen, 0);
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	//Craftingrezepte laden
    	CraftingRezepte();
    	
    	
    	
    	NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
    	GameRegistry.registerTileEntity(TileEntityblockStamper.class, "blockStamper");
    }
    
    @EventHandler
    public void postinit(FMLPostInitializationEvent event)
    {
    	
    	
    }
    
    public void CraftingRezepte(){
    	//Compressor
    	GameRegistry.addRecipe(new ItemStack(compress.compressor, 1), new Object[] {
    	"ipi",
    	"php",
    	"ipi",
    	Character.valueOf('p'), Blocks.piston,
    	Character.valueOf('h'), Blocks.hopper,
    	Character.valueOf('i'), Blocks.iron_block
    	});
    	
    	//rückwärts
    	
    	GameRegistry.addShapelessRecipe(new ItemStack(Blocks.gold_block,9), new ItemStack(CompressedGoldBlock));
    	GameRegistry.addShapelessRecipe(new ItemStack(Blocks.iron_block,9), new ItemStack(CompressedIronBlock));
    	GameRegistry.addShapelessRecipe(new ItemStack(Blocks.emerald_block,9), new ItemStack(CompressedEmeraldBlock));
    	GameRegistry.addShapelessRecipe(new ItemStack(Blocks.lapis_block,9), new ItemStack(CompressedLapisBlock));
    	GameRegistry.addShapelessRecipe(new ItemStack(Blocks.diamond_block,9), new ItemStack(CompressedDiaBlock));
    	GameRegistry.addShapelessRecipe(new ItemStack(Blocks.redstone_block,9), new ItemStack(CompressedRedstoneBlock));
    	GameRegistry.addShapelessRecipe(new ItemStack(Blocks.quartz_block,9), new ItemStack(CompressedQuartzBlock));
    	GameRegistry.addShapelessRecipe(new ItemStack(Blocks.netherrack,9), new ItemStack(CompressedNetherrackBlock));
    	GameRegistry.addShapelessRecipe(new ItemStack(Blocks.coal_block,9), new ItemStack(CompressedCoalBlock));
    	GameRegistry.addShapelessRecipe(new ItemStack(Items.nether_star,9), new ItemStack(NetherstarBlock));
    	GameRegistry.addShapelessRecipe(new ItemStack(Blocks.glowstone,9), new ItemStack(CompressedGlowstoneBlock));
    	GameRegistry.addShapelessRecipe(new ItemStack(Blocks.obsidian,9), new ItemStack(CompressedObsidianBlock));
    	
    }
    
}
