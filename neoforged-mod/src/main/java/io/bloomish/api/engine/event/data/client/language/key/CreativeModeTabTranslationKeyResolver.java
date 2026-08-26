package io.bloomish.api.engine.event.data.client.language.key;

import io.bloomish.api.engine.metadata.annotation.injection.Injected;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;

@Injected
public class CreativeModeTabTranslationKeyResolver extends AbstractResourceKeyResolver<CreativeModeTab> {
    public static final String PREFIX = "creativetab";

    @Override
    protected ResourceKey<? extends Registry<CreativeModeTab>> getRegistryKey() {
        return Registries.CREATIVE_MODE_TAB;
    }

    @Override
    public String resolve(ResourceKey<CreativeModeTab> creativeModeTabResourceKey) {
        return this.resolveTranslationKey(PREFIX, creativeModeTabResourceKey);
    }
}
