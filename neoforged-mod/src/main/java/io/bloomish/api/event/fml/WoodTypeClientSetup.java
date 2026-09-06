package io.bloomish.api.event.fml;

import io.bloomish.api.bean.Bean;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.world.level.block.state.properties.WoodType;

@Bean
public class WoodTypeClientSetup implements FmlClientSetup<WoodType> {
    @Override
    public void setup(WoodType data) {
        Sheets.addWoodType(data);
    }
}
