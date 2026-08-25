package io.bloomish.api.engine.registry.factory;

import io.bloomish.api.engine.context.DefaultObjectRegistry;
import io.bloomish.api.engine.registry.BloomishRegister;
import net.minecraft.world.entity.npc.VillagerType;
import net.neoforged.neoforge.registries.DeferredHolder;

public class VillagerTypeFactory extends AbstractObjectFactory<VillagerType> {
    public VillagerTypeFactory() {
        this(DefaultObjectRegistry.getFromInstance("$VillagerTypes"));
    }

    public VillagerTypeFactory(BloomishRegister<VillagerType> register) {
        super(register);
    }

    public DeferredHolder<VillagerType, VillagerType> create(String name) {
        return super.create(name, () -> new VillagerType(name));
    }
}
