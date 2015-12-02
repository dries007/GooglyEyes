package net.dries007.googleyes;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.util.StatCollector;

import java.util.HashSet;

@Mod(modid = GooglyEyes.NAME, useMetadata = false, dependencies = "after:*")
public class GooglyEyes
{
    public static final String NAME = "GooglyEyes";

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        HashSet<ItemArmor> toAdd = new HashSet<>();

        for (Item item : GameData.getItemRegistry().typeSafeIterable())
        {
            if (!(item instanceof ItemArmor)) continue;
            ItemArmor armor = (ItemArmor) item;
            if (armor.armorType != 0 || armor.getArmorMaterial() == null) continue;
            toAdd.add(armor);
        }

        for (ItemArmor armor : toAdd)
        {
            String name = GooglyEyes.NAME + "." + (armor.getUnlocalizedName().startsWith("item.") ? armor.getUnlocalizedName().substring("item.".length()) : armor.getUnlocalizedName());

            ItemGooglyEyes itemGooglyEyes = new ItemGooglyEyes(armor.getArmorMaterial());
            itemGooglyEyes.setUnlocalizedName(name);
            event.getModLog().info("Added googly eyes version of {}. Localized to {}", armor.getUnlocalizedName(), StatCollector.translateToLocal(itemGooglyEyes.getUnlocalizedName() + ".name"));
            GameRegistry.registerItem(itemGooglyEyes, name);
            CraftingManager.getInstance().addShapelessRecipe(new ItemStack(itemGooglyEyes), new ItemStack(armor), new ItemStack(Blocks.glass_pane));
        }

        if (event.getSide().isClient()) FMLCommonHandler.instance().bus().register(new ClientEventHandler());
    }
}
