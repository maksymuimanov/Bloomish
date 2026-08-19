package io.bloomish.api.engine.registry.factory;

import com.mojang.serialization.MapCodec;
import io.bloomish.api.engine.context.DefaultObjectRegistry;
import io.bloomish.api.engine.registry.TemporalRegister;
import net.minecraft.world.level.storage.loot.functions.LootItemFunction;
import net.minecraft.world.level.storage.loot.functions.LootItemFunctionType;
import net.neoforged.neoforge.registries.DeferredHolder;

public class LootFunctionTypeFactory extends AbstractObjectFactory<LootItemFunctionType<?>> {
    public LootFunctionTypeFactory() {
        this(DefaultObjectRegistry.getFromInstance("$LootFunctionTypes"));
    }

    public LootFunctionTypeFactory(TemporalRegister<LootItemFunctionType<?>> register) {
        super(register);
    }

    public <T extends LootItemFunction> DeferredHolder<LootItemFunctionType<?>, LootItemFunctionType<T>> create(String name, MapCodec<T> mapCodec) {
        return this.create(name, () -> new LootItemFunctionType<>(mapCodec));
    }
}
