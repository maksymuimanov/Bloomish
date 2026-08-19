package io.bloomish.api.engine.registry.factory;

import com.mojang.serialization.MapCodec;
import io.bloomish.api.engine.context.DefaultObjectRegistry;
import io.bloomish.api.engine.registry.TemporalRegister;
import net.minecraft.util.KeyDispatchDataCodec;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.neoforged.neoforge.registries.DeferredHolder;

public class MaterialRuleFactory extends AbstractObjectFactory<MapCodec<? extends SurfaceRules.RuleSource>> {
    public MaterialRuleFactory() {
        this(DefaultObjectRegistry.getFromInstance("$MaterialRules"));
    }

    public MaterialRuleFactory(TemporalRegister<MapCodec<? extends SurfaceRules.RuleSource>> register) {
        super(register);
    }

    public <T extends SurfaceRules.RuleSource> DeferredHolder<MapCodec<? extends SurfaceRules.RuleSource>, MapCodec<? extends T>> create(String name, KeyDispatchDataCodec<? extends T> codec) {
        return this.create(name, codec::codec);
    }
}
