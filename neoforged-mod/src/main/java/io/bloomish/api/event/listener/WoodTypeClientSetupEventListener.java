package io.bloomish.api.event.listener;

import io.bloomish.api.bean.Bean;
import io.bloomish.api.channel.ObserveObjectChannel;
import io.bloomish.api.event.fml.FmlClientSetup;
import io.bloomish.api.event.fml.WoodTypeClientSetup;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

import java.util.stream.Stream;

@Bean
public class WoodTypeClientSetupEventListener {
    private final Stream<WoodType> woodTypes;
    private final FmlClientSetup<WoodType> woodTypeClientSetup;

    public WoodTypeClientSetupEventListener(
            @ObserveObjectChannel("WoodTypeClientSetupEventListener") Stream<WoodType> woodTypes,
            WoodTypeClientSetup woodTypeClientSetup
    ) {
        this.woodTypes = woodTypes;
        this.woodTypeClientSetup = woodTypeClientSetup;
    }

    @ListenEvent
    public void listen(FMLClientSetupEvent event) {
        this.woodTypes.forEach(this.woodTypeClientSetup::setup);
    }
}
