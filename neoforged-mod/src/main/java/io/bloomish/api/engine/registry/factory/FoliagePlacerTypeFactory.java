package io.bloomish.api.engine.registry.factory;

import com.mojang.serialization.MapCodec;
import io.bloomish.api.engine.context.DefaultObjectRegistry;
import io.bloomish.api.engine.registry.BloomishRegister;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.neoforged.neoforge.registries.DeferredHolder;

public class FoliagePlacerTypeFactory extends AbstractObjectFactory<FoliagePlacerType<?>> {
    public FoliagePlacerTypeFactory() {
        this(DefaultObjectRegistry.getFromInstance("$FoliagePlacerTypes"));
    }

    public FoliagePlacerTypeFactory(BloomishRegister<FoliagePlacerType<?>> register) {
        super(register);
    }

    public <T extends FoliagePlacer> DeferredHolder<FoliagePlacerType<?>, FoliagePlacerType<T>> create(String name, MapCodec<T> codec) {
        return this.create(name, () -> new FoliagePlacerType<>(codec));
    }
}