package io.bloomish.api.engine.registry.factory;

import com.mojang.serialization.MapCodec;
import io.bloomish.api.engine.context.DefaultObjectRegistry;
import io.bloomish.api.engine.registry.BloomishRegister;
import net.neoforged.neoforge.common.world.BiomeModifier;

public class BiomeModifierSerializerFactory extends AbstractObjectFactory<MapCodec<? extends BiomeModifier>> {
    public BiomeModifierSerializerFactory() {
        this(DefaultObjectRegistry.getFromInstance("$BiomeModifierSerializers"));
    }

    public BiomeModifierSerializerFactory(BloomishRegister<MapCodec<? extends BiomeModifier>> register) {
        super(register);
    }
}
