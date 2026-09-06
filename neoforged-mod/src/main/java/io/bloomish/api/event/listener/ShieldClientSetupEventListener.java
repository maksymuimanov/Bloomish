package io.bloomish.api.event.listener;

import io.bloomish.api.channel.ObserveObjectChannel;
import io.bloomish.api.event.fml.FmlClientSetup;
import io.bloomish.api.event.fml.ShieldClientSetup;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

import java.util.stream.Stream;

@EventListener
public class ShieldClientSetupEventListener {
    private final Stream<Holder<? extends Item>> shields;
    private final FmlClientSetup<Holder<? extends Item>> shieldClientSetup;

    public ShieldClientSetupEventListener(
            @ObserveObjectChannel("ShieldClientSetupEventListener") Stream<Holder<? extends Item>> shields,
            ShieldClientSetup shieldClientSetup
    ) {
        this.shields = shields;
        this.shieldClientSetup = shieldClientSetup;
    }

    public void listen(FMLClientSetupEvent event) {
        event.enqueueWork(() -> this.shields.forEach(this.shieldClientSetup::setup));
    }
}
