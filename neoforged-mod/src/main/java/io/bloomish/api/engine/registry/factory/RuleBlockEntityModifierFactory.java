package io.bloomish.api.engine.registry.factory;

import com.mojang.serialization.MapCodec;
import io.bloomish.api.engine.context.DefaultObjectRegistry;
import io.bloomish.api.engine.registry.BloomishRegister;
import net.minecraft.world.level.levelgen.structure.templatesystem.rule.blockentity.RuleBlockEntityModifier;
import net.minecraft.world.level.levelgen.structure.templatesystem.rule.blockentity.RuleBlockEntityModifierType;
import net.neoforged.neoforge.registries.DeferredHolder;

public class RuleBlockEntityModifierFactory extends AbstractObjectFactory<RuleBlockEntityModifierType<?>> {
    public RuleBlockEntityModifierFactory() {
        this(DefaultObjectRegistry.getFromInstance("$RuleBlockEntityModifiers"));
    }

    public RuleBlockEntityModifierFactory(BloomishRegister<RuleBlockEntityModifierType<?>> register) {
        super(register);
    }

    public <T extends RuleBlockEntityModifier> DeferredHolder<RuleBlockEntityModifierType<?>, RuleBlockEntityModifierType<T>> create(String name, MapCodec<T> mapCodec) {
        return this.create(name, () -> () -> mapCodec);
    }
}
