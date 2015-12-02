package net.dries007.googleyes;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

/**
 * @author Dries007
 */
public class ItemGooglyEyes extends ItemArmor
{
    private final String[] icons = {GooglyEyes.NAME + ":0", GooglyEyes.NAME + ":1", GooglyEyes.NAME + ":2", GooglyEyes.NAME + ":3"};
    private IIcon[] iconArray = new IIcon[icons.length];

    public ItemGooglyEyes(ItemArmor.ArmorMaterial material)
    {
        super(material, 2, 0);
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
        return GooglyEyes.NAME + ":textures/models/armor/googly.png";
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void renderHelmetOverlay(ItemStack stack, EntityPlayer player, ScaledResolution resolution, float partialTicks, boolean hasScreen, int mouseX, int mouseY)
    {
        super.renderHelmetOverlay(stack, player, resolution, partialTicks, hasScreen, mouseX, mouseY);
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon()
    {
        return iconArray[((int) ((System.currentTimeMillis() / 150) % iconArray.length))];
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIconIndex(ItemStack p_77650_1_)
    {
        return getIcon();
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(ItemStack stack, int pass)
    {
        return getIcon();
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIconFromDamageForRenderPass(int p_77618_1_, int p_77618_2_)
    {
        return getIcon();
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIconFromDamage(int p_77617_1_)
    {
        return getIcon();
    }

    @Override
    public IIcon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining)
    {
        return super.getIcon(stack, renderPass, player, usingItem, useRemaining);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister ir)
    {
        for (int i = 0; i < icons.length; i++)
        {
            iconArray[i] = ir.registerIcon(icons[i]);
        }
    }
}
