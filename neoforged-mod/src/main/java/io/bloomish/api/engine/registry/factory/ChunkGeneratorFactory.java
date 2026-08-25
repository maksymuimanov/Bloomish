package io.bloomish.api.engine.registry.factory;

import com.mojang.serialization.MapCodec;
import io.bloomish.api.engine.context.DefaultObjectRegistry;
import io.bloomish.api.engine.registry.BloomishRegister;
import net.minecraft.world.level.chunk.ChunkGenerator;

public class ChunkGeneratorFactory extends AbstractObjectFactory<MapCodec<? extends ChunkGenerator>> {
    public ChunkGeneratorFactory() {
        this(DefaultObjectRegistry.getFromInstance("$ChunkGenerators"));
    }

    public ChunkGeneratorFactory(BloomishRegister<MapCodec<? extends ChunkGenerator>> register) {
        super(register);
    }
}
