package net.dries007.googleyes;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import org.lwjgl.Sys;

import java.util.Random;

/**
 * @author Dries007
 */
public class ClientEventHandler
{
    @SubscribeEvent
    public void tickEntity(TickEvent.ClientTickEvent event)
    {
        if (event.phase != TickEvent.Phase.START) return;

        if (Minecraft.getMinecraft().theWorld == null) return;

        for (Object obj : Minecraft.getMinecraft().theWorld.getLoadedEntityList())
        {
            if (!(obj instanceof EntityLivingBase)) continue;
            EntityLivingBase entity = ((EntityLivingBase) obj);
            ItemStack stack = entity.getEquipmentInSlot(4); // Head slot
            if (stack == null || stack.getItem() != ItemGooglyEyes.ITEM_GOOGLY_EYES) continue;

            NBTTagCompound compound = entity.getEntityData();
            final float prevAngleL = compound.getFloat("angleL");
            compound.setFloat("prevAngleL", prevAngleL);
            final float prevAngleR = compound.getFloat("angleR");
            compound.setFloat("prevAngleR", prevAngleR);

            Random random = new Random();
            float randAngle = compound.getFloat("randAngle");
            compound.setFloat("prevOffsetX", randAngle);
            randAngle += (random.nextFloat() - 0.5f) * 5f;
            randAngle = MathHelper.clamp_float(randAngle, -15, 15);
            compound.setFloat("randAngle", randAngle);

            float swingfactor = entity.swingProgress > 0.5f ? 85f - entity.swingProgress * 85f : entity.swingProgress * 85f;

            float walkfactor = (entity.distanceWalkedModified - compound.getFloat("prevWalked")) * -250f * entity.moveForward;
            compound.setFloat("prevWalked", entity.distanceWalkedModified);

            float yawDiff = (entity.rotationYawHead - compound.getFloat("prevYaw")) * 5f;
            compound.setFloat("prevYaw", entity.rotationYawHead);

            float yFactor = (float) (entity.motionY * 250);

            compound.setFloat("angleL", yawDiff + randAngle + swingfactor - walkfactor + yFactor);
            compound.setFloat("angleR", yawDiff - randAngle - swingfactor + walkfactor - yFactor);
        }
    }
}