package io.bloomish.api.engine.registry.factory;

import com.mojang.serialization.MapCodec;
import io.bloomish.api.engine.context.DefaultObjectRegistry;
import io.bloomish.api.engine.registry.BloomishRegister;
import net.neoforged.neoforge.common.conditions.ICondition;

public class ConditionCodecFactory extends AbstractObjectFactory<MapCodec<? extends ICondition>> {
    public ConditionCodecFactory() {
        this(DefaultObjectRegistry.getFromInstance("$ConditionCodecs"));
    }

    public ConditionCodecFactory(BloomishRegister<MapCodec<? extends ICondition>> register) {
        super(register);
    }
}
