package io.bloomish.api.engine.registry.factory;

import com.mojang.serialization.MapCodec;
import io.bloomish.api.engine.context.InjectionPool;
import io.bloomish.api.engine.registry.TemporalRegister;
import net.minecraft.advancements.critereon.EntitySubPredicate;

public class EntitySubPredicateTypeFactory extends AbstractObjectFactory<MapCodec<? extends EntitySubPredicate>> {
    public EntitySubPredicateTypeFactory() {
        this(InjectionPool.getFromInstance("$EntitySubPredicateTypes"));
    }

    public EntitySubPredicateTypeFactory(TemporalRegister<MapCodec<? extends EntitySubPredicate>> register) {
        super(register);
    }
}
