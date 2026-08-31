package io.bloomish.api.data.client.model.item;

import io.bloomish.api.channel.DataChannels;
import io.bloomish.api.channel.ValueChannelBus;
import io.bloomish.api.data.client.model.item.model.ItemModel;
import io.bloomish.api.data.client.model.item.model.LayeredItemModel;
import io.bloomish.api.engine.metadata.annotation.injection.Injected;
import net.minecraft.core.Holder;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Injected
public class BowItemModelProvider extends AbstractItemModelProvider {
    private static final String BOW_PATH = "bow";
    private static final String PULLING_PATH = "pulling";
    private static final String PULL_PATH = "pull";
    private static final int IS_PULLING = 1;
    private static final float IS_HALF_PULLED = 0.65F;
    private static final float IS_NEARLY_END_PULLED = 0.9F;
    private static final String PULLING_IDENTIFIER = "_pulling_";
    private final ValueChannelBus channelBus;

    public BowItemModelProvider(PackOutput packOutput, ValueChannelBus channelBus) {
        super(packOutput);
        this.channelBus = channelBus;
    }

    @Override
    protected void registerData() {
        this.channelBus.<Holder<? extends Item>>forEachDrain(DataChannels.ITEM_MODEL_PROVIDER_BOW_ITEMS, holder -> {
            Item item = holder.value();
            String parent = this.minecraftPath(ITEM_PATH, BOW_PATH);
            String path = this.itemPath(item);
            List<LayeredItemModel.Override> overrides = this.createOverrides(item, path, parent);
            ItemModel itemModel = LayeredItemModel.ofLayer(parent, path, overrides);
            this.addItemModel(item, itemModel);
        });
    }

    private List<LayeredItemModel.Override> createOverrides(Item item, String parent, String path) {
        List<LayeredItemModel.Override> overrides = new ArrayList<>();
        this.createFirstPulling(item, parent, path, overrides);
        this.createSecondPulling(item, parent, path, overrides);
        this.createThirdPulling(item, parent, path, overrides);
        return overrides;
    }

    private void createFirstPulling(Item item, String parent, String path, List<LayeredItemModel.Override> overrides) {
        int index = 0;
        Map<String, Number> predicate = Map.of(
                this.minecraftPath(PULLING_PATH), IS_PULLING
        );
        this.createPulling(index, item, parent, path, predicate, overrides);
    }

    private void createSecondPulling(Item item, String parent, String path, List<LayeredItemModel.Override> overrides) {
        int index = 1;
        Map<String, Number> predicate = Map.of(
                this.minecraftPath(PULL_PATH), IS_HALF_PULLED,
                this.minecraftPath(PULLING_PATH), IS_PULLING
        );
        this.createPulling(index, item, parent, path, predicate, overrides);
    }

    private void createThirdPulling(Item item, String parent, String path, List<LayeredItemModel.Override> overrides) {
        int index = 2;
        Map<String, Number> predicate = Map.of(
                this.minecraftPath(PULL_PATH), IS_NEARLY_END_PULLED,
                this.minecraftPath(PULLING_PATH), IS_PULLING
        );
        this.createPulling(index, item, parent, path, predicate, overrides);
    }

    private void createPulling(
            int index,
            Item item,
            String parent,
            String path,
            Map<String, Number> predicate,
            List<LayeredItemModel.Override> overrides
    ) {
        String pullingModelSuffix = PULLING_IDENTIFIER + index;
        this.createSingleLayerOverrideModel(pullingModelSuffix, item, parent, path, predicate, overrides);
    }
}