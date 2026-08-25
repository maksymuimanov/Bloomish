package io.bloomish.api.engine.registry.factory;

import io.bloomish.api.engine.context.DefaultObjectRegistry;
import io.bloomish.api.engine.registry.BloomishRegister;
import io.bloomish.api.util.DeprecatedResourceUtils;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredHolder;

public class SoundEventFactory extends AbstractObjectFactory<SoundEvent> {
    public SoundEventFactory() {
        this(DefaultObjectRegistry.getFromInstance("$SoundEvents"));
    }

    public SoundEventFactory(BloomishRegister<SoundEvent> register) {
        super(register);
    }

    public DeferredHolder<SoundEvent, SoundEvent> create(String name) {
        return this.create(name, () -> SoundEvent.createVariableRangeEvent(DeprecatedResourceUtils.parse(name)));
    }

    public DeferredHolder<SoundEvent, SoundEvent> create(String name, float fixedRate) {
        return this.create(name, () -> SoundEvent.createFixedRangeEvent(DeprecatedResourceUtils.parse(name), fixedRate));
    }
}
