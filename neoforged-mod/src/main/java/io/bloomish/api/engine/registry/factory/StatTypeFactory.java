package io.bloomish.api.engine.registry.factory;

import io.bloomish.api.engine.context.DefaultObjectRegistry;
import io.bloomish.api.engine.context.EngineContext;
import io.bloomish.api.engine.registry.TemporalRegister;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.StatType;
import net.neoforged.neoforge.registries.DeferredHolder;

public class StatTypeFactory extends AbstractObjectFactory<StatType<?>> {
    public StatTypeFactory() {
        this(DefaultObjectRegistry.getFromInstance("$StatTypes"));
    }

    public StatTypeFactory(TemporalRegister<StatType<?>> register) {
        super(register);
    }

    public <T> DeferredHolder<StatType<?>, StatType<T>> create(String name, Registry<T> registry) {
        Component component = Component.translatable("stat_type." + EngineContext.currentMod.getModId() + "." + name);
        return this.create(name, () -> new StatType<>(registry, component));
    }
}
