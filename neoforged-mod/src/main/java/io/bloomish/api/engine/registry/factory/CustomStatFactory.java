package io.bloomish.api.engine.registry.factory;

import io.bloomish.api.engine.context.DefaultObjectRegistry;
import io.bloomish.api.engine.registry.BloomishRegister;
import io.bloomish.api.util.DeprecatedResourceUtils;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.registries.DeferredHolder;

public class CustomStatFactory extends AbstractObjectFactory<ResourceLocation> {
    public CustomStatFactory() {
        this(DefaultObjectRegistry.getFromInstance("$CustomStats"));
    }

    public CustomStatFactory(BloomishRegister<ResourceLocation> register) {
        super(register);
    }

    public DeferredHolder<ResourceLocation, ResourceLocation> create(String name) {
        ResourceLocation resourcelocation = DeprecatedResourceUtils.parse(name);
        return this.create(name, () -> resourcelocation);
    }
}
