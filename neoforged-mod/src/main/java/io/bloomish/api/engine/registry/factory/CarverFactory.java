package io.bloomish.api.engine.registry.factory;

import io.bloomish.api.context.DefaultObjectRegistry;
import io.bloomish.api.engine.registry.BloomishRegister;
import net.minecraft.world.level.levelgen.carver.WorldCarver;

public class CarverFactory extends AbstractObjectFactory<WorldCarver<?>> {
    public CarverFactory() {
        this(DefaultObjectRegistry.getFromInstance("$Carvers"));
    }

    public CarverFactory(BloomishRegister<WorldCarver<?>> register) {
        super(register);
    }
}
