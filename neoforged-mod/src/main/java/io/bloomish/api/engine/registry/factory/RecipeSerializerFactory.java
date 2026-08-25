package io.bloomish.api.engine.registry.factory;

import io.bloomish.api.engine.context.DefaultObjectRegistry;
import io.bloomish.api.engine.registry.BloomishRegister;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.neoforged.neoforge.registries.DeferredHolder;

public class RecipeSerializerFactory extends AbstractObjectFactory<RecipeSerializer<?>> {
    public RecipeSerializerFactory() {
        this(DefaultObjectRegistry.getFromInstance("$RecipeSerializers"));
    }

    public RecipeSerializerFactory(BloomishRegister<RecipeSerializer<?>> register) {
        super(register);
    }

    public <T extends Recipe<?>> DeferredHolder<RecipeSerializer<?>, RecipeSerializer<T>> create(String name, RecipeSerializer<T> recipeSerializer) {
        return this.create(name, () -> recipeSerializer);
    }
}