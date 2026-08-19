package io.bloomish.api.engine.registry.factory;

import com.mojang.serialization.MapCodec;
import io.bloomish.api.engine.context.InjectionPool;
import io.bloomish.api.engine.registry.TemporalRegister;
import net.minecraft.world.level.biome.BiomeSource;

public class BiomeSourceFactory extends AbstractObjectFactory<MapCodec<? extends BiomeSource>> {
    public BiomeSourceFactory() {
        this(InjectionPool.getFromInstance("$BiomeSources"));
    }

    public BiomeSourceFactory(TemporalRegister<MapCodec<? extends BiomeSource>> register) {
        super(register);
    }
}
