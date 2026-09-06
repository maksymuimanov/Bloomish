package io.bloomish.api.event.listener;

import io.bloomish.api.bean.Bean;
import io.bloomish.api.channel.ObserveObjectChannel;
import io.bloomish.api.event.fov.FovModifier;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.event.ComputeFovModifierEvent;

import java.util.stream.Stream;

@Bean
public class BowFovModifierEventListener {
    private final Stream<Holder<? extends Item>> bows;
    private final FovModifier fovModifier;

    public BowFovModifierEventListener(
            @ObserveObjectChannel("BowFovModifierEventListener") Stream<Holder<? extends Item>> bows,
            FovModifier fovModifier
    ) {
        this.bows = bows;
        this.fovModifier = fovModifier;
    }

    @ListenEvent
    public void listen(ComputeFovModifierEvent event) {
        this.bows.forEach(bow -> this.fovModifier.modify(event, bow.value()));
    }
}
