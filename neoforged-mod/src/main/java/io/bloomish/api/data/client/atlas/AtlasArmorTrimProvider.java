package io.bloomish.api.data.client.atlas;

import io.bloomish.api.data.AbstractMultiDataProvider;
import io.bloomish.api.data.DataTarget;
import io.bloomish.api.data.client.ClientDataProvider;
import io.bloomish.api.engine.metadata.annotation.injection.Injected;
import net.minecraft.data.PackOutput;

@Injected
public class AtlasArmorTrimProvider extends AbstractMultiDataProvider implements ClientDataProvider {
    private static final DataTarget DATA_TARGET = DataTarget.createMinecraftAsset("atlases", "armor_trims");
    private final AtlasArmorTrimFactory atlasArmorTrimFactory;

    public AtlasArmorTrimProvider(PackOutput packOutput, AtlasArmorTrimFactory atlasArmorTrimFactory) {
        super(packOutput);
        this.atlasArmorTrimFactory = atlasArmorTrimFactory;
    }

    @Override
    protected void registerData() {
        AtlasArmorTrim atlasArmorTrim = this.atlasArmorTrimFactory.createAtlasArmorTrim();
        this.addData(DATA_TARGET, atlasArmorTrim);
    }
}