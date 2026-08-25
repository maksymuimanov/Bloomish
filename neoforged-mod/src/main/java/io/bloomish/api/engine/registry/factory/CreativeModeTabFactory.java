package io.bloomish.api.engine.registry.factory;

import io.bloomish.api.engine.context.DefaultObjectRegistry;
import io.bloomish.api.engine.registry.BloomishRegister;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.Collection;

public class CreativeModeTabFactory extends AbstractObjectFactory<CreativeModeTab> {
    public CreativeModeTabFactory() {
        this(DefaultObjectRegistry.getFromInstance("$CreativeModeTabs"));
    }

    public CreativeModeTabFactory(BloomishRegister<CreativeModeTab> register) {
        super(register);
    }

    public DeferredHolder<CreativeModeTab, CreativeModeTab> create(String name, Item icon, String translationId, Item... items) {
        return this.create(name, () -> CreativeModeTab.builder()
                .icon(() -> new ItemStack(icon))
                .title(Component.translatable(translationId))
                .displayItems((displayParameters, output) -> {
                    for (Item item : items) {
                        output.accept(item);
                    }
                }).build());
    }

    public DeferredHolder<CreativeModeTab, CreativeModeTab> create(String name, Item icon, String translationId, Collection<ItemStack> items) {
        return this.create(name, () -> CreativeModeTab.builder()
                .icon(() -> new ItemStack(icon))
                .title(Component.translatable(translationId))
                .displayItems((displayParameters, output) -> output.acceptAll(items))
                .build());
    }
}
