package io.bloomish.api.event.listener;

import io.bloomish.api.channel.ObjectChannel;
import io.bloomish.api.channel.deprecated.DataChannels;
import io.bloomish.api.channel.deprecated.ValueChannelBus;
import io.bloomish.api.event.fml.*;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

@EventListener
public class FMLClientSetupEventListener {
    private final ValueChannelBus channelBus;
    private final FmlClientSetup<Holder<? extends Item>> bowClientSetup;
    private final FmlClientSetup<Holder<? extends Item>> crossbowClientSetup;
    private final FmlClientSetup<Holder<? extends Item>> shieldClientSetup;
    private final FmlClientSetup<Holder<? extends Item>> instrumentClientSetup;
    private final FmlClientSetup<WoodType> woodTypeClientSetup;

    public FMLClientSetupEventListener(ValueChannelBus channelBus, BowClientSetup bowClientSetup, CrossbowClientSetup crossbowClientSetup, ShieldClientSetup shieldClientSetup, InstrumentClientSetup instrumentClientSetup, WoodTypeClientSetup woodTypeClientSetup) {
        this.channelBus = channelBus;
        this.bowClientSetup = bowClientSetup;
        this.crossbowClientSetup = crossbowClientSetup;
        this.shieldClientSetup = shieldClientSetup;
        this.instrumentClientSetup = instrumentClientSetup;
        this.woodTypeClientSetup = woodTypeClientSetup;
    }

    public void listen(FMLClientSetupEvent event) {
        this.applyClientSetup(DataChannels.FML_CLIENT_SETUP_EVENT_HANDLER_WOOD_TYPES, this.woodTypeClientSetup);
        event.enqueueWork(() -> {
            this.applyClientSetup(DataChannels.FML_CLIENT_SETUP_EVENT_HANDLER_BOWS, this.bowClientSetup);
            this.applyClientSetup(DataChannels.FML_CLIENT_SETUP_EVENT_HANDLER_CROSSBOWS, this.crossbowClientSetup);
            this.applyClientSetup(DataChannels.FML_CLIENT_SETUP_EVENT_HANDLER_SHIELDS, this.shieldClientSetup);
            this.applyClientSetup(DataChannels.FML_CLIENT_SETUP_EVENT_HANDLER_INSTRUMENTS, this.instrumentClientSetup);
        });
    }

    private <T> void applyClientSetup(ObjectChannel channel, FmlClientSetup<T> clientSetup) {
        this.channelBus.forEachDrain(channel, clientSetup::setup);
    }
}
