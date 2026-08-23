package io.bloomish.api.fml;

import net.minecraft.client.renderer.Sheets;
import net.minecraft.world.level.block.state.properties.WoodType;

public class WoodTypeClientSetup implements FmlClientSetup<WoodType> {
    @Override
    public void setup(WoodType data) {
        Sheets.addWoodType(data);
    }
}
