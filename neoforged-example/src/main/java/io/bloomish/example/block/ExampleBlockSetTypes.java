package io.bloomish.example.block;

import io.bloomish.api.core.engine.registry.factory.BlockSetTypeFactory;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public final class ExampleBlockSetTypes {
    public static final BlockSetType EXAMPLE_BLOCK_SET_TYPE = BlockSetTypeFactory.createWood("example");
}
