package io.bloomish.api.engine.registry.factory;

import io.bloomish.api.engine.context.DefaultObjectRegistry;
import io.bloomish.api.engine.registry.TemporalRegister;
import net.minecraft.world.level.levelgen.carver.WorldCarver;

public class CarverFactory extends AbstractObjectFactory<WorldCarver<?>> {
    public CarverFactory() {
        this(DefaultObjectRegistry.getFromInstance("$Carvers"));
    }

    public CarverFactory(TemporalRegister<WorldCarver<?>> register) {
        super(register);
    }
}
