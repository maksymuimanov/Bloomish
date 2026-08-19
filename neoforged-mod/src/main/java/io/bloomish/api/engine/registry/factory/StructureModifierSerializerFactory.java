package io.bloomish.api.engine.registry.factory;

import com.mojang.serialization.MapCodec;
import io.bloomish.api.engine.context.InjectionPool;
import io.bloomish.api.engine.registry.TemporalRegister;
import net.neoforged.neoforge.common.world.StructureModifier;

public class StructureModifierSerializerFactory extends AbstractObjectFactory<MapCodec<? extends StructureModifier>> {
    public StructureModifierSerializerFactory() {
        this(InjectionPool.getFromInstance("$StructureModifierSerializers"));
    }

    public StructureModifierSerializerFactory(TemporalRegister<MapCodec<? extends StructureModifier>> register) {
        super(register);
    }
}
