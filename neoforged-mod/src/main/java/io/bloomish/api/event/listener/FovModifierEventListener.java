package io.bloomish.api.event.listener;

import io.bloomish.api.channel.deprecated.DataChannels;
import io.bloomish.api.channel.deprecated.ValueChannelBus;
import io.bloomish.api.event.fov.FovModifier;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.event.ComputeFovModifierEvent;

@EventListener
public class FovModifierEventListener {
    private final ValueChannelBus channelBus;
    private final FovModifier fovModifier;

    public FovModifierEventListener(ValueChannelBus channelBus, FovModifier fovModifier) {
        this.channelBus = channelBus;
        this.fovModifier = fovModifier;
    }

    public void listen(ComputeFovModifierEvent event) {
        this.channelBus.<Holder<? extends Item>>forEachDrain(DataChannels.FOV_MODIFIER_EVENT_HANDLER,
                bow -> this.applyFovModifier(event, bow));
    }

    private void applyFovModifier(ComputeFovModifierEvent event, Holder<? extends Item> bow) {
        this.fovModifier.modify(event, bow.value());
    }
}
