package io.bloomish.api.engine.registry.factory;

import com.mojang.serialization.MapCodec;
import io.bloomish.api.engine.context.DefaultObjectRegistry;
import io.bloomish.api.engine.registry.TemporalRegister;
import net.minecraft.world.level.block.Block;

public class BlockTypeFactory extends AbstractObjectFactory<MapCodec<? extends Block>> {
    public BlockTypeFactory() {
        this(DefaultObjectRegistry.getFromInstance("$BlockTypes"));
    }

    public BlockTypeFactory(TemporalRegister<MapCodec<? extends Block>> register) {
        super(register);
    }
}
