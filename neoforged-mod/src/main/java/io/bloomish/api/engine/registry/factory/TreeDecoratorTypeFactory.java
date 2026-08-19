package io.bloomish.api.engine.registry.factory;

import com.mojang.serialization.MapCodec;
import io.bloomish.api.engine.context.InjectionPool;
import io.bloomish.api.engine.registry.TemporalRegister;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.neoforged.neoforge.registries.DeferredHolder;

public class TreeDecoratorTypeFactory extends AbstractObjectFactory<TreeDecoratorType<?>> {
    public TreeDecoratorTypeFactory() {
        this(InjectionPool.getFromInstance("$TreeDecoratorTypes"));
    }

    public TreeDecoratorTypeFactory(TemporalRegister<TreeDecoratorType<?>> register) {
        super(register);
    }

    public <T extends TreeDecorator> DeferredHolder<TreeDecoratorType<?>, TreeDecoratorType<T>> create(String name, MapCodec<T> codec) {
        return this.create(name, () -> new TreeDecoratorType<>(codec));
    }
}