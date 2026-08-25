package io.bloomish.api.engine.registry.factory;

import io.bloomish.api.engine.context.DefaultObjectRegistry;
import io.bloomish.api.engine.registry.BloomishRegister;
import io.bloomish.api.util.DeprecatedResourceUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.DecoratedPotPattern;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Experimental
public class DecoratedPotPatternFactory extends AbstractObjectFactory<DecoratedPotPattern> {
    public DecoratedPotPatternFactory() {
        this(DefaultObjectRegistry.getFromInstance("$DecoratedPotPatterns"));
    }

    public DecoratedPotPatternFactory(BloomishRegister<DecoratedPotPattern> register) {
        super(register);
    }

    public DeferredHolder<DecoratedPotPattern, DecoratedPotPattern> create(String name) {
        ResourceLocation assetId = DeprecatedResourceUtils.createLocation(name);
        return this.create(name, () -> new DecoratedPotPattern(assetId));
    }
}
