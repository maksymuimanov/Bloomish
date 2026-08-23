package io.bloomish.api.fml;

import io.bloomish.api.engine.metadata.annotation.injection.Injected;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.world.level.block.state.properties.WoodType;

@Injected
public class WoodTypeClientSetup implements FmlClientSetup<WoodType> {
    @Override
    public void setup(WoodType data) {
        Sheets.addWoodType(data);
    }
}
