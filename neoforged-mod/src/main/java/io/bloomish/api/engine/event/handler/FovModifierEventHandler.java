package io.bloomish.api.engine.event.handler;

import io.bloomish.api.engine.metadata.annotation.injection.Handler;
import io.bloomish.api.fov.BowFOVModifier;
import io.bloomish.api.fov.FOVModifier;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.event.ComputeFovModifierEvent;

import java.util.ArrayList;
import java.util.List;

@Handler(ComputeFovModifierEvent.class)
public class FovModifierEventHandler implements EventHandler {
    public static final List<Holder<? extends Item>> BOWS = new ArrayList<>();
    private static final FOVModifier FOV_MODIFIER = new BowFOVModifier();

    @Override
    public void handle() {
        this.subscribeEvent(ComputeFovModifierEvent.class, event -> {
            BOWS.forEach(bow -> FOV_MODIFIER.modify(event, bow.value()));
        });
    }
}
