package io.bloomish.api.engine.registry.factory;

import io.bloomish.api.engine.context.InjectionPool;
import io.bloomish.api.engine.registry.TemporalRegister;
import net.minecraft.world.entity.npc.VillagerType;
import net.neoforged.neoforge.registries.DeferredHolder;

public class VillagerTypeFactory extends AbstractObjectFactory<VillagerType> {
    public VillagerTypeFactory() {
        this(InjectionPool.getFromInstance("$VillagerTypes"));
    }

    public VillagerTypeFactory(TemporalRegister<VillagerType> register) {
        super(register);
    }

    public DeferredHolder<VillagerType, VillagerType> create(String name) {
        return super.create(name, () -> new VillagerType(name));
    }
}
