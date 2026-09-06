package io.bloomish.api.event.listener;

import io.bloomish.api.bean.Bean;
import io.bloomish.api.channel.ObserveObjectChannel;
import io.bloomish.api.event.fml.BowClientSetup;
import io.bloomish.api.event.fml.FmlClientSetup;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

import java.util.stream.Stream;

@Bean
public class BowClientSetupEventListener {
    private final Stream<Holder<? extends Item>> bows;
    private final FmlClientSetup<Holder<? extends Item>> bowClientSetup;

    public BowClientSetupEventListener(
            @ObserveObjectChannel("BowClientSetupEventListener") Stream<Holder<? extends Item>> bows,
            BowClientSetup bowClientSetup
    ) {
        this.bows = bows;
        this.bowClientSetup = bowClientSetup;
    }

    @ListenEvent
    public void listen(FMLClientSetupEvent event) {
        event.enqueueWork(() -> this.bows.forEach(this.bowClientSetup::setup));
    }
}
