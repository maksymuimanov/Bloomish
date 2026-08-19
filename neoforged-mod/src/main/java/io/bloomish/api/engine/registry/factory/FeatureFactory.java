package io.bloomish.api.engine.registry.factory;

import io.bloomish.api.engine.context.DefaultObjectRegistry;
import io.bloomish.api.engine.registry.TemporalRegister;
import net.minecraft.world.level.levelgen.feature.Feature;

public class FeatureFactory extends AbstractObjectFactory<Feature<?>> {
    public FeatureFactory() {
        this(DefaultObjectRegistry.getFromInstance("$Features"));
    }

    public FeatureFactory(TemporalRegister<Feature<?>> register) {
        super(register);
    }
}
