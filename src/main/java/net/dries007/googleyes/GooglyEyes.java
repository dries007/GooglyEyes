package net.dries007.googleyes;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

import static net.dries007.googleyes.ItemGooglyEyes.ITEM_GOOGLY_EYES;

@Mod(modid = "GooglyEyes")
public class GooglyEyes
{
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        GameRegistry.registerItem(ITEM_GOOGLY_EYES, ITEM_GOOGLY_EYES.name);
        if (event.getSide().isClient()) FMLCommonHandler.instance().bus().register(new ClientEventHandler());
    }
}
