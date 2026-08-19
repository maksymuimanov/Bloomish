package io.bloomish.example.block;

import io.bloomish.api.core.engine.metadata.annotation.event.fml.SetupWoodType;
import io.bloomish.api.core.engine.registry.factory.WoodTypeFactory;
import net.minecraft.world.level.block.state.properties.WoodType;

public final class ExampleWoodTypes {
    @SetupWoodType
    public static final WoodType EXAMPLE_WOOD_TYPE = WoodTypeFactory.create("example", ExampleBlockSetTypes.EXAMPLE_BLOCK_SET_TYPE);
}
