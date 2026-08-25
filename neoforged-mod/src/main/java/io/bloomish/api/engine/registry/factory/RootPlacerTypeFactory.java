package io.bloomish.api.engine.registry.factory;

import com.mojang.serialization.MapCodec;
import io.bloomish.api.engine.context.DefaultObjectRegistry;
import io.bloomish.api.engine.registry.BloomishRegister;
import net.minecraft.world.level.levelgen.feature.rootplacers.RootPlacer;
import net.minecraft.world.level.levelgen.feature.rootplacers.RootPlacerType;
import net.neoforged.neoforge.registries.DeferredHolder;

public class RootPlacerTypeFactory extends AbstractObjectFactory<RootPlacerType<?>> {
    public RootPlacerTypeFactory() {
        this(DefaultObjectRegistry.getFromInstance("$RootPlacerTypes"));
    }

    public RootPlacerTypeFactory(BloomishRegister<RootPlacerType<?>> register) {
        super(register);
    }

    public <T extends RootPlacer> DeferredHolder<RootPlacerType<?>, RootPlacerType<T>> create(String name, MapCodec<T> mapCodec) {
        return this.create(name, () -> new RootPlacerType<>(mapCodec));
    }
}
