package io.bloomish.example.instrument;

import io.bloomish.api.engine.context.InjectionPool;
import io.bloomish.api.engine.metadata.annotation.data.tag.AddInstrumentTag;
import io.bloomish.api.engine.registry.factory.InstrumentFactory;
import net.minecraft.world.item.Instrument;
import net.neoforged.neoforge.registries.DeferredHolder;
import io.bloomish.example.sound.ExampleSounds;

public final class ExampleInstruments {
    private static final InstrumentFactory INSTRUMENT_FACTORY = InjectionPool.getFromInstance(InstrumentFactory.class);

    @AddInstrumentTag("example:example")
    public static final DeferredHolder<Instrument, Instrument> EXAMPLE = INSTRUMENT_FACTORY.create("example", ExampleSounds.EXAMPLE_SOUND, 10, 15f);
}
