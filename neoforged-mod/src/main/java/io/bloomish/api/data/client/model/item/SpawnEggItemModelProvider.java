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
public class SpawnEggItemModelProvider extends AbstractItemModelProvider {
    private static final String TEMPLATE_SPAWN_EGG_PATH = "template_spawn_egg";
    private final ValueChannelBus channelBus;

    public SpawnEggItemModelProvider(PackOutput packOutput, ValueChannelBus channelBus) {
        super(packOutput);
        this.channelBus = channelBus;
    }

    @Override
    protected void registerData() {
        this.channelBus.<ItemModelSpec<? extends Item>>forEachDrain(DataChannels.ITEM_MODEL_PROVIDER_SPAWN_EGG_ITEMS, spec -> {
            Item item = spec.getItem();
            String parent = this.minecraftPath(ITEM_PATH, TEMPLATE_SPAWN_EGG_PATH);
            ItemModel itemModel = BasicItemModel.ofParent(parent);
            this.addItemModel(item, itemModel);
        });
    }
}
