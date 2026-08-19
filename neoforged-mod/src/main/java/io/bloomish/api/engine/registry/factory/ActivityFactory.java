package io.bloomish.api.engine.registry.factory;

import io.bloomish.api.engine.context.DefaultObjectRegistry;
import io.bloomish.api.engine.registry.TemporalRegister;
import net.minecraft.world.entity.schedule.Activity;
import net.neoforged.neoforge.registries.DeferredHolder;

public class ActivityFactory extends AbstractObjectFactory<Activity> {
    public ActivityFactory() {
        this(DefaultObjectRegistry.getFromInstance("$Activities"));
    }

    public ActivityFactory(TemporalRegister<Activity> register) {
        super(register);
    }

    public DeferredHolder<Activity, Activity> create(String name) {
        return this.create(name, () -> new Activity(name));
    }
}
