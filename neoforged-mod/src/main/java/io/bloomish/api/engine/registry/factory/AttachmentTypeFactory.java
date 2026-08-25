package io.bloomish.api.engine.registry.factory;

import com.mojang.serialization.Codec;
import io.bloomish.api.engine.context.DefaultObjectRegistry;
import io.bloomish.api.engine.registry.BloomishRegister;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.function.Supplier;

public class AttachmentTypeFactory extends AbstractObjectFactory<AttachmentType<?>> {
    public AttachmentTypeFactory() {
        this(DefaultObjectRegistry.getFromInstance("$AttachmentTypes"));
    }

    public AttachmentTypeFactory(BloomishRegister<AttachmentType<?>> register) {
        super(register);
    }

    public <T> DeferredHolder<AttachmentType<?>, AttachmentType<T>> create(String name, Supplier<T> defaultValueSupplier, Codec<T> codec) {
        return this.create(name, () -> AttachmentType.builder(defaultValueSupplier)
                .serialize(codec)
                .build());
    }
}
