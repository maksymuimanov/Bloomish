package io.bloomish.api.data.client.model.item;

import io.bloomish.api.channel.DataChannels;
import io.bloomish.api.channel.ValueChannelBus;
import io.bloomish.api.data.client.model.item.model.ItemModel;
import io.bloomish.api.data.client.model.item.model.LayeredItemModel;
import io.bloomish.api.engine.metadata.annotation.injection.Injected;
import net.minecraft.core.Holder;
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
        this.channelBus.<Holder<? extends Item>>forEachDrain(DataChannels.ITEM_MODEL_PROVIDER_POTION_ITEMS, holder -> {
            Item item = holder.value();
            String parent = this.minecraftPath(ITEM_PATH, GENERATED_PATH);
            String layer0 = this.minecraftPath(ITEM_PATH, POTION_OVERLAY_PATH);
            String layer1 = this.itemPath(item);
            ItemModel itemModel = LayeredItemModel.ofLayers(parent, List.of(layer0, layer1));
            this.addItemModel(item, itemModel);
        });
    }
}
