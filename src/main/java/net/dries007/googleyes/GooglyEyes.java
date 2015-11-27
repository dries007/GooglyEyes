package net.dries007.googleyes;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;

import static net.dries007.googleyes.ItemGooglyEyes.ITEM_GOOGLY_EYES;

@Mod(modid = GooglyEyes.NAME)
public class GooglyEyes
{
    public static final String NAME = "GooglyEyes";

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        GameRegistry.registerItem(ITEM_GOOGLY_EYES, GooglyEyes.NAME);
        CraftingManager.getInstance().addShapelessRecipe(new ItemStack(ITEM_GOOGLY_EYES), new ItemStack(Items.iron_helmet), new ItemStack(Blocks.glass_pane));
        if (event.getSide().isClient()) FMLCommonHandler.instance().bus().register(new ClientEventHandler());
    }
}
