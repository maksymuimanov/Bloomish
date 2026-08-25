package io.bloomish.api.engine.registry.factory;

import com.mojang.serialization.MapCodec;
import io.bloomish.api.engine.context.DefaultObjectRegistry;
import io.bloomish.api.engine.registry.BloomishRegister;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.neoforged.neoforge.registries.DeferredHolder;

public class TrunkPlacerTypeFactory extends AbstractObjectFactory<TrunkPlacerType<?>> {
    public TrunkPlacerTypeFactory() {
        this(DefaultObjectRegistry.getFromInstance("$TrunkPlacerTypes"));
    }

    public TrunkPlacerTypeFactory(BloomishRegister<TrunkPlacerType<?>> register) {
        super(register);
    }

    public <T extends TrunkPlacer> DeferredHolder<TrunkPlacerType<?>, TrunkPlacerType<T>> create(String name, MapCodec<T> codec) {
        return this.create(name, () -> new TrunkPlacerType<>(codec));
    }
}