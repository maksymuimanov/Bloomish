package io.bloomish.api.engine.registry.factory;

import com.mojang.serialization.MapCodec;
import io.bloomish.api.engine.context.DefaultObjectRegistry;
import io.bloomish.api.engine.registry.BloomishRegister;
import net.minecraft.world.level.biome.BiomeSource;

public class BiomeSourceFactory extends AbstractObjectFactory<MapCodec<? extends BiomeSource>> {
    public BiomeSourceFactory() {
        this(DefaultObjectRegistry.getFromInstance("$BiomeSources"));
    }

    public BiomeSourceFactory(BloomishRegister<MapCodec<? extends BiomeSource>> register) {
        super(register);
    }
}
