package io.bloomish.api.engine.registry.factory;

import com.mojang.serialization.Codec;
import io.bloomish.api.engine.context.DefaultObjectRegistry;
import io.bloomish.api.engine.registry.BloomishRegister;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.neoforged.neoforge.registries.DeferredHolder;

public class DataComponentTypeFactory extends AbstractObjectFactory<DataComponentType<?>> {
    public DataComponentTypeFactory() {
        this(DefaultObjectRegistry.getFromInstance("$DataComponentTypes"));
    }

    public DataComponentTypeFactory(BloomishRegister<DataComponentType<?>> register) {
        super(register);
    }

    public <T> DeferredHolder<DataComponentType<?>, DataComponentType<T>> create(String name, Codec<T> codec, StreamCodec<? super RegistryFriendlyByteBuf, T> streamCodec) {
        return this.create(name, () -> DataComponentType.<T>builder()
                .persistent(codec)
                .networkSynchronized(streamCodec)
                .build());
    }
}