package io.bloomish.api.engine.registry.factory;

import io.bloomish.api.engine.context.DefaultObjectRegistry;
import io.bloomish.api.engine.registry.TemporalRegister;
import io.bloomish.api.util.ResourceUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.FrogVariant;
import net.neoforged.neoforge.registries.DeferredHolder;

public class FrogVariantFactory extends AbstractObjectFactory<FrogVariant> {
    public static final String ENTITY_CAT_PATH = "textures/entity/frog/%s.png";

    public FrogVariantFactory() {
        this(DefaultObjectRegistry.getFromInstance("$FrogVariants"));
    }

    public FrogVariantFactory(TemporalRegister<FrogVariant> register) {
        super(register);
    }

    public DeferredHolder<FrogVariant, FrogVariant> create(String name) {
        String texturePath = ENTITY_CAT_PATH.formatted(name);
        ResourceLocation texture = ResourceUtils.createLocation(texturePath);
        return this.create(name, () -> new FrogVariant(texture));
    }
}
