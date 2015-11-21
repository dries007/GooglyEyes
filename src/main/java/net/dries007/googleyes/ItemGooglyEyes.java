package net.dries007.googleyes;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

/**
 * @author Dries007
 */
public class ItemGooglyEyes extends ItemArmor
{
    public final String name = "googlyEyes";
    public static final ItemGooglyEyes ITEM_GOOGLY_EYES = new ItemGooglyEyes();

    public ItemGooglyEyes()
    {
        super(ArmorMaterial.IRON, 2, 0);
        setUnlocalizedName(name);
        setUnlocalizedName("googly_eyes");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int p_77032_2_)
    {
        return new ModelBipedGoogly(entityLiving);
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
    {
        return "googlyeyes:textures/models/armor/googly.png";
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void renderHelmetOverlay(ItemStack stack, EntityPlayer player, ScaledResolution resolution, float partialTicks, boolean hasScreen, int mouseX, int mouseY)
    {
        super.renderHelmetOverlay(stack, player, resolution, partialTicks, hasScreen, mouseX, mouseY);
    }
}
