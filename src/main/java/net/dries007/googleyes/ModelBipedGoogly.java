package net.dries007.googleyes;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;

/**
 * @author Dries007
 */
public class ModelBipedGoogly extends ModelBiped
{
    public ModelRenderer pupilLeft;
    public ModelRenderer pupilRight;

    public ModelBipedGoogly(EntityLivingBase entity)
    {
        super(0.01f);

        float pupilscale = 0.02f;

        this.isSneak = entity.isSneaking();

        this.pupilLeft = new ModelRenderer(this, 0, 16);
        this.pupilLeft.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, pupilscale);
        this.pupilLeft.setRotationPoint(0.0F, 0.0F + pupilscale, 0.0F);

        this.pupilRight = new ModelRenderer(this, 24, 16);
        this.pupilRight.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, pupilscale);
        this.pupilRight.setRotationPoint(0.0F, 0.0F + pupilscale, 0.0F);

        this.bipedHead.addChild(pupilLeft);
        this.bipedHead.addChild(pupilRight);
    }

    @Override
    public void render(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_)
    {
        super.render(p_78088_1_, p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_);
    }

    @Override
    public void setLivingAnimations(EntityLivingBase entity, float p_78086_2_, float p_78086_3_, float particleTime)
    {
        super.setLivingAnimations(entity, p_78086_2_, p_78086_3_, particleTime);

        final float prevAngleL = entity.getEntityData().getFloat("prevAngleL");
        final float angleL = entity.getEntityData().getFloat("angleL");
        final float partialAngleL = (prevAngleL + (angleL - prevAngleL) * particleTime) * (float)Math.PI / 180.0F;

        final float prevAngleR = entity.getEntityData().getFloat("prevAngleR");
        final float angleR = entity.getEntityData().getFloat("angleR");
        final float partialAngleR = (prevAngleR + (angleR - prevAngleR) * particleTime) * (float)Math.PI / 180.0F;
        
        this.pupilLeft.offsetX = 0.06f * MathHelper.sin(partialAngleL);
        this.pupilLeft.offsetY = 0.06f * MathHelper.cos(partialAngleL);

        this.pupilRight.offsetX = 0.06f * MathHelper.sin(partialAngleR);
        this.pupilRight.offsetY = 0.06f * MathHelper.cos(partialAngleR);

        this.bipedHead.showModel = true;
        this.bipedHeadwear.showModel = false;
        this.bipedBody.showModel = false;
        this.bipedRightArm.showModel = false;
        this.bipedLeftArm.showModel = false;
        this.bipedRightLeg.showModel = false;
        this.bipedLeftLeg.showModel = false;
        this.bipedEars.showModel = false;
        this.bipedCloak.showModel = false;
    }

    @Override
    public void setRotationAngles(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_)
    {
        super.setRotationAngles(p_78087_1_, p_78087_2_, p_78087_3_, p_78087_4_, p_78087_5_, p_78087_6_, p_78087_7_);
    }
}
