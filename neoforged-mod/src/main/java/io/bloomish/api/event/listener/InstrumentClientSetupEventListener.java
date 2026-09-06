package io.bloomish.api.event.listener;

import io.bloomish.api.channel.ObserveObjectChannel;
import io.bloomish.api.event.fml.FmlClientSetup;
import io.bloomish.api.event.fml.InstrumentClientSetup;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

import java.util.stream.Stream;

@EventListener
public class InstrumentClientSetupEventListener {
    private final Stream<Holder<? extends Item>> instruments;
    private final FmlClientSetup<Holder<? extends Item>> instrumentClientSetup;

    public InstrumentClientSetupEventListener(
            @ObserveObjectChannel("InstrumentClientSetupEventListener") Stream<Holder<? extends Item>> instruments,
            InstrumentClientSetup instrumentClientSetup
    ) {
        this.instruments = instruments;
        this.instrumentClientSetup = instrumentClientSetup;
    }

    public void listen(FMLClientSetupEvent event) {
        event.enqueueWork(() -> this.instruments.forEach(this.instrumentClientSetup::setup));
    }
}
