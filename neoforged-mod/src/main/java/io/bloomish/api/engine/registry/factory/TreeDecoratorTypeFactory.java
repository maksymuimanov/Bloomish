package io.bloomish.api.engine.registry.factory;

import com.mojang.serialization.MapCodec;
import io.bloomish.api.engine.context.DefaultObjectRegistry;
import io.bloomish.api.engine.registry.BloomishRegister;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.neoforged.neoforge.registries.DeferredHolder;

public class TreeDecoratorTypeFactory extends AbstractObjectFactory<TreeDecoratorType<?>> {
    public TreeDecoratorTypeFactory() {
        this(DefaultObjectRegistry.getFromInstance("$TreeDecoratorTypes"));
    }

    public TreeDecoratorTypeFactory(BloomishRegister<TreeDecoratorType<?>> register) {
        super(register);
    }

    public <T extends TreeDecorator> DeferredHolder<TreeDecoratorType<?>, TreeDecoratorType<T>> create(String name, MapCodec<T> codec) {
        return this.create(name, () -> new TreeDecoratorType<>(codec));
    }
}