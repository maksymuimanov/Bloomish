package io.bloomish.api.data.client.model.item;

import io.bloomish.api.data.AbstractMultiDataProvider;
import io.bloomish.api.data.DataTarget;
import io.bloomish.api.data.client.ClientDataProvider;
import io.bloomish.api.data.client.model.item.model.BasicItemModel;
import io.bloomish.api.data.client.model.item.model.ItemModel;
import io.bloomish.api.util.RegistryUtils;
import io.bloomish.api.util.ResourceLocationUtils;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;

import java.util.List;
import java.util.Map;

public abstract class AbstractItemModelProvider extends AbstractMultiDataProvider implements ClientDataProvider {
    protected static final String MODELS_PATH = "models";
    protected static final String ITEM_PATH = "item";
    protected static final String GENERATED_PATH = "generated";

    protected AbstractItemModelProvider(PackOutput packOutput) {
        super(packOutput);
    }

    protected void addItemModel(Item item, ItemModel itemModel) {
        DataTarget dataTarget = DataTarget.createModAsset(MODELS_PATH, ITEM_PATH, RegistryUtils.findItemPath(item));
        this.addData(dataTarget, itemModel);
    }

    protected void addItemModel(Item item, ItemModel itemModel, String suffix) {
        DataTarget dataTarget = DataTarget.createModAsset(MODELS_PATH, ITEM_PATH, RegistryUtils.findItemPath(item) + suffix);
        this.addData(dataTarget, itemModel);
    }

    protected String itemPath(Item item) {
        return RegistryUtils.findItemNamespacedPath(item, ITEM_PATH);
    }

    protected String minecraftPath(String pathPart, String... pathParts) {
        return ResourceLocationUtils.joinMinecraftPath(pathPart, pathParts);
    }

    protected String modPath(String pathPart, String... pathParts) {
        return ResourceLocationUtils.joinModPath(pathPart, pathParts);
    }

    protected void createSingleLayerOverrideModel(
            String suffix,
            Item item,
            String parent,
            String path,
            Map<String, Number> predicate,
            List<BasicItemModel.Override> overrides
    ) {
        String modelPath = path + suffix;
        BasicItemModel.Override override = new BasicItemModel.Override(modelPath, predicate);
        overrides.add(override);
        ItemModel itemModel = BasicItemModel.ofLayer(parent, modelPath);
        this.addItemModel(item, itemModel, suffix);
    }
}
