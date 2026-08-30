package io.bloomish.api.data.client.model.item;

import io.bloomish.api.channel.DataChannels;
import io.bloomish.api.channel.ValueChannelBus;
import io.bloomish.api.data.client.model.item.model.BasicItemModel;
import io.bloomish.api.data.client.model.item.model.ItemModel;
import io.bloomish.api.data.client.model.item.spec.ItemModelSpec;
import io.bloomish.api.engine.metadata.annotation.injection.Injected;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;

@Injected
public class FlatItemModelProvider extends AbstractItemModelProvider {
    private final ValueChannelBus channelBus;

    public FlatItemModelProvider(PackOutput packOutput, ValueChannelBus channelBus) {
        super(packOutput);
        this.channelBus = channelBus;
    }

    @Override
    protected void registerData() {
        this.channelBus.<ItemModelSpec<? extends Item>>forEachDrain(DataChannels.ITEM_MODEL_PROVIDER_FLAT_ITEMS, spec -> {
            Item item = spec.getItem();
            String parent = this.minecraftPath(ITEM_PATH, GENERATED_PATH);
            String path = this.itemPath(item);
            ItemModel itemModel = BasicItemModel.ofLayer(parent, path);
            this.addItemModel(item, itemModel);
        });
    }
}
