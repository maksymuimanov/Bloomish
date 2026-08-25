package io.bloomish.api.engine.registry.factory;

import io.bloomish.api.engine.context.DefaultObjectRegistry;
import io.bloomish.api.engine.registry.BloomishRegister;
import io.bloomish.api.util.DeprecatedResourceUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.saveddata.maps.MapDecorationType;
import net.neoforged.neoforge.registries.DeferredHolder;

public class MapDecorationTypeFactory extends AbstractObjectFactory<MapDecorationType> {
    public MapDecorationTypeFactory() {
        this(DefaultObjectRegistry.getFromInstance("$MapDecorationTypes"));
    }

    public MapDecorationTypeFactory(BloomishRegister<MapDecorationType> register) {
        super(register);
    }

    public DeferredHolder<MapDecorationType, MapDecorationType> create(String name, boolean showOnItemFrame, int mapColor, boolean explorationMapElement, boolean trackCount) {
        return this.create(name, DeprecatedResourceUtils.createLocation(name), showOnItemFrame, mapColor, explorationMapElement, trackCount);
    }

    public DeferredHolder<MapDecorationType, MapDecorationType> create(String name, String assetId, boolean showOnItemFrame, int mapColor, boolean explorationMapElement, boolean trackCount) {
        return this.create(name, DeprecatedResourceUtils.parse(assetId), showOnItemFrame, mapColor, explorationMapElement, trackCount);
    }

    public DeferredHolder<MapDecorationType, MapDecorationType> create(String name, ResourceLocation assetId, boolean showOnItemFrame, int mapColor, boolean explorationMapElement, boolean trackCount) {
        return this.create(name, () -> new MapDecorationType(assetId, showOnItemFrame, mapColor, trackCount, explorationMapElement));
    }
}
