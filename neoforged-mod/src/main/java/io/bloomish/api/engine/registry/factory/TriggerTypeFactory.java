package io.bloomish.api.engine.registry.factory;

import io.bloomish.api.engine.context.DefaultObjectRegistry;
import io.bloomish.api.engine.registry.TemporalRegister;
import net.minecraft.advancements.CriterionTrigger;

public class TriggerTypeFactory extends AbstractObjectFactory<CriterionTrigger<?>> {
    public TriggerTypeFactory() {
        this(DefaultObjectRegistry.getFromInstance("$TriggerTypes"));
    }

    public TriggerTypeFactory(TemporalRegister<CriterionTrigger<?>> register) {
        super(register);
    }
}
