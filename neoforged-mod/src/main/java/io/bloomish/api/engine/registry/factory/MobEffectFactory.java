package io.bloomish.api.engine.registry.factory;

import io.bloomish.api.engine.context.DefaultObjectRegistry;
import io.bloomish.api.engine.registry.TemporalRegister;
import net.minecraft.world.effect.MobEffect;

public class MobEffectFactory extends AbstractObjectFactory<MobEffect> {
    public MobEffectFactory() {
        this(DefaultObjectRegistry.getFromInstance("$MobEffects"));
    }

    public MobEffectFactory(final TemporalRegister<MobEffect> register) {
        super(register);
    }
}
