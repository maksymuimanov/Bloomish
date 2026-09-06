package io.bloomish.api.event.listener;

import io.bloomish.api.channel.ObserveObjectChannel;
import io.bloomish.api.event.fml.CrossbowClientSetup;
import io.bloomish.api.event.fml.FmlClientSetup;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

import java.util.stream.Stream;

@EventListener
public class CrossbowClientSetupEventListener {
    private final Stream<Holder<? extends Item>> crossbows;
    private final FmlClientSetup<Holder<? extends Item>> crossbowClientSetup;

    public CrossbowClientSetupEventListener(
            @ObserveObjectChannel("CrossbowClientSetupEventListener") Stream<Holder<? extends Item>> crossbows,
            CrossbowClientSetup crossbowClientSetup
    ) {
        this.crossbows = crossbows;
        this.crossbowClientSetup = crossbowClientSetup;
    }

    public void listen(FMLClientSetupEvent event) {
        event.enqueueWork(() -> this.crossbows.forEach(this.crossbowClientSetup::setup));
    }
}
