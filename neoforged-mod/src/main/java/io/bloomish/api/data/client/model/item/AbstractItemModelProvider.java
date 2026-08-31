package io.bloomish.api.data.client.model.item;

import io.bloomish.api.data.client.model.AbstractModelProvider;
import io.bloomish.api.data.client.model.item.model.ItemModel;
import io.bloomish.api.data.client.model.item.model.LayeredItemModel;
import io.bloomish.api.util.RegistryUtils;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;

import java.util.List;
import java.util.Map;

public abstract class AbstractItemModelProvider extends AbstractModelProvider<ItemModel> {
    protected static final String ITEM_PATH = "item";
    protected static final String GENERATED_PATH = "generated";

    protected AbstractItemModelProvider(PackOutput packOutput) {
        super(packOutput);
    }

    protected void addItemModel(Item item, ItemModel itemModel) {
        this.addItemModel(item, itemModel, "");
    }

    protected void addItemModel(Item item, ItemModel itemModel, String suffix) {
        this.addModel(RegistryUtils.findItemPath(item), itemModel, ITEM_PATH, suffix);
    }

    protected String itemPath(Item item) {
        return RegistryUtils.findItemNamespacedPath(item, ITEM_PATH);
    }

    protected void createSingleLayerOverrideModel(
            String suffix,
            Item item,
            String parent,
            String path,
            Map<String, Number> predicate,
            List<LayeredItemModel.Override> overrides
    ) {
        String modelPath = path + suffix;
        LayeredItemModel.Override override = new LayeredItemModel.Override(modelPath, predicate);
        overrides.add(override);
        ItemModel itemModel = LayeredItemModel.ofLayer(parent, modelPath);
        this.addItemModel(item, itemModel, suffix);
    }
}
