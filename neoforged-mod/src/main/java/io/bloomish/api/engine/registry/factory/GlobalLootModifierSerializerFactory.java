package io.bloomish.api.engine.registry.factory;

import com.mojang.serialization.MapCodec;
import io.bloomish.api.engine.context.DefaultObjectRegistry;
import io.bloomish.api.engine.registry.BloomishRegister;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;

public class GlobalLootModifierSerializerFactory extends AbstractObjectFactory<MapCodec<? extends IGlobalLootModifier>> {
    public GlobalLootModifierSerializerFactory() {
        this(DefaultObjectRegistry.getFromInstance("$GlobalLootModifierSerializers"));
    }

    public GlobalLootModifierSerializerFactory(BloomishRegister<MapCodec<? extends IGlobalLootModifier>> register) {
        super(register);
    }
}
