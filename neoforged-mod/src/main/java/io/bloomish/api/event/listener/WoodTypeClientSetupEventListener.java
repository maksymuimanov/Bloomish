package io.bloomish.api.event.listener;

import io.bloomish.api.channel.ObserveObjectChannel;
import io.bloomish.api.event.fml.FmlClientSetup;
import io.bloomish.api.event.fml.WoodTypeClientSetup;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

import java.util.stream.Stream;

@EventListener
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

    public void listen(FMLClientSetupEvent event) {
        this.woodTypes.forEach(this.woodTypeClientSetup::setup);
    }
}
