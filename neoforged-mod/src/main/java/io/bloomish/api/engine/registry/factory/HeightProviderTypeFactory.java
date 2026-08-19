package io.bloomish.api.engine.registry.factory;

import com.mojang.serialization.MapCodec;
import io.bloomish.api.engine.context.DefaultObjectRegistry;
import io.bloomish.api.engine.registry.TemporalRegister;
import net.minecraft.world.level.levelgen.heightproviders.HeightProvider;
import net.minecraft.world.level.levelgen.heightproviders.HeightProviderType;
import net.neoforged.neoforge.registries.DeferredHolder;

public class HeightProviderTypeFactory extends AbstractObjectFactory<HeightProviderType<?>> {
    public HeightProviderTypeFactory() {
        this(DefaultObjectRegistry.getFromInstance("$HeightProviderTypes"));
    }

    public HeightProviderTypeFactory(TemporalRegister<HeightProviderType<?>> register) {
        super(register);
    }

    public <T extends HeightProvider> DeferredHolder<HeightProviderType<?>, HeightProviderType<T>> create(String name, MapCodec<T> mapCodec) {
        return this.create(name, () -> () -> mapCodec);
    }
}
