package io.bloomish.api.engine.event.handler;

import io.bloomish.api.channel.DataChannels;
import io.bloomish.api.channel.ValueChannelBus;
import io.bloomish.api.engine.event.subscriber.NeoForgeEventBusSubscriber;
import io.bloomish.api.engine.metadata.annotation.injection.Handler;
import io.bloomish.api.engine.metadata.annotation.injection.Injected;
import io.bloomish.api.fov.FovModifier;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.event.ComputeFovModifierEvent;

@Injected
@Handler(ComputeFovModifierEvent.class)
public class FovModifierEventHandler extends AbstractEventHandler<ComputeFovModifierEvent> {
    private final ValueChannelBus channelBus;
    private final FovModifier fovModifier;

    public FovModifierEventHandler(NeoForgeEventBusSubscriber eventBusSubscriber, ValueChannelBus channelBus, FovModifier fovModifier) {
        super(eventBusSubscriber);
        this.channelBus = channelBus;
        this.fovModifier = fovModifier;
    }

    @Override
    protected void handle(ComputeFovModifierEvent event) {
        this.channelBus.<Holder<? extends Item>>forEachDrain(DataChannels.FOV_MODIFIER_EVENT_HANDLER,
                bow -> this.applyFovModifier(event, bow));
    }

    private void applyFovModifier(ComputeFovModifierEvent event, Holder<? extends Item> bow) {
        this.fovModifier.modify(event, bow.value());
    }
}
