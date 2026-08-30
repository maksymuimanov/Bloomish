package io.bloomish.api.data.client.model.item;

import io.bloomish.api.channel.DataChannels;
import io.bloomish.api.channel.ValueChannelBus;
import io.bloomish.api.data.client.model.item.model.BasicItemModel;
import io.bloomish.api.data.client.model.item.model.ItemModel;
import io.bloomish.api.data.client.model.item.spec.ItemModelSpec;
import io.bloomish.api.engine.metadata.annotation.injection.Injected;
import io.bloomish.api.util.RegistryUtils;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;

@Injected
public class ParentBlockItemModelProvider extends AbstractItemModelProvider {
    private static final String BLOCK_PATH = "block";
    private final ValueChannelBus channelBus;

    public ParentBlockItemModelProvider(PackOutput packOutput, ValueChannelBus channelBus) {
        super(packOutput);
        this.channelBus = channelBus;
    }

    @Override
    protected void registerData() {
        this.channelBus.<ItemModelSpec<? extends Item>>forEachDrain(DataChannels.ITEM_MODEL_PROVIDER_PARENT_BLOCK_ITEMS, spec -> {
            Item item = spec.getItem();
            String path = this.blockPath(item);
            ItemModel itemModel = BasicItemModel.ofParent(path);
            this.addItemModel(item, itemModel);
        });
    }

    private String blockPath(Item item) {
        return RegistryUtils.findItemNamespacedPath(item, BLOCK_PATH);
    }
}
