package io.bloomish.api.engine.registry.factory;

import com.mojang.serialization.MapCodec;
import io.bloomish.api.engine.context.DefaultObjectRegistry;
import io.bloomish.api.engine.registry.BloomishRegister;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import net.neoforged.neoforge.registries.DeferredHolder;

public class StructureProcessorFactory extends AbstractObjectFactory<StructureProcessorType<?>> {
    public StructureProcessorFactory() {
        this(DefaultObjectRegistry.getFromInstance("$StructureProcessors"));
    }

    public StructureProcessorFactory(BloomishRegister<StructureProcessorType<?>> register) {
        super(register);
    }

    public <T extends StructureProcessor> DeferredHolder<StructureProcessorType<?>, StructureProcessorType<T>> create(String name, MapCodec<T> mapCodec) {
        return this.create(name, () -> () -> mapCodec);
    }
}
