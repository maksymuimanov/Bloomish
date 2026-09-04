package io.bloomish.api.data.client.model.item;

import io.bloomish.api.channel.DataChannels;
import io.bloomish.api.channel.ValueChannelBus;
import io.bloomish.api.data.client.model.item.model.ItemModel;
import io.bloomish.api.data.client.model.item.model.LayeredItemModel;
import io.bloomish.api.engine.metadata.annotation.injection.Injected;
import io.bloomish.api.util.RegistryPathUtils;
import io.bloomish.api.util.StringUtils;
import net.minecraft.core.Holder;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

@Injected
public class ParentButtonBlockItemModelProvider extends AbstractItemModelProvider {
    private static final String BLOCK_PATH = "block";
    private static final String INVENTORY_SUFFIX = "inventory";
    private final ValueChannelBus channelBus;

    public ParentButtonBlockItemModelProvider(PackOutput packOutput, ValueChannelBus channelBus) {
        super(packOutput);
        this.channelBus = channelBus;
    }

    @Override
    protected void registerData() {
        this.channelBus.<Holder<? extends BlockItem>>forEachDrain(DataChannels.ITEM_MODEL_PROVIDER_BUTTON_PARENT_BLOCK_ITEMS, holder -> {
            Item item = holder.value();
            String path = this.blockPath(item);
            ItemModel itemModel = LayeredItemModel.ofParent(path);
            this.addItemModel(item, itemModel);
        });
    }

    private String blockPath(Item item) {
        String blockPath = RegistryPathUtils.findItemNamespacedPath(item, BLOCK_PATH);
        return StringUtils.joinWithUnderscore(blockPath, INVENTORY_SUFFIX);
    }
}
