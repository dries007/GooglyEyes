package net.dries007.googleyes.integration;

import com.bioxx.tfc.Items.ItemTFCArmor;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.dries007.googleyes.GooglyEyes;
import net.dries007.googleyes.ModelBipedGoogly;
import net.dries007.googleyes.api.IGooglyEyes;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

/**
 * @author Dries007
 */
public class ItemGooglyEyesTFC extends ItemTFCArmor implements IGooglyEyes
{
    private final String[] icons = {GooglyEyes.NAME + ":0", GooglyEyes.NAME + ":1", GooglyEyes.NAME + ":2", GooglyEyes.NAME + ":3"};
    private IIcon[] iconArray = new IIcon[icons.length];

    public ItemGooglyEyesTFC(ItemTFCArmor itemTFCArmor)
    {
        super(itemTFCArmor.armorTypeTFC, 2, 0, itemTFCArmor.getArmorMaterial(), itemTFCArmor.getThermal(), itemTFCArmor.getBodyPart());
    }

    @Override
    public String getItemStackDisplayName(ItemStack p_77653_1_)
    {
        return super.getItemStackDisplayName(p_77653_1_) + " Googly Eyes";
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
