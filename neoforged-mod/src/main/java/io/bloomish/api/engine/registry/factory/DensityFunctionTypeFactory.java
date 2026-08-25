package io.bloomish.api.engine.registry.factory;

import com.mojang.serialization.MapCodec;
import io.bloomish.api.engine.context.DefaultObjectRegistry;
import io.bloomish.api.engine.registry.BloomishRegister;
import net.minecraft.world.level.levelgen.DensityFunction;

public class DensityFunctionTypeFactory extends AbstractObjectFactory<MapCodec<? extends DensityFunction>> {
    public DensityFunctionTypeFactory() {
        this(DefaultObjectRegistry.getFromInstance("$DensityFunctionTypes"));
    }

    public DensityFunctionTypeFactory(BloomishRegister<MapCodec<? extends DensityFunction>> register) {
        super(register);
    }
}
