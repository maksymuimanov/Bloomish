package io.bloomish.api.engine.registry.factory;

import io.bloomish.api.engine.context.InjectionPool;
import io.bloomish.api.engine.registry.TemporalRegister;
import io.bloomish.api.util.ResourceUtils;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.registries.DeferredHolder;

public class CustomStatFactory extends AbstractObjectFactory<ResourceLocation> {
    public CustomStatFactory() {
        this(InjectionPool.getFromInstance("$CustomStats"));
    }

    public CustomStatFactory(TemporalRegister<ResourceLocation> register) {
        super(register);
    }

    public DeferredHolder<ResourceLocation, ResourceLocation> create(String name) {
        ResourceLocation resourcelocation = ResourceUtils.parse(name);
        return this.create(name, () -> resourcelocation);
    }
}
