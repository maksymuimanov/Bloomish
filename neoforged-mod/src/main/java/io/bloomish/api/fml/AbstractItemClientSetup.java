package io.bloomish.api.fml;

import net.minecraft.client.renderer.item.ClampedItemPropertyFunction;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public abstract class AbstractItemClientSetup implements FmlClientSetup<Item> {
    protected void registerProperty(Item item, String property, ClampedItemPropertyFunction propertyFunction) {
        ItemProperties.register(item, ResourceLocation.withDefaultNamespace(property), propertyFunction);
    }

    protected boolean isEntityUsing(ItemStack stack, LivingEntity entity) {
        return entity != null && entity.isUsingItem() && entity.getUseItem() == stack;
    }
}
