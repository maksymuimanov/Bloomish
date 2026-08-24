package io.bloomish.api.engine.event.handler;

import io.bloomish.api.channel.DataChannel;
import io.bloomish.api.channel.DataChannels;
import io.bloomish.api.channel.ValueChannelBus;
import io.bloomish.api.engine.event.subscriber.ModEventBusSubscriber;
import io.bloomish.api.engine.metadata.annotation.injection.Injected;
import io.bloomish.api.fml.*;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

@Injected
public class FMLClientSetupEventHandler extends AbstractEventHandler<FMLClientSetupEvent> {
    private final ValueChannelBus channelBus;
    private final FmlClientSetup<Holder<? extends Item>> bowClientSetup;
    private final FmlClientSetup<Holder<? extends Item>> crossbowClientSetup;
    private final FmlClientSetup<Holder<? extends Item>> shieldClientSetup;
    private final FmlClientSetup<Holder<? extends Item>> instrumentClientSetup;
    private final FmlClientSetup<WoodType> woodTypeClientSetup;

    public FMLClientSetupEventHandler(
            ModEventBusSubscriber eventBusSubscriber,
            ValueChannelBus channelBus,
            BowClientSetup bowClientSetup,
            CrossbowClientSetup crossbowClientSetup,
            ShieldClientSetup shieldClientSetup,
            InstrumentClientSetup instrumentClientSetup,
            WoodTypeClientSetup woodTypeClientSetup
    ) {
        super(eventBusSubscriber);
        this.channelBus = channelBus;
        this.bowClientSetup = bowClientSetup;
        this.crossbowClientSetup = crossbowClientSetup;
        this.shieldClientSetup = shieldClientSetup;
        this.instrumentClientSetup = instrumentClientSetup;
        this.woodTypeClientSetup = woodTypeClientSetup;
    }

    @Override
    protected void handle(FMLClientSetupEvent event) {
        this.applyClientSetup(DataChannels.FML_CLIENT_SETUP_EVENT_HANDLER_WOOD_TYPES, this.woodTypeClientSetup);
        event.enqueueWork(() -> {
            this.applyClientSetup(DataChannels.FML_CLIENT_SETUP_EVENT_HANDLER_BOWS, this.bowClientSetup);
            this.applyClientSetup(DataChannels.FML_CLIENT_SETUP_EVENT_HANDLER_CROSSBOWS, this.crossbowClientSetup);
            this.applyClientSetup(DataChannels.FML_CLIENT_SETUP_EVENT_HANDLER_SHIELDS, this.shieldClientSetup);
            this.applyClientSetup(DataChannels.FML_CLIENT_SETUP_EVENT_HANDLER_INSTRUMENTS, this.instrumentClientSetup);
        });
    }

    private <T> void applyClientSetup(DataChannel channel, FmlClientSetup<T> clientSetup) {
        this.channelBus.forEachDrain(channel, clientSetup::setup);
    }
}
