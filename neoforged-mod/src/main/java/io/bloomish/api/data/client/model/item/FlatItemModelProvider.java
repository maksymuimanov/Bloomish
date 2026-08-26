package io.bloomish.api.data.client.model.item;

import io.bloomish.api.channel.DataChannels;
import io.bloomish.api.channel.ValueChannelBus;
import io.bloomish.api.data.client.model.item.model.ItemModel;
import io.bloomish.api.data.client.model.item.model.LayeredItemModel;
import io.bloomish.api.data.client.model.item.spec.ItemModelSpec;
import io.bloomish.api.engine.metadata.annotation.injection.Injected;
import io.bloomish.api.util.MinecraftConstants;
import io.bloomish.api.util.RegistryUtils;
import io.bloomish.api.util.ResourceLocationUtils;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;

import java.util.Map;

@Injected
public class FlatItemModelProvider extends AbstractItemModelProvider {
    private static final String GENERATED_PATH = "generated";
    private static final String LAYER_0 = "layer0";
    private final ValueChannelBus channelBus;

    public FlatItemModelProvider(PackOutput packOutput, ValueChannelBus channelBus) {
        super(packOutput);
        this.channelBus = channelBus;
    }

    @Override
    protected void registerData() {
        this.channelBus.<ItemModelSpec<? extends Item>>forEachDrain(DataChannels.ITEM_MODEL_PROVIDER_FLAT_ITEMS, spec -> {
            Item item = spec.getItem();
            String parent = ResourceLocationUtils.joinNamespacedPath(MinecraftConstants.MINECRAFT, ITEM_PATH, GENERATED_PATH);
            String path = RegistryUtils.findItemNamespacedPath(item, ITEM_PATH);
            Map<String, String> textures = Map.of(LAYER_0, path);
            ItemModel itemModel = new LayeredItemModel(parent, textures);
            this.addItemModel(item, itemModel);
        });
    }
}
