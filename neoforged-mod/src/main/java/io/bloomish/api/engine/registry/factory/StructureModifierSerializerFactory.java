package io.bloomish.api.engine.registry.factory;

import com.mojang.serialization.MapCodec;
import io.bloomish.api.engine.context.DefaultObjectRegistry;
import io.bloomish.api.engine.registry.BloomishRegister;
import net.neoforged.neoforge.common.world.StructureModifier;

public class StructureModifierSerializerFactory extends AbstractObjectFactory<MapCodec<? extends StructureModifier>> {
    public StructureModifierSerializerFactory() {
        this(DefaultObjectRegistry.getFromInstance("$StructureModifierSerializers"));
    }

    public StructureModifierSerializerFactory(BloomishRegister<MapCodec<? extends StructureModifier>> register) {
        super(register);
    }
}
