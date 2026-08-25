package io.bloomish.api.engine.registry.factory;

import com.mojang.serialization.MapCodec;
import io.bloomish.api.engine.context.DefaultObjectRegistry;
import io.bloomish.api.engine.registry.BloomishRegister;
import net.minecraft.util.valueproviders.FloatProvider;
import net.minecraft.util.valueproviders.FloatProviderType;
import net.neoforged.neoforge.registries.DeferredHolder;

public class FloatProviderTypeFactory extends AbstractObjectFactory<FloatProviderType<?>> {
    public FloatProviderTypeFactory() {
        this(DefaultObjectRegistry.getFromInstance("$FloatProviderTypes"));
    }

    public FloatProviderTypeFactory(BloomishRegister<FloatProviderType<?>> register) {
        super(register);
    }

    public <T extends FloatProvider> DeferredHolder<FloatProviderType<?>, FloatProviderType<T>> create(String name, MapCodec<T> mapCodec) {
        return this.create(name, () -> () -> mapCodec);
    }
}
