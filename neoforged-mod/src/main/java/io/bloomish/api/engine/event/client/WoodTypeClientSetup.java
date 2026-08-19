package io.bloomish.api.engine.event.client;

import net.minecraft.client.renderer.Sheets;
import net.minecraft.world.level.block.state.properties.WoodType;

import java.util.List;

public class WoodTypeClientSetup implements ClientSetup<WoodType> {
    @Override
    public void setup(List<WoodType> source) {
        source.forEach(Sheets::addWoodType);
    }
}
