package io.bloomish.api.engine.registry.factory;

import io.bloomish.api.engine.context.DefaultObjectRegistry;
import io.bloomish.api.engine.registry.BloomishRegister;
import io.bloomish.api.util.DeprecatedResourceUtils;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.neoforge.registries.DeferredHolder;

public class RecipeTypeFactory extends AbstractObjectFactory<RecipeType<?>> {
    public RecipeTypeFactory() {
        this(DefaultObjectRegistry.getFromInstance("$RecipeTypes"));
    }

    public RecipeTypeFactory(BloomishRegister<RecipeType<?>> register) {
        super(register);
    }

    public <T extends Recipe<?>> DeferredHolder<RecipeType<?>, RecipeType<T>> create(String name) {
        return this.create(name, () -> RecipeType.simple(DeprecatedResourceUtils.createLocation(name)));
    }
}