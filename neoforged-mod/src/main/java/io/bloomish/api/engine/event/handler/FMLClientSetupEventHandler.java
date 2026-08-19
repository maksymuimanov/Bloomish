package io.bloomish.api.engine.event.handler;

import io.bloomish.api.engine.event.client.*;
import io.bloomish.api.engine.metadata.annotation.injection.Handler;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

import java.util.ArrayList;
import java.util.List;

@Handler(FMLClientSetupEvent.class)
public class FMLClientSetupEventHandler implements EventHandler {
    public static final List<Holder<? extends Item>> BOWS = new ArrayList<>();
    public static final List<Holder<? extends Item>> CROSSBOWS = new ArrayList<>();
    public static final List<Holder<? extends Item>> SHIELDS = new ArrayList<>();
    public static final List<Holder<? extends Item>> INSTRUMENTS = new ArrayList<>();
    public static final List<WoodType> WOOD_TYPES = new ArrayList<>();
    private static final ClientSetup<Holder<? extends Item>> BOW_STRATEGY = new BowClientSetup();
    private static final ClientSetup<Holder<? extends Item>> CROSSBOW_STRATEGY = new CrossbowClientSetup();
    private static final ClientSetup<Holder<? extends Item>> SHIELD_STRATEGY = new ShieldClientSetup();
    private static final ClientSetup<Holder<? extends Item>> INSTRUMENT_STRATEGY = new InstrumentClientSetup();
    private static final ClientSetup<WoodType> WOOD_TYPE_STRATEGY = new WoodTypeClientSetup();

    @Override
    public void handle() {
        this.subscribeModEvent(FMLClientSetupEvent.class, event -> {
            WOOD_TYPE_STRATEGY.setup(WOOD_TYPES);
            event.enqueueWork(() -> {
                BOW_STRATEGY.setup(BOWS);
                CROSSBOW_STRATEGY.setup(CROSSBOWS);
                SHIELD_STRATEGY.setup(SHIELDS);
                INSTRUMENT_STRATEGY.setup(INSTRUMENTS);
            });
        });
    }
}
