package io.bloomish.api.engine.registry.factory;

import io.bloomish.api.engine.context.InjectionPool;
import io.bloomish.api.engine.registry.TemporalRegister;
import net.minecraft.advancements.CriterionTrigger;

public class TriggerTypeFactory extends AbstractObjectFactory<CriterionTrigger<?>> {
    public TriggerTypeFactory() {
        this(InjectionPool.getFromInstance("$TriggerTypes"));
    }

    public TriggerTypeFactory(TemporalRegister<CriterionTrigger<?>> register) {
        super(register);
    }
}
