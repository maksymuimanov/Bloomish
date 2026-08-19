package io.bloomish.api.engine.registry.factory;

import com.mojang.serialization.MapCodec;
import io.bloomish.api.engine.context.InjectionPool;
import io.bloomish.api.engine.registry.TemporalRegister;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.IntProviderType;
import net.neoforged.neoforge.registries.DeferredHolder;

public class IntProviderTypeFactory extends AbstractObjectFactory<IntProviderType<?>> {
    public IntProviderTypeFactory() {
        this(InjectionPool.getFromInstance("$IntProviderTypes"));
    }

    public IntProviderTypeFactory(TemporalRegister<IntProviderType<?>> register) {
        super(register);
    }

    public <T extends IntProvider> DeferredHolder<IntProviderType<?>, IntProviderType<T>> create(String name, MapCodec<T> mapCodec) {
        return this.create(name, () -> () -> mapCodec);
    }
}
