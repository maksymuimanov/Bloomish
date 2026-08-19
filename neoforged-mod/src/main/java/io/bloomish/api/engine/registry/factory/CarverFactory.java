package io.bloomish.api.engine.registry.factory;

import io.bloomish.api.engine.context.InjectionPool;
import io.bloomish.api.engine.registry.TemporalRegister;
import net.minecraft.world.level.levelgen.carver.WorldCarver;

public class CarverFactory extends AbstractObjectFactory<WorldCarver<?>> {
    public CarverFactory() {
        this(InjectionPool.getFromInstance("$Carvers"));
    }

    public CarverFactory(TemporalRegister<WorldCarver<?>> register) {
        super(register);
    }
}
