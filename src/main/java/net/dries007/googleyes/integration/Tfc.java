package net.dries007.googleyes.integration;

import com.bioxx.tfc.Items.ItemTFCArmor;
import net.minecraft.item.ItemArmor;

/**
 * @author Dries007
 */
public class Tfc
{
    public static boolean applies(ItemArmor armor)
    {
        return armor instanceof ItemTFCArmor;
    }

    public static ItemArmor make(ItemArmor armor)
    {
        return new ItemGooglyEyesTFC((com.bioxx.tfc.Items.ItemTFCArmor) armor);
    }
}
