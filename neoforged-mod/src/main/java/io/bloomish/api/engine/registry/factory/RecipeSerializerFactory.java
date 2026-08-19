package io.bloomish.api.engine.registry.factory;

import io.bloomish.api.engine.context.InjectionPool;
import io.bloomish.api.engine.registry.TemporalRegister;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.neoforged.neoforge.registries.DeferredHolder;

public class RecipeSerializerFactory extends AbstractObjectFactory<RecipeSerializer<?>> {
    public RecipeSerializerFactory() {
        this(InjectionPool.getFromInstance("$RecipeSerializers"));
    }

    public RecipeSerializerFactory(TemporalRegister<RecipeSerializer<?>> register) {
        super(register);
    }

    public <T extends Recipe<?>> DeferredHolder<RecipeSerializer<?>, RecipeSerializer<T>> create(String name, RecipeSerializer<T> recipeSerializer) {
        return this.create(name, () -> recipeSerializer);
    }
}