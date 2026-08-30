package io.bloomish.api.data.client.model.item;

import io.bloomish.api.channel.DataChannels;
import io.bloomish.api.channel.ValueChannelBus;
import io.bloomish.api.data.client.model.item.model.BasicItemModel;
import io.bloomish.api.data.client.model.item.model.ItemModel;
import io.bloomish.api.data.client.model.item.spec.ItemModelSpec;
import io.bloomish.api.engine.metadata.annotation.injection.Injected;
import io.bloomish.api.util.RegistryUtils;
import io.bloomish.api.util.ResourceLocationUtils;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;

import java.util.List;

@Injected
public class PotionItemModelProvider extends AbstractItemModelProvider {
    private static final String POTION_OVERLAY_PATH = "potion_overlay";
    private final ValueChannelBus channelBus;

    public PotionItemModelProvider(PackOutput packOutput, ValueChannelBus channelBus) {
        super(packOutput);
        this.channelBus = channelBus;
    }

    @Override
    protected void registerData() {
        this.channelBus.<ItemModelSpec<? extends Item>>forEachDrain(DataChannels.ITEM_MODEL_PROVIDER_POTION_ITEMS, spec -> {
            Item item = spec.getItem();
            String parent = ResourceLocationUtils.joinMinecraftPath(ITEM_PATH, GENERATED_PATH);
            String layer0 = ResourceLocationUtils.joinMinecraftPath(ITEM_PATH, POTION_OVERLAY_PATH);
            String layer1 = RegistryUtils.findItemNamespacedPath(item, ITEM_PATH);
            ItemModel itemModel = BasicItemModel.ofLayers(parent, List.of(layer0, layer1));
            this.addItemModel(item, itemModel);
        });
    }
}
